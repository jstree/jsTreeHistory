package standard.mvc.component.business.baroboard.board.manager.comment.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import standard.mvc.component.business.baroboard.board.manager.comment.dao.CommentManageDao;
import standard.mvc.component.business.baroboard.board.manager.comment.vo.CommentManageVO;
import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;
import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.util.DateUtils;

/**
 * 
 * Modification Information
 * 
 * @author 이종렬
 * @since 2015. 7. 5.
 * @version 1.0
 * @see <pre>
 * Class Name  : CommentManageServiceImpl.java
 * Description : 바로보드-게시판-admin-댓글관리 Service
 * Information :
 * 
 * << 개정이력(Modification Information) >>
 * 
 * 수정일               수정자                 수정내용
 * -------       ------------   -----------------------
 * 2015. 7. 5.      이종렬                 최초 생성
 * 
 * Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value="CommentManageService")
public class CommentManageServiceImpl implements CommentManageService, CoreService{

	
	@Resource(name="DefaultSettingService")
	private CoreService defaultSettingService;
	
	@Resource(name="CommentManageDao")
	private CommentManageDao commentManageDao;
	
	@Resource(name="CoreService")
	private CoreService coreService;
	
	
	@Override
    public List<CommentManageVO> getComment(CommentManageVO commentManageVo)
			throws Exception {
		
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(2);
		List<DefaultSettingVO> boardSettingList = defaultSettingService.getChildNode(defaultSettingVo);
		if(StringUtils.isNotEmpty(commentManageVo.getBoardId())){
			for(DefaultSettingVO defaultSetting : boardSettingList){
				if(commentManageVo.getBoardId().equals(Integer.toString(defaultSetting.getC_id()))){
					boardSettingList.clear();
					boardSettingList.add(defaultSetting);
					break;
				}
			}
		}
		commentManageVo.setTableInfo(boardSettingList);
		return commentManageDao.getComment(commentManageVo);
	}
	
	@Override
    public int getCommentTotalCnt(CommentManageVO commentManageVo) throws Exception {
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(2);
		List<DefaultSettingVO> boardSettingList = defaultSettingService.getChildNode(defaultSettingVo);
		if(StringUtils.isNotEmpty(commentManageVo.getBoardId())){
			for(DefaultSettingVO defaultSetting : boardSettingList){
				if(commentManageVo.getBoardId().equals(Integer.toString(defaultSetting.getC_id()))){
					boardSettingList.clear();
					boardSettingList.add(defaultSetting);
					break;
				}
			}
		}
		commentManageVo.setTableInfo(boardSettingList);
		return commentManageDao.getCommentTotalCnt(commentManageVo);
	}
	
	@Override
    public CommentManageVO commentDelete(CommentManageVO commentManageVo) throws Exception {
		for(String chk : commentManageVo.getChk()){
			String[] postsInfo = chk.split("@");
			
			commentManageVo.setBoardId(postsInfo[0]);
			commentManageVo.setC_id(Integer.parseInt(postsInfo[1]));
			CommentManageVO comment = this.getNode(commentManageVo);
			comment.setBoardId(postsInfo[0]);
			comment.setModDt(DateUtils.format("yyyyMMddHHmmss", DateUtils.getCurrentDay()));
			comment.setIsDeletedFl("1");
			this.alterNode(comment);
		}
		
		CommentManageVO result = new CommentManageVO();
		result.setStatus(1);
		return result;
	}

	@Override
	public <T extends ComprehensiveTree> T getNode(T comprehensiveTree)
			throws Exception {
		return coreService.getNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> List<T> getChildNode(
			T comprehensiveTree) throws Exception {
		return coreService.getChildNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> List<String> searchNode(
			T comprehensiveTree) throws Exception {
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}

	@Override
	public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
			throws Exception {
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}

	@Override
	public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
			throws Exception {
		return coreService.removeNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree)
			throws Exception {
		return coreService.alterNode(comprehensiveTree);
	}

	@Override
	public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
			throws Exception {
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}

	@Override
	public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree,
			HttpServletRequest request) throws Exception {
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}
}
