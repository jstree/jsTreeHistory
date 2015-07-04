package standard.mvc.component.business.baroboard.board.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.dao.BoardDao;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.board.vo.SearchArticle;
import standard.mvc.component.business.baroboard.user.vo.User;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "CoreService")
	private CoreService coreService;
	
	@Resource(name = "CoreDao")
	private CoreDao coreDao;

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Article> getArticleList(Article article) throws Exception {
		List<Article> list = boardDao.getArticleListByPage(article);
		changeRegDTFormat(list);
		return list;
	}

	@Override
	public List<Article> getAnnounceList(Article article) throws Exception {
		List<Article> list = boardDao.getAnnounceList(article);
		changeRegDTFormat(list);
		return list;
	}
	
	@Override
	public List<Article> searchArticleList(SearchArticle searchArticle) throws Exception {
		List<Article> list = boardDao.searchArticle(searchArticle);
		changeRegDTFormat(list);
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
		article.setRef(2);
		this.setupArticleParameters(article);
		
		Article insertedArticle = coreService.addNode(article);
		insertedArticle.setC_id(insertedArticle.getId());
		boardDao.updateRootArticleID(insertedArticle);
		
		return insertedArticle;
	}
	
	@Override
	public Article addReplyArticle(Article article) throws Exception {
		this.setupArticleParameters(article);
		return coreService.addNode(article);
	}
	
	@Override
	public Article removeArticle(Article article) throws Exception {
		article = coreDao.getNode(article);
		Article result = null;
		
		if(coreDao.removeNode(article) == 1) {
			result = article;
		}
		return result;
	}

	@Override
	public Article readArticle(Article article) throws Exception {
		this.countUpViewCnt(article);
		Article resultArticle = this.getArticleById(article);
		return resultArticle;
	}

	@Override
	public Article modifyArticle(Article article) throws Exception {
		Article result = null;
		article.setContent(this.unescapeHtml(article.getContent()));
		
		Date today = new Date();
		String formattedDate = DateFormatUtils.format(today, "yyyyMMddHHmmss");
		article.setModDt(formattedDate);
		int resultInt = boardDao.modifyArticle(article);  
		if(resultInt == 1){
			result = article;
		}
		
		logger.debug("JKH: resultInt");
		logger.debug(resultInt+"");
		return result;
		
	}

	private int countUpViewCnt(Article article) throws Exception {
		return boardDao.countUpViewCnt(article);
	}

	/** DB에 저장되어있는 20150601063125 형식의 날짜형식을 2015-06-01 형식으로 바꿔줌 */
	public void changeRegDTFormat(List<Article> list){
		for(Article article : list) {
			String regDate = article.getRegDt();
			String year = regDate.substring(0, 4);
			String month = regDate.substring(4, 6);
			String day = regDate.substring(6, 8);
			article.setRegDt(year + "-" + month + "-" + day);
		}
	}

	/**  DB에 저장되어있는 20150601063125 형식의 날짜형식을 2015-06-10 06:31:25 형식으로 바꿔줌 */
	public void changeRegDTFormatForReadArticle(Article article) {
		String org = article.getRegDt();
		String formattedDate = 
				org.substring(0,4)
				+ "-"
				+ org.substring(4, 6)
				+ "-"
				+ org.substring(6, 8)
				+ " "
				+ org.substring(8, 10)
				+ ":"
				+ org.substring(10, 12)
				+ ":"
				+ org.substring(12, 14);
		article.setRegDt(formattedDate);
	}

	/* escaped 된 html 을 원래 html로 변환함 */
	public String unescapeHtml(String str) {
		return StringEscapeUtils.unescapeHtml4(str);
	}
	
	/* 글 추가를 위한 공통 파라미터 설정 */
	private void setupArticleParameters(Article article) {
		article.setC_type("default");
		article.setRegId(23);	// TODO : For Test Only
		article.setC_type("folder");
		
		article.setContent(this.unescapeHtml(article.getContent()));
		
		Date today = new Date();
		String formattedDate = DateFormatUtils.format(today, "yyyyMMddHHmmss");
		article.setRegDt(formattedDate);
	}

}
