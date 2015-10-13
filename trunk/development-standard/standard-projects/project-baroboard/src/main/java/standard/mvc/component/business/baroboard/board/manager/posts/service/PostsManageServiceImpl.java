package standard.mvc.component.business.baroboard.board.manager.posts.service;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.business.baroboard.board.manager.defaultsetting.vo.DefaultSettingVO;
import standard.mvc.component.business.baroboard.board.manager.posts.dao.PostsManageDao;
import standard.mvc.component.business.baroboard.board.manager.posts.vo.PostsManageVO;
import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;
import egovframework.com.ext.jstree.support.util.DateUtils;

/**
 * 
 * Modification Information
 * 
 * @author 정원기
 * @since 2015. 6. 24.
 * @version 1.0
 * @see <pre>
 *  Class Name  : BoardManagementServiceImpl.java
 *  Description : 바로보드-게시판-admin-게시판설정 Service
 *  Information :
 * 
 *  << 개정이력(Modification Information) >>
 * 
 *  수정일              수정자                  수정내용
 *  -------       ------------   -----------------------
 *  2015. 6. 24.     정원기                  최초생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */

@Service(value="PostsManageService")
public class PostsManageServiceImpl implements PostsManageService, CoreService, Cloneable {

	
	@Resource(name="DefaultSettingService")
	private CoreService defaultSettingService;
	
	@Resource(name="PostsManageDao")
	private PostsManageDao postsManageDao;
	
	@Resource(name="CoreService")
	private CoreService coreService;
	
	@Resource(name="CoreDao")
	private CoreDao coreDao;
	
	
	@Override
    public List<PostsManageVO> getPosts(PostsManageVO postsManageVo) throws Exception {
		
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(2);
		List<DefaultSettingVO> boardSettingList = defaultSettingService.getChildNode(defaultSettingVo);
		if(StringUtils.isNotEmpty(postsManageVo.getBoardId())){
			for(DefaultSettingVO defaultSetting : boardSettingList){
				if(postsManageVo.getBoardId().equals(Integer.toString(defaultSetting.getC_id()))){
					boardSettingList.clear();
					boardSettingList.add(defaultSetting);
					break;
				}
			}
		}
		postsManageVo.setTableInfo(boardSettingList);
		return postsManageDao.getPosts(postsManageVo);
	}
	
	@Override
	public int getPostsTotalCnt(PostsManageVO postsManageVo) throws Exception {
		
		DefaultSettingVO defaultSettingVo = new DefaultSettingVO();
		defaultSettingVo.setC_id(2);
		List<DefaultSettingVO> boardSettingList = defaultSettingService.getChildNode(defaultSettingVo);
		if(StringUtils.isNotEmpty(postsManageVo.getBoardId())){
			for(DefaultSettingVO defaultSetting : boardSettingList){
				if(postsManageVo.getBoardId().equals(Integer.toString(defaultSetting.getC_id()))){
					boardSettingList.clear();
					boardSettingList.add(defaultSetting);
					break;
				}
			}
		}
		postsManageVo.setTableInfo(boardSettingList);
		return postsManageDao.getPostsTotalCnt(postsManageVo);
	}
	
	@Override
    @Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
	public PostsManageVO postsDelete(PostsManageVO postsManageVo) throws Exception {
		for(String chk : postsManageVo.getChk()){
			String[] postsInfo = chk.split("@");
			postsManageVo.setBoardId(postsInfo[0]);
			postsManageVo.setC_id(Integer.parseInt(postsInfo[1]));
			PostsManageVO posts = this.getNode(postsManageVo);
			posts.setBoardId(postsInfo[0]);
			posts.setModDt(DateUtils.format("yyyyMMddHHmmss", DateUtils.getCurrentDay()));
			posts.setIsDeletedFl("1");
			this.alterNode(posts);
		}
		
		PostsManageVO result = new PostsManageVO();
		result.setStatus(1);
		return result;
	}
	
	@Override
    @Transactional(readOnly = false, rollbackFor={Exception.class}, propagation=Propagation.REQUIRED)
	public PostsManageVO postsBoardMove(PostsManageVO postsManageVo) throws Exception {
		
		for(String chk : postsManageVo.getChk()){
			String[] postsInfo = chk.split("@");
			postsManageVo.setBoardId(postsInfo[0]);
			postsManageVo.setC_id(Integer.parseInt(postsInfo[1]));
			PostsManageVO posts = coreService.getNode(postsManageVo);
			posts.setBoardId(postsInfo[0]);
			posts.setRef(2);
			posts.setModDt(DateUtils.format("yyyyMMddHHmmss", DateUtils.getCurrentDay()));
			this.removeNode(posts);
			posts.setBoardId(postsInfo[2]);
			this.addNode(posts);
		}
		
		PostsManageVO result = new PostsManageVO();
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
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}

	@Override
	public <T extends ComprehensiveTree> List<String> searchNode(
			T comprehensiveTree) throws Exception {
		throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
	}

	@Override
	public <T extends ComprehensiveTree> T addNode(T comprehensiveTree)
			throws Exception {
		T nodeByRef = newInstance(coreDao.getNodeByRef(comprehensiveTree), comprehensiveTree);
		if(nodeByRef == null)
        {
        	throw new RuntimeException("nodeByRef is null");
        }
        
        if("default".equals(nodeByRef.getC_type()))
        {
        	throw new RuntimeException("nodeByRef is default Type");
        }
        
        T t_ComprehensiveTree = newInstance(comprehensiveTree);
        
        List<T> childNodesFromRef = (coreDao.getChildNode(nodeByRef));

        final int lastPosiotionOfNodeByRef = childNodesFromRef.size();
        
        t_ComprehensiveTree.setC_position(lastPosiotionOfNodeByRef);
        comprehensiveTree.setC_position(lastPosiotionOfNodeByRef);
        
        int rightPointFromNodeByRef = nodeByRef.getC_right();
        rightPointFromNodeByRef = Math.max(rightPointFromNodeByRef, 1);
           
        int spaceOfTargetNode = 2;
        
        this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode, rightPointFromNodeByRef,
                                                 comprehensiveTree.getCopy(), null,
                                                 comprehensiveTree);
        
        int targetNodeLevel = comprehensiveTree.getRef() == 0 ? 0 : nodeByRef.getC_level() + 1;
        
        comprehensiveTree.setC_parentid(comprehensiveTree.getRef());
        comprehensiveTree.setC_left(rightPointFromNodeByRef);
        comprehensiveTree.setC_right(rightPointFromNodeByRef + 1);
        comprehensiveTree.setC_level(targetNodeLevel);
        
        int insertSeqResult = coreDao.addMyselfFromJstree(comprehensiveTree);
        
        t_ComprehensiveTree.setId(insertSeqResult);
        comprehensiveTree.setC_id(insertSeqResult);
        
        int alterCountResult = coreDao.alterNode(comprehensiveTree); 
        
        if (insertSeqResult > 0 && alterCountResult == 1)
        {
        	final int SUCCESS = 1;
            t_ComprehensiveTree.setStatus(SUCCESS);
        }
        else
        {
            throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
        }
        
        return t_ComprehensiveTree;
	}

	@Override
	public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree)
			throws Exception {
		int spaceOfTargetNode = comprehensiveTree.getC_right() - comprehensiveTree.getC_left() + 1;
		comprehensiveTree.setSpaceOfTargetNode(spaceOfTargetNode);
		return coreDao.removeNode(comprehensiveTree);
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
	
	private <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree(int spaceOfTargetNode,
            int rightPositionFromNodeByRef, int copy, Collection<Integer> c_idsByChildNodeFromNodeById,
            T comprehensiveTree) throws Exception
    {
        T onlyStretchLeftRightForMyselfFromJstree = newInstance(comprehensiveTree);
        
        onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
        onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
        onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
        
        coreDao.stretchLeftRightForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
    }
	
	@SuppressWarnings("unchecked")
    private <T extends ComprehensiveTree> T newInstance(T comprehensiveTree) throws Exception
    {
        return (T) newInstance(new ComprehensiveTree(), comprehensiveTree);
    }
	
	@SuppressWarnings("unchecked")
    private <T extends ComprehensiveTree> T newInstance(T target, T comprehensiveTree) throws Exception
    {
		T t = (T) BeanUtils.cloneBean(comprehensiveTree);
		ComprehensiveTree comp = new ComprehensiveTree();
		BeanUtils.copyProperties(comp, target);
		BeanUtils.copyProperties(t, comp);
        return t;
    }
}
