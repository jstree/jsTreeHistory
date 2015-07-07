package standard.mvc.component.business.baroboard.user.scrap.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import standard.mvc.component.business.baroboard.board.vo.Article;
import standard.mvc.component.business.baroboard.user.scrap.dao.UserScrapDao;
import standard.mvc.component.business.baroboard.user.scrap.vo.UserScrap;

@Service
public class UserScrapServiceImpl implements UserScrapService {
	
    @Resource(name = "CoreService")
    private CoreService coreService;
    
    @Autowired
	private UserScrapDao userScrapDao;
    
	@Override
	public List<UserScrap> scrapList(UserScrap userScrap) throws Exception {
		List<UserScrap> scrapList = (List<UserScrap>)userScrapDao.getUserScrapList(userScrap);
		changeRegDTFormat(scrapList);
		return scrapList;
	}

	
	@Override
	public UserScrap getScrapDetailView(UserScrap userScrap) throws Exception {
		UserScrap userScarp = (UserScrap) userScrapDao.getScrapDetailView(userScrap);
        return userScrap;
	}

	@Override
	public void scrapDelete(UserScrap userScrap) throws Exception {
		coreService.removeNode(userScrap);
	}

	@Override
	public int getScrapListTotalCnt(UserScrap userScrap) throws Exception {
		int totalScrapCount =userScrapDao.getScrapListTotalCnt(userScrap);
		return totalScrapCount;
	}
	
	public void changeRegDTFormat(List<UserScrap> userScrapList){
		for(UserScrap userScrap : userScrapList) {
			String regDate = userScrap.getRegDt();
			String year = regDate.substring(0, 4);
			String month = regDate.substring(4, 6);
			String day = regDate.substring(6, 8);
			userScrap.setRegDt(year + "-" + month + "-" + day);
		}
	}
}
