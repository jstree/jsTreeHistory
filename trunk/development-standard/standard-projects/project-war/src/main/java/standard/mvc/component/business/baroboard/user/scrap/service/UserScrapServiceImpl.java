package standard.mvc.component.business.baroboard.user.scrap.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
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
		userScrap.setC_id(userScrap.getC_id());
        
		List<UserScrap> scrapList = (List<UserScrap>)userScrapDao.getUserScrapList(userScrap);
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

}
