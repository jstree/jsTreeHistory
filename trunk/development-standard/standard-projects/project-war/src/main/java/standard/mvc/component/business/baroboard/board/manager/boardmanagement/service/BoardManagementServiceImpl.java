package standard.mvc.component.business.baroboard.board.manager.boardmanagement.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import standard.mvc.component.business.baroboard.board.manager.boardmanagement.dao.BoardManagementDao;
import standard.mvc.component.business.baroboard.board.manager.boardmanagement.vo.BoardManagementVO;
import standard.mvc.component.business.baroboard.core.manage.setting.messages.ExceptionMessage;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

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
@Service(value = "BoardManagementService")
public class BoardManagementServiceImpl implements CoreService {

    @Resource(name = "CoreService")
    private CoreService boardManagementService;
    
    @Autowired
    private BoardManagementDao boardManagementDao;

    @Override
    public <T extends ComprehensiveTree> T getNode(T comprehensiveTree) throws Exception {
        T node = boardManagementService.getNode(comprehensiveTree);
        return node;
    }
    
    @Override
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception {
    	int alteredCount = boardManagementService.alterNode(comprehensiveTree);
    	return alteredCount;
    }

    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception {
    	return boardManagementService.getChildNode(comprehensiveTree);
    }

    @Override
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree)
            throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception {
    	
    	BoardManagementVO boardManagementVO = (BoardManagementVO)comprehensiveTree;
    	
    	String tableName = createTableName(boardManagementVO);
    	boardManagementVO.setBoardTableName(tableName);
    	
    	boardManagementDao.createBoardTable(boardManagementVO);

    	boardManagementVO.setBoardTableName( tableName + "_LIKE" );
    	boardManagementDao.createLikeTable(boardManagementVO);
    	
    	boardManagementVO.setBoardTableName( tableName + "_COMMENT" );
    	boardManagementDao.createCommentTable(boardManagementVO);
    	
    	boardManagementVO.setBoardTableName( tableName + "_FILE" );
    	boardManagementDao.createFileTable(boardManagementVO);
    	
    	boardManagementService.addNode(boardManagementVO);
    	
    	return comprehensiveTree;
    }
    
    private String createTableName( BoardManagementVO boardManagementVO ) throws Exception{
    	
    	String tableName = "BOARD";
    	int    order     = boardManagementDao.getTableSeq(boardManagementVO);
    	
    	return tableName + "_" + order;
    }

    @Override
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }

    @Override
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request)
            throws Exception {
        throw new RuntimeException(ExceptionMessage.UN_SUPPORTED.getValue());
    }
}