package standard.mvc.component.business.baroboard.user.scrap.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.board.service.BoardService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.user.scrap.dao.UserScrapDao;
import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

@Service
public class UserScrapServiceImpl implements UserScrapService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
	private BoardService boardService;
    
    @Autowired
	private UserScrapDao userScrapDao;
    
	@Override
	public List<UserScrap> scrapList(UserScrap userScrap) throws Exception {
		List<UserScrap> scrapList = (List<UserScrap>)userScrapDao.getUserScrapList(userScrap);
		//changeRegDTFormat(scrapList);
		return scrapList;
	}

	@Override
	public void scrapDelete(UserScrap userScrap) throws Exception {
		coreService.removeNode(userScrap);
	}

	@Override
	public int getScrapListTotalCnt(UserScrap userScrap) throws Exception {
		int totalScrapCount = userScrapDao.getScrapListTotalCnt(userScrap);
		return totalScrapCount;
	}
	
	@Override
	public UserScrap getDeleteScrapId(int postingId) throws Exception {
		// TODO Auto-generated method stub
		UserScrap userScrap = userScrapDao.getC_id(postingId);
		return userScrap;
	}
	
	public void changeRegDTFormat(List<UserScrap> userScrapList){
		for(UserScrap userScrap : userScrapList) {
			String scrapDate = userScrap.getScrapDt();
			String year = scrapDate.substring(0, 4);
			String month = scrapDate.substring(4, 6);
			String day = scrapDate.substring(6, 8);
			userScrap.setRegDt(year + "-" + month + "-" + day);
		}
	}

	@Override
	public UserScrap addScrap(Article article, int loginedUserID) throws Exception {
		UserScrap userScrap = new UserScrap();
		
		userScrap = getArticle(article);
		
		String boardId = getBoardId(article.getC_id());
		
		userScrap.setUserId(3);
		//userScrap.setUserId(loginedUserID);
		//userScrap.setBoardId(boardId);
		userScrap.setC_type("default");
		userScrap.setBoardId("23");
		userScrap.setPostingId(article.getC_id());
		userScrap.setScrapDt(getTodayFor14Digits());
		userScrap.setRef(2);
		return userScrap;
	}
	
	public UserScrap getArticle(Article article) throws Exception {
		UserScrap userScrap = new UserScrap();
		userScrap = userScrapDao.getArticle(article);
		return userScrap;
	}

	public String getTodayFor14Digits() {
		Date today = new Date();
		String formattedDate = DateFormatUtils.format(today, "yyyyMMddHHmmss");
		return formattedDate;
	}

	@Override
	public String getBoardId(int articleId) throws Exception {
		String BoardId = userScrapDao.getBoardId(articleId);
		return null;
	}

	@Override
	public int useScrapFlag(int postingId) throws Exception {
		int useScrapFlag = userScrapDao.getUseScrapFlag(postingId);
		return useScrapFlag;
	}

}
