package standard.mvc.component.business.baroboard.board.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.AttachedFile;
import standard.mvc.component.business.baroboard.board.vo.Comment;
import standard.mvc.component.business.baroboard.board.vo.Like;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.user.manage.user.service.UserManageService;
import standard.mvc.component.business.baroboard.user.note.vo.UserNoteAttachFile;
import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.security.login.vo.SecureUserLogin;

/**
 * Modification Information
 * 
 * @ author 전경훈
 * 
 * @since 2015. 5. 25.
 * @version 1.0
 * @see <pre>
 * Class Name  : BoardController.java
 * Description : 바로보드-게시판 Controller 
 * Information : 게시판의 글, 코멘트 등을 관리하는 컨트롤러
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일                 수정자                     수정내용
 * -------      ------------  -----------------------
 * 2015. 5. 26.      전경훈      최초 생성
 * 2015. 6.  3.      전경훈      showIndexPage, searchArticle 추가  
 * 2015. 6. 13.      전경훈      submitNewArticle 추가
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController extends GenericAbstractController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private UserManageService userManageService;

	@Override
	public Map<String, Map<String, Object>> bindTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int getTotalPages(int totCnt, int pageSize) {
		int pages = 0;
		
		if(totCnt == 0) { // zero check
			pages = 1;
		} else {
			if(totCnt % pageSize == 0) {
				pages = totCnt / pageSize;
			} else {
				pages = totCnt / pageSize + 1;
			}
		}
		return pages;
	}

	
	@RequestMapping(value = "/index.do", method = { RequestMethod.GET })
	public String showIndexPage(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		// TODO : pageNum 검증, boardID 검증
		// TODO : 허용된사용자 여부
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String isGuestUser = "";
		if(user instanceof String) {
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				isGuestUser = "1";	// 게스트
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {
			isGuestUser = "0";		// 일반사용자
		}
		
		String boardID = article.getBoardID();
		
		List<Article> articleList = boardService.getArticleList(article);
		modelMap.addAttribute("articleList", articleList);
		
		int totPages = this.getTotalPages(articleList.get(0).getTotCnt(), article.getPageSize());  
		
		// 1페이지일 경우, 공지사항을 보여준다.
		if(article.getPageNum() == 1) {
			List<Article> announceList = boardService.getAnnounceList(article);
			modelMap.addAttribute("announceList", announceList);
		}
		
		// 좌측 화살표  
		if(article.getPageNum() > article.getPageSize()) {
			int leftPage = (((article.getPageNum() / 10) - 1) * 10) + 1;
			modelMap.addAttribute("leftPage", leftPage);
		}
		
		// a링크 ( 단위 : 10 )
		int startPageNum = ((article.getPageNum() - 1) / 10 ) * 10 + 1;
		int endPageNum = (totPages - 1) / 10 == (article.getPageNum() - 1) / 10 ? totPages : ((article.getPageNum() - 1) / 10 + 1) * 10;
		modelMap.addAttribute("startPageNum", startPageNum);
		modelMap.addAttribute("endPageNum", endPageNum);
		modelMap.addAttribute("currentPageNum", article.getPageNum());
		
		// 우측 화살표
		if(totPages > ((article.getPageNum() - 1) / article.getPageSize() + 1) * 10) {
			int rightPage = ((article.getPageNum() - 1) / article.getPageSize() + 1) * 10 + 1;
			modelMap.addAttribute("rightPage",rightPage);
		}
		
		modelMap.addAttribute("isGuestUser", isGuestUser);
		modelMap.addAttribute("boardID", boardID);
		modelMap.addAttribute("pageName", "테스트게시판");
		
		return "/jsp/board/index";
	}

	
	@RequestMapping(value = "/searchArticle.do", method = { RequestMethod.GET })
	public String searchArticle(ModelMap modelMap, @ModelAttribute SearchArticle searchArticle) throws Exception {
		
		List<Article> searchedArticleList = boardService.searchArticleList(searchArticle);
		
		if(searchedArticleList.size() == 0) { // 검색결과 없음	
			
		} else {
			int totPages = this.getTotalPages(searchedArticleList.get(0).getTotCnt(), searchArticle.getPageSize()); 
			// 좌측 화살표  
			if(searchArticle.getPageNum() > searchArticle.getPageSize()) {
				int leftPage = (((searchArticle.getPageNum() / 10) - 1) * 10) + 1;
				modelMap.addAttribute("leftPage", leftPage);
			}
			
			// a링크 ( 단위 : 10 )
			int startPageNum = ((searchArticle.getPageNum() - 1) / 10 ) * 10 + 1;
			int endPageNum = (totPages - 1) / 10 == (searchArticle.getPageNum() - 1) / 10 ? totPages : ((searchArticle.getPageNum() - 1) / 10 + 1) * 10;
			modelMap.addAttribute("startPageNum", startPageNum);
			modelMap.addAttribute("endPageNum", endPageNum);
			modelMap.addAttribute("currentPageNum", searchArticle.getPageNum());
			
			logger.debug("--- JKH ---");
			logger.debug("startPageNum "+ startPageNum);
			logger.debug("endPageNum "+ endPageNum);
			logger.debug("currentPageNum "+ searchArticle.getPageNum());
			logger.debug("totCnt "+ totPages);
			
			
			// 우측 화살표
			if(totPages > ((searchArticle.getPageNum() - 1) / searchArticle.getPageSize() + 1) * 10) {
				int rightPage = ((searchArticle.getPageNum() - 1) / searchArticle.getPageSize() + 1) * 10 + 1;
				modelMap.addAttribute("rightPage",rightPage);
			}
			
		}
		
		
		
		modelMap.addAttribute("reqSearchArticle", searchArticle);
		modelMap.addAttribute("articleList", searchedArticleList);
		return "/jsp/board/searchArticle";
	}
	
	@RequestMapping(value = "/readArticle.do")
	public String readArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String isGuestUser = "";
		int loginedUserID;
		if(user instanceof String) {
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				isGuestUser = "1";	// 게스트
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {
			isGuestUser = "0";		// 일반사용자
			SecureUserLogin loginedUser = (SecureUserLogin) user;
			loginedUserID = loginedUser.getId();
			article.setUserID(loginedUserID);
			modelMap.addAttribute("loginedUserID", loginedUserID);
		}
		
		Article targetArticle = boardService.readArticle(article);
		Comment comment = new Comment();
		comment.setArticleID(article.getC_id());
		List<Comment> commentList = boardService.getCommentList(comment);
		
		
		
		
		modelMap.addAttribute("isGuestUser", isGuestUser);
		modelMap.addAttribute("article", targetArticle);
		modelMap.addAttribute("commentList", commentList);
		return "/jsp/board/readArticle";
	}

	@RequestMapping(value = "/newArticle.do")
	public String newArticle(ModelMap modelMap) throws Exception {
		String jspView = "";
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				modelMap.addAttribute("isGuestFL", "1");
				logger.debug("게스트사용자");
				jspView = "/jsp/board/newGuestArticle";
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {	// 로그인 사용자
			modelMap.addAttribute("isGuestFL", "0");
			jspView = "/jsp/board/newArticle";
			logger.debug("일반사용자");
		}
		
		return jspView;
	}
	
	@RequestMapping(value = "/newReplyArticle.do")
	public String newReplyArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		Article parentArticle = boardService.getArticleById(article);
		String jspView = "";
		
		Object user = (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof String) { // 익명 사용자
			String userStr = (String)user;
			if(userStr.equals("anonymousUser")) {
				modelMap.addAttribute("isGuestFL", "1");
				logger.debug("게스트사용자");
				jspView = "/jsp/board/newGuestArticle";
			} else {
				throw new Exception("허가되지 않은 사용자입니다.");
			}
		} else {	// 로그인 사용자
			modelMap.addAttribute("isGuestFL", "0");
			jspView = "/jsp/board/newArticle";
			logger.debug("일반사용자");
		}
		
		modelMap.addAttribute("parentArticle", parentArticle);
		return jspView;
	}
	
	@RequestMapping(value = "/submitNewArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<Article> submitNewArticle(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Article article) throws Exception {
		
		if(request instanceof MultipartHttpServletRequest){
			List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("files");
			if(files != null) {
				// 빈 파일이면 삭제
				// TODO : 파일업로드 허용수 제한
				Iterator<MultipartFile> itr = files.iterator();
				List<AttachedFile> attachedFiles = new ArrayList<AttachedFile>();
				while(itr.hasNext()) {
					MultipartFile file = itr.next();
					if("".equals(file.getOriginalFilename())) {
						itr.remove();
					} else {
						AttachedFile attachedFile = new AttachedFile();
						attachedFile.setFile(file);
						attachedFiles.add(attachedFile);
					}
				}
				if(attachedFiles.size() != 0) {
					article.setAttachedFiles(attachedFiles);
					String contextPath = request.getSession().getServletContext().getRealPath("/");
					article.setContextPath(contextPath);
				}
			}
		}
		
		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		Article resultArticle = boardService.addArticle(article);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<Article>(resultArticle, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/submitNewReplyArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Article submitNewReplyArticle(@ModelAttribute Article article) throws Exception {
		return boardService.addReplyArticle(article);
	}

	@RequestMapping(value = "/modifyArticle.do")
	public String modifyArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		/* TODO : 시큐리티 및 계정 붙으면 수권한 체크하기 */
		Article resultArticle = boardService.getArticleById(article);
		modelMap.addAttribute("article", resultArticle);
		return "/jsp/board/modifyArticle";
	}

	@RequestMapping(value = "/submitModifiedArticle.do")
	@ResponseBody
	public Article submitModifiedArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		return boardService.modifyArticle(article);
	}

	@RequestMapping(value = "/deleteArticle.do")
	@ResponseBody
	public Article deleteArticle(ModelMap modelMap, @ModelAttribute Article article) throws Exception {
		/* TODO : 시큐리티 및 계정 붙으면 삭제권한 체크하기 */
		Article result = boardService.removeArticle(article);
		return result;
	}
	
	@RequestMapping(value = "/getUserInfoPopup.do")
	public String getUserInfoByID(ModelMap modelMap, @ModelAttribute User user) throws Exception {
		User resultUser = userManageService.getUserInfoByID(user);
		modelMap.addAttribute("user", resultUser);
		return "/jsp/board/getUserInfoPopup";
	}
	
	@RequestMapping(value = "/sendNotePopup.do")
	public String sendNotePopup(ModelMap modelMap) throws Exception {
		/* TODO : 쪽지기능 완성시 서비스 붙이기 */
		return "/jsp/board/sendNotePopup";
	}
	
	@RequestMapping(value = "/addComment.do")
	@ResponseBody
	public Comment addComment(@ModelAttribute Comment comment) throws Exception {
		
		return boardService.addComment(comment);
		
	}
	
	@RequestMapping(value = "/deleteComment.do")
	@ResponseBody
	public Comment deleteComment(@ModelAttribute Comment comment) throws Exception {
		return boardService.deleteComment(comment);
	}
	
	@RequestMapping(value = "/likeArticle.do")
	@ResponseBody
	public Like likeArticle(@ModelAttribute Like like) throws Exception {
		return boardService.likeArticle(like);
	}
	
	@RequestMapping(value = "/cancelLikeArticle.do")
	@ResponseBody
	public Like cancleLikeArticle(@ModelAttribute Like like) throws Exception {
		return boardService.cancelLikeArticle(like);
	}
	
}

