package standard.mvc.component.business.baroboard.board.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import standard.mvc.component.business.baroboard.board.dao.BoardDao;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.AttachedFile;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.Like;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.board.vo.TotalArticle;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

/**
 * Modification Information
 * 
 * @author 전경훈
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardServiceImpl.java
 * Description : 바로보드-게시판-글관리 Service 구현체
 * Information : 
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 25.      전경훈        최초 생성
 * 2015. 6. 14.		 전경훈		 addArticle 추가
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value = "BoardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private TotalArticleService totalArticleService;

	@Resource(name = "fileUploadProperties")
	private Properties fileUploadProperties;
	
	@Override
	public List<Article> getArticleList(Article article) throws Exception {
		List<Article> list = boardDao.getArticleListByPage(article);
		return list;
	}

	@Override
	public List<Article> getAnnounceList(Article article) throws Exception {
		List<Article> list = boardDao.getAnnounceList(article);
		return list;
	}
	
	@Override
	public List<Article> searchArticleList(SearchArticle searchArticle) throws Exception {
		List<Article> list = boardDao.searchArticle(searchArticle);
		return list;
	}
	
	@Override
	public Article getArticleById(Article article) throws Exception {
		return boardDao.getArticleById(article);
	}
	
	@Override
	public int getOpenArticleCnt(Article article) throws Exception {
		return boardDao.getOpenArticleCnt(article);
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(article.getIsGuestFL().equals("0")) {	// 일반 사용자
			SecureUserLogin userLogin = (SecureUserLogin) user;
			article.setRegID(userLogin.getId());
			
		} else {									// 게스트 사용자
			if(user instanceof String) {
				String userStr = (String)user;
				if(! userStr.equals("anonymousUser")) {
					throw new Exception("허가되지 않은 사용자입니다.");
				} 
			}
		}
		/* 1. 파일업로드, 2.게시글 업로드, 3.파일update(게시글ID) 
		 * 파일 업로드 실패 및 DB insert 실패시, 파일 삭제 및 DB 삭제 
		 * */
		
		/* 1. 파일 업로드 및 DB insert */
		if(article.getAttachedFiles() != null)  {
			this.fileUpload(article);
		}
		
		/* 2. 게시글 insert */
		article.setRef(2);
		this.setupArticleParameters(article);
		
		Article insertedArticle = coreService.addNode(article);
		article.setC_id(insertedArticle.getId());
		boardDao.updateRootArticleID(article);
		
		/* 3. 추가된 파일에 articleID 지정 */
		if(article.getAttachedFiles() != null) {
			this.setArticleIDOfFiles(article);
		}
		
		/* T_TOTAL_ARTICLE Insert */
		TotalArticle totalArticle = this.setTotalArticleByArticle(article);
		coreService.addNode(totalArticle);
		
		return article;
	}
	
	
	/** 저장된 파일에 articleID 를 지정한다. 
	 * @param article
	 * @throws Exception
	 */
	private void setArticleIDOfFiles(Article article) throws Exception {
		List<AttachedFile> files = article.getAttachedFiles();
		for (AttachedFile attachedFile : files) {
			attachedFile.setArticleID(article.getC_id());
			coreService.alterNode(attachedFile);
		}
	}

	/** 
	 * 파일 업로드를 수행한다.
	 * @param article
	 * @throws Exception
	 */
	private void fileUpload(Article article) throws Exception {
		
		String defaultPath = article.getContextPath();
		String uploadPath = fileUploadProperties.getProperty("article.upload.dir");
		uploadPath = defaultPath + uploadPath + article.getBoardID() + "/";		
		
		List<AttachedFile> files = article.getAttachedFiles();
		String savedFilePath = "";
		
		
		/* 1.모든 파일 업로드 */
		try {
			File saveFolder = new File(uploadPath);
			// 디렉토리 생성
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}
			
			// TODO : 20150827기준 익명사용자는 고려하지 않음
			for (AttachedFile attachedFile : files) {
				MultipartFile file = attachedFile.getFile();
				String savedFileNM = article.getRegID() + "_" + System.currentTimeMillis();
				String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
				
				attachedFile.setC_title(file.getOriginalFilename());;
				attachedFile.setSavedFileNM(savedFileNM);
				attachedFile.setExtension(fileExt);
				
				savedFilePath = uploadPath + savedFileNM;
				
				file.transferTo(new File(savedFilePath));
			}
		} catch(Exception e) {
			// 문제 발생시 모든 파일 삭제
			this.deleteSavedFiles(files, uploadPath);
			throw new Exception("파일 업로드 에러");
		}
		
		/* 2.모든 파일 DB insert */
		try {
			this.insertFileInfo(files);
		} catch(Exception e) {
			/* 2.에러처리 - DB 삭제 및 파일 삭제 */
			this.deleteSavedFiles(files, uploadPath);
			throw new Exception("파일 DB 저장 에러");
		}
	}

	/** 
	 * 파일 리스트 삭제 
	 */
	private void deleteSavedFiles(List<AttachedFile> files, String uploadPath) {
		for (AttachedFile attachedFile : files) {
			String savedFileNM = attachedFile.getSavedFileNM();
			if(savedFileNM != null) {
				String savedFilePath = uploadPath + savedFileNM;
				File f = new File(savedFilePath);
				if(f.exists()) f.delete();
			}
		}
	}
	
	/**
	 * 파일내역 DB Insert
	 */
    @Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
	private void insertFileInfo(List<AttachedFile> files) throws Exception {
		for (AttachedFile attachedFile : files) {
			attachedFile.setRef(2);
			attachedFile.setC_type("default");
			attachedFile.setRegDt(this.getTodayFor14Digits());
			AttachedFile insertedFile = coreService.addNode(attachedFile);
			attachedFile.setC_id(insertedFile.getId());
		}
	}
	
	@Override
	public Article addReplyArticle(Article article) throws Exception {
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(article.getIsGuestFL().equals("0")) {	// 일반 사용자
			SecureUserLogin userLogin = (SecureUserLogin) user;
			article.setRegID(userLogin.getId());
			
		} else {									// 게스트 사용자
			if(user instanceof String) {
				String userStr = (String)user;
				if(! userStr.equals("anonymousUser")) {
					throw new Exception("허가되지 않은 사용자입니다.");
				} 
			}
		}
		this.setupArticleParameters(article);
		
		Article insertedArticle = coreService.addNode(article);
		article.setC_id(insertedArticle.getId());
		/* T_TOTAL_ARTICLE Insert */
		TotalArticle totalArticle = this.setTotalArticleByArticle(article);
		coreService.addNode(totalArticle);
		
		return article;
	}
	
	@Override
	public Article removeArticle(Article article) throws Exception {
		/** 삭제는 C_IS_DELETED_FL 을 1로 업데이트 함 */
		article = coreDao.getNode(article);
		
		// TODO : 권한체크
		
		article.setIsDeletedFL("1");
		
		if(coreDao.alterNode(article) != 1) {
			throw new Exception("데이터 정합성 오류");
		}
		TotalArticle totalArticle = this.setTotalArticleByArticle(article);
		totalArticleService.updateIsDeletedFLByBoardIdAndArticleID(totalArticle);
		
		return article;
	}

	@Override
	public Article readArticle(Article inputArticle) throws Exception {
		this.countUpViewCnt(inputArticle);
		// TODO : 권한체크
		Article article = this.getArticleById(inputArticle);
		if(article.getHasAttachedFileFL() != null && article.getHasAttachedFileFL().equals("1")) {
			this.getAttachedFilesInfoByArticleID(article);
		}
		
		return article;
	}

	private void getAttachedFilesInfoByArticleID(Article article) throws Exception {
		AttachedFile input = new AttachedFile();
		input.setArticleID(article.getC_id());
		List<AttachedFile> fileList = boardDao.getAttachedFilesInfoByArticleID(input);
		article.setAttachedFiles(fileList);
	}

	@Override
	public Article modifyArticle(Article article) throws Exception {
		// TODO : 권한체크
		
		article.setContent(this.unescapeHtml(article.getContent()));
		
		article.setModDt(this.getTodayFor14Digits());
		int resultInt = boardDao.modifyArticle(article);  
		if(resultInt != 1){
			throw new Exception("데이터 정합성 오류");
		} 
		
		TotalArticle totalArticle = this.setTotalArticleByArticle(article);
		totalArticleService.updateTitleByBoardIdAndArticleID(totalArticle);
		
		return article;
	}

	private int countUpViewCnt(Article article) throws Exception {
		return boardDao.countUpViewCnt(article);
	}
	
	@Override
	public Comment addComment(Comment comment) throws Exception {
		comment.setC_type("folder");
		comment.setRegID(this.getLoginedUserID());
		comment.setRegDT(this.getTodayFor14Digits());
		Comment insertedComment = null;
		
		if("1".equals(comment.getIsRoot())) {
			comment.setRef(2);
			insertedComment = coreService.addNode(comment);
			insertedComment.setC_id(insertedComment.getId());
			boardDao.updateCommentRootID(comment);
			
		} else {
			insertedComment = coreService.addNode(comment);
		}
		return insertedComment;
	}

	private String getTodayFor14Digits() {
		Date today = new Date();
		String formattedDate = DateFormatUtils.format(today, "yyyyMMddHHmmss");
		return formattedDate;
	}

	@Override
	public List<Comment> getCommentList(Comment comment) throws Exception {
		List<Comment> commentList = boardDao.getCommentList(comment);
		/* 글 볼수 있는 권한 체크 */
		for(Comment c : commentList) {
			if("1".equals(comment.getViewOnlyRegIDFL()) && comment.getRegID() == this.getLoginedUserID() )	{ // TODO : 세션 붙이면 개인인증 확인, 게시글 RegID 확인 
				c.setViewForRegOnlyFL("1");
			} else {
				c.setViewForRegOnlyFL("0");
			}
		}
		return commentList;
	}

	@Override
	public Comment deleteComment(Comment comment) throws Exception {
		// TODO : 권한체크
		boardDao.deleteComment(comment);
		return comment;
	}

	@Override
	public Like likeArticle(Like like) throws Exception {
		// TODO : 권한체크
		like.setRegID(this.getLoginedUserID());
		like.setRef(2);
		return coreService.addNode(like);
	}

	@Override
	public Like cancelLikeArticle(Like like) throws Exception {
		// TODO : 권한체크
		like.setRegID(this.getLoginedUserID());
		Like targetLike = boardDao.getLikeByArticleIDAndRegID(like);
		coreService.removeNode(targetLike);
		return like;
	}

	/* escaped 된 html 을 원래 html로 변환함 */
	public String unescapeHtml(String str) {
		return StringEscapeUtils.unescapeHtml4(str);
	}
	
	/* 글 추가를 위한 공통 파라미터 설정 */
	private void setupArticleParameters(Article article) {
		article.setC_type("folder");
		article.setContent(this.unescapeHtml(article.getContent()));
		article.setRegDt(this.getTodayFor14Digits());
	}
	
	/* TOTAL ARTICLE vo 파라미터 설정 */
	private TotalArticle setTotalArticleByArticle(Article article) {
		TotalArticle totalArticle = new TotalArticle();
		
		totalArticle.setRef(2);
		totalArticle.setC_title(article.getC_title());
		totalArticle.setC_type("default");
		totalArticle.setBoardID("test"); // TODO : 동적게시판 ID 적용
		totalArticle.setArticleID(article.getC_id());
		totalArticle.setRegID(article.getRegID());
		totalArticle.setIsDeletedFL(article.getIsDeletedFL());
		totalArticle.setRegDt(article.getRegDt());
		
		return totalArticle;
	}
	
	/* 사용자 ID 가져오기 - 게스트사용자일 경우 0을 리턴 */
	private int getLoginedUserID() throws Exception {
		int loginedUserID;
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				loginedUserID = 0;
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {	// 로그인 사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
		}
		
		return loginedUserID;
	}

	@Override
	public AttachedFile getAttachedFileByID(AttachedFile reqFileInfo)
			throws Exception {
		return coreDao.getNode(reqFileInfo);
	}
	
}