package egovframework.com.ext.jstree.springiBatis.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 이동민
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: CoreServiceImpl.java
 * 	Description : jstree Spring + iBatis 버젼의 서비스 구현체
 * 	Infomation	: CoreService.java 를 구현한 클래스 로 실제 작업이 이루어지는 클래스
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014.  7. 31.  이동민                 최초 생성
 *  2014. 10. 12.  류강하                 리플렉션을 성공적으로 수행하기 위한 메서드 시그너쳐 변경, 리플렉션 코드를 newInstance 메서드로 추출
 *  2015. 01. 07.  류강하                 alterNodeType() 리팩토링
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("CoreService")
public class CoreServiceImpl implements CoreService
{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name = "CoreDao")
    private CoreDao coreDao;
    
    /*
     * (non-Javadoc)
     * 
     * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#
     * getChildNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    public <T extends ComprehensiveTree> List<T> getChildNode(T comprehensiveTree) throws Exception
    {
        List<T> childNode = (List<T>) coreDao.getChildNode(comprehensiveTree);
        return childNode;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * egovframework.com.ext.jstree.springiBatis.core.service.CoreService#searchNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    public <T extends ComprehensiveTree> List<String> searchNode(T comprehensiveTree) throws Exception
    {
        
        List<T> searchNodeByStrings = (List<T>) coreDao.searchNodeByString(comprehensiveTree);
        
        if (searchNodeByStrings.isEmpty())
        {
            return new ArrayList<String>();
        }
        else
        {
            List<String> rowDatas = coreDao.searchNodeByPosition(searchNodeByStrings);
            List<String> returnList = new ArrayList<String>();
            
            for (String rowData : rowDatas)
            {
                rowData = "#node_" + rowData;
                returnList.add(rowData);
            }
            return returnList;
        }
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * egovframework.com.ext.jstree.springiBatis.core.service.CoreService#addNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    @Transactional
    public <T extends ComprehensiveTree> T addNode(T comprehensiveTree) throws Exception
    {
        
        T nodeById = ((T) coreDao.getNode(comprehensiveTree));
        T nodeByRef = ((T) coreDao.getNodeByRef(comprehensiveTree));
        
        List<T> childNodesFromNodeByRef = ((List<T>) coreDao.getChildNode(nodeByRef));
        
        T t_ComprehensiveTree = newInstance(comprehensiveTree); //포지션값 맞지않음.
        
        int spaceOfTargetNode = 2;
        Collection<Integer> c_idsByChildNodeFromNodeById = null;
        
        //cut & paste
        if (nodeById != null && comprehensiveTree.getCopy() == 0)
        {
            
            this.cutMyself(nodeById, spaceOfTargetNode, c_idsByChildNodeFromNodeById);
        }
        
        this.stretchPositionForMyselfFromJstree(c_idsByChildNodeFromNodeById, nodeById, comprehensiveTree);
        
        int rightPositionFromNodeByRef = nodeByRef.getC_right();
        rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);
        
        //cut & paste 이면서 cut node를 같은 부모의 다른 position으로 이동시킬때.
        int self = (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
                && nodeById.getC_parentid() == comprehensiveTree.getRef() && comprehensiveTree.getC_position() > nodeById
                .getC_position()) ? 1 : 0;
        
        for (T child : childNodesFromNodeByRef)
        {
            //대상 노드가 들어가려는 자리에 ( position ) 이미 자리잡고 있는 노드가 있는지 검사.
            if (child.getC_position() - self == comprehensiveTree.getC_position())
            {
                //있다면 이건 이미 대상 노드가 뽑혀져 나온 케이스 이며, 부모노트의 오른쪽 포지션이 늘어나면 안되므로 내가 들어가려는 
                //노드의 좌측 left 값을 rightPositionFromNodeByRef에 맵핑.
                rightPositionFromNodeByRef = child.getC_left();
                break;
            }
        }
        
        //cut & paste 인 경우이면서, 내가 있던 자리보다 앞으로 이동하는 경우.
        if (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
                && nodeById.getC_left() < rightPositionFromNodeByRef)
        {
            //따라서 우측 좌표값을을 2개 줄여놔야 한다.
            rightPositionFromNodeByRef -= spaceOfTargetNode;
        }
        
        //벌린다.
        this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode, rightPositionFromNodeByRef,
                                                 comprehensiveTree.getCopy(), c_idsByChildNodeFromNodeById,
                                                 comprehensiveTree);
        
        //레벨 잡아주고, 사실 ref가 0일 경우는 없다.
        int targetNodeLevel = comprehensiveTree.getRef() == 0 ? 0 : nodeByRef.getC_level() + 1;
        //부모노드의 우측 포지션을 잠시 저장해 둔다.
        int comparePosition = rightPositionFromNodeByRef;
        
        //쌩짜 addnode가 아닌경우.
        if (nodeById != null)
        {
            
            targetNodeLevel = nodeById.getC_level() - (nodeByRef.getC_level() + 1);
            comparePosition = nodeById.getC_left() - rightPositionFromNodeByRef;
            
            if (comprehensiveTree.getCopyBooleanValue())
            {
                int ind = this.pasteMyselfFromJstree(comprehensiveTree.getRef(), comparePosition, spaceOfTargetNode,
                                                     targetNodeLevel, rightPositionFromNodeByRef,
                                                     c_idsByChildNodeFromNodeById, nodeById);
                t_ComprehensiveTree.setId(ind);
                this.fixCopy(ind, comprehensiveTree.getC_position(), comprehensiveTree);
            }
            else
            {
                this.enterMyselfFromJstree(comprehensiveTree.getRef(), comprehensiveTree.getC_position(),
                                           comprehensiveTree.getC_id(), comparePosition, targetNodeLevel,
                                           c_idsByChildNodeFromNodeById, comprehensiveTree);
            }
        }
        else
        {
            //쌩짜 addnode인 경우.
            //당연히 부모노드는 ref일거고
            comprehensiveTree.setC_parentid(comprehensiveTree.getRef());
            //부모의 우측 좌표값을 새로운 노드의 좌측 좌표값일거고
            comprehensiveTree.setC_left(comparePosition);
            //부모의 우측 좌표+1값을 새로운 노드의 우측 좌표값일거고
            comprehensiveTree.setC_right(comparePosition + 1);
            //계산된 노드의 레벨이 적용
            comprehensiveTree.setC_level(targetNodeLevel);
            
            //db 처리하고 ( 타입을 제외한다 ) 
            int insertSeqResult = coreDao.addMyselfFromJstree(comprehensiveTree);
            
            //아이디 리턴 잡아서 처리하고
            t_ComprehensiveTree.setId(insertSeqResult);
            comprehensiveTree.setC_id(insertSeqResult);
            //db 처리할때 아이디값을 한번 더 업데이트 해준다. ( 타입 포함 ) 
            int alterCountResult = coreDao.alterNode(comprehensiveTree);
            
            if (insertSeqResult > 0 && alterCountResult == 1)
            {
                // 성공한거다. 
                t_ComprehensiveTree.setStatus(1);
            }
            else
            {
                throw new RuntimeException("심각한 오류 발생 - 삽입 노드");
            }
        }
        
        //카피한 케이스이면.
        if (comprehensiveTree.getCopyBooleanValue())
        {
            this.fixCopy(comprehensiveTree.getC_id(), comprehensiveTree.getC_position(), comprehensiveTree);
        }
        return t_ComprehensiveTree;
    }
    
    private <T extends ComprehensiveTree> void cutMyself(T nodeById, int spaceOfTargetNode,
            Collection<Integer> c_idsByChildNodeFromNodeById) throws Exception
    {
        
        nodeById.setSpaceOfTargetNode(spaceOfTargetNode);
        nodeById.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        
        coreDao.cutMyself(nodeById);
    }
    
    private <T extends ComprehensiveTree> void stretchPositionForMyselfFromJstree(
            Collection<Integer> c_idsByChildNodeFromNodeById, T nodeById, T comprehensiveTree) throws Exception
    {
        
        comprehensiveTree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        comprehensiveTree.setNodeById(nodeById); // TODO unused code
        
        coreDao.stretchPositionForMyselfFromJstree(comprehensiveTree);
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
    
    private <T extends ComprehensiveTree> int pasteMyselfFromJstree(int ref, int idif, int spaceOfTargetNode, int ldif,
            int rightPositionFromNodeByRef, Collection<Integer> c_idsByChildNodeFromNodeById, T nodeById)
            throws Exception
    {
        
        T onlyPasteMyselfFromJstree = newInstance(nodeById);
        
        onlyPasteMyselfFromJstree.setRef(ref);
        onlyPasteMyselfFromJstree.setIdif(idif);
        onlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
        onlyPasteMyselfFromJstree.setLdif(ldif);
        onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        onlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
        onlyPasteMyselfFromJstree.setNodeById(nodeById);
        
        onlyPasteMyselfFromJstree.setIdifLeft(idif
                + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
        onlyPasteMyselfFromJstree.setIdifRight(idif
                + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
        
        return coreDao.pasteMyselfFromJstree(onlyPasteMyselfFromJstree);
    }
    
    @SuppressWarnings({ "null" })
    private <T extends ComprehensiveTree> void fixCopy(int ind, int ref, T t_comprehensiveTree) throws Exception
    {
        
        T comprehensiveTree = newInstance(t_comprehensiveTree);
        comprehensiveTree.setC_id(ind);
        
        T node = ((T) coreDao.getNode(comprehensiveTree));
        
        List<T> children = ((List<T>) coreDao.getChildNodeByLeftRight(node));
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = node.getC_left() + 1; i < node.getC_right(); i++)
        {
            map.put(i, ind);
        }
        
        for (int i = 0; i < children.size(); i++)
        {
            
            T child = children.get(i);
            
            if (child.getC_id() == ind)
            {
                logger.debug(">>>>>>>>>>>>>>>>> 기준노드가 잡혔음.");
                logger.debug("C_TITLE    = " + child.getC_title());
                logger.debug("C_ID       = " + ind);
                logger.debug("C_POSITION = " + ref);
                
                Class<T> targetTemp = null;
                T onlyFixCopyFromJstree = targetTemp.newInstance();
                onlyFixCopyFromJstree.setFixCopyId(ind);
                onlyFixCopyFromJstree.setFixCopyPosition(ref);
                
                coreDao.fixCopyIF(onlyFixCopyFromJstree);
                continue;
            }
            logger.debug(">>>>>>>>>>>>>>>>> 기준노드 아래 있는 녀석임");
            logger.debug("C_TITLE    = " + child.getC_title());
            logger.debug("C_ID       = " + ind);
            logger.debug("C_POSITION = " + ref);
            logger.debug("부모아이디값 = " + map.get(child.getC_left()));
            
            child.setFixCopyId(map.get(child.getC_left()));
            
            coreDao.fixCopy(child);
            
            for (int j = child.getC_left() + 1; j < child.getC_right(); j++)
            {
                map.put(j, child.getC_id());
            }
        }
    }
    
    private <T extends ComprehensiveTree> void enterMyselfFromJstree(int ref, int c_position, int c_id, int idif,
            int ldif, Collection<Integer> c_idsByChildNodeFromNodeById, T comprehensiveTree) throws Exception
    {
        
        T onlyPasteMyselfFromJstree = newInstance(comprehensiveTree);
        
        onlyPasteMyselfFromJstree.setRef(ref);
        onlyPasteMyselfFromJstree.setC_position(c_position);
        onlyPasteMyselfFromJstree.setC_id(c_id);
        onlyPasteMyselfFromJstree.setIdif(idif);
        onlyPasteMyselfFromJstree.setLdif(ldif);
        onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        
        coreDao.enterMyselfFixPosition(onlyPasteMyselfFromJstree);
        coreDao.enterMyselfFixLeftRight(onlyPasteMyselfFromJstree);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#
     * executeRemoveNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    @Transactional
    public <T extends ComprehensiveTree> int removeNode(T comprehensiveTree) throws Exception
    {
        
        T removeNode = ((T) coreDao.getNode(comprehensiveTree));
        
        int spaceOfTargetNode = removeNode.getC_right() - removeNode.getC_left() + 1;
        
        removeNode.setSpaceOfTargetNode(spaceOfTargetNode);
        
        coreDao.removeNode(removeNode);
        
        return 0;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * egovframework.com.ext.jstree.springiBatis.core.service.CoreService#alterNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    @Transactional
    public <T extends ComprehensiveTree> int alterNode(T comprehensiveTree) throws Exception
    {
        
        return coreDao.alterNode(comprehensiveTree);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see egovframework.com.ext.jstree.springiBatis.core.service.CoreService#
     * alterNodeType
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    @Transactional
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree) throws Exception
    {
        
        int returnStatus = 0;
        
        T nodeById = ((T) coreDao.getNode(comprehensiveTree));
        
        if (nodeById.getC_type().equals(comprehensiveTree.getC_type()))
        {
            returnStatus = 1;
            
        }
        else if ("default".equals(comprehensiveTree.getC_type()))
        {
            
            List<T> childNodesFromNodeById = ((List<T>) coreDao.getChildNode(nodeById));
            
            if (childNodesFromNodeById.size() != 0)
            {
                throw new RuntimeException("하위에 노드가 있는데 디폴트로 바꾸려고 함");
                
            }
            else
            {
                int temp = coreDao.alterNodeType(comprehensiveTree);
                
                if (temp == 1)
                {
                    returnStatus = 1;
                }
                else
                {
                    throw new RuntimeException("여러개의 노드가 업데이트 되었음"); // TODO 동일한
                                                                     // id가
                                                                     // 여러개라면 이미
                                                                     // 노드 추가
                                                                     // 로직이 문제가
                                                                     // 있는 것임.
                }
            }
            
        }
        else if ("folder".equals(comprehensiveTree.getC_type()))
        {
            
            returnStatus = coreDao.alterNodeType(comprehensiveTree);
        }
        
        return returnStatus;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * egovframework.com.ext.jstree.springiBatis.core.service.CoreService#moveNode
     * (egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree)
     */
    @Transactional
    public <T extends ComprehensiveTree> T moveNode(T comprehensiveTree, HttpServletRequest request) throws Exception
    {
        
        T nodeById = (T) coreDao.getNode(comprehensiveTree);
        List<T> childNodesFromNodeById = ((List<T>) coreDao.getChildNodeByLeftRight(nodeById));
        
        T nodeByRef = (T) coreDao.getNodeByRef(comprehensiveTree);
        List<T> childNodesFromNodeByRef = ((List<T>) coreDao.getChildNode(nodeByRef));
        
        T t_ComprehensiveTree = newInstance(comprehensiveTree);
        
        int spaceOfTargetNode = 2;
        Collection<Integer> c_idsByChildNodeFromNodeById = null;
        
        if (nodeById == null)
        {
            throw new RuntimeException("nodeById is null");
        }
        else
        {
            c_idsByChildNodeFromNodeById = CollectionUtils.collect(childNodesFromNodeById,
                                                                   new Transformer<T, Integer>() {
                                                                       @Override
                                                                       public Integer transform(T childNodePerNodeById)
                                                                       {
                                                                           return childNodePerNodeById.getC_id();
                                                                       }
                                                                   });
            
            if (c_idsByChildNodeFromNodeById.contains(comprehensiveTree.getRef())) { throw new RuntimeException(
                    "myself contains already refTargetNode"); }
            
            spaceOfTargetNode = nodeById.getC_right() - nodeById.getC_left() + 1;
        }
        
        if (nodeById != null && comprehensiveTree.getCopyBooleanValue() == false)
        {
            this.cutMyself(nodeById, spaceOfTargetNode, c_idsByChildNodeFromNodeById);
        }
        
        calculatePostion(comprehensiveTree, nodeById, childNodesFromNodeByRef, request);
        
        this.stretchPositionForMyselfFromJstree(c_idsByChildNodeFromNodeById, nodeById, comprehensiveTree);
        
        int rightPositionFromNodeByRef = nodeByRef.getC_right();
        rightPositionFromNodeByRef = Math.max(rightPositionFromNodeByRef, 1);
        
        int self = (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
                && nodeById.getC_parentid() == comprehensiveTree.getRef() && comprehensiveTree.getC_position() > nodeById
                .getC_position()) ? 1 : 0;
        
        for (T child : childNodesFromNodeByRef)
        {
            if (child.getC_position() - self == comprehensiveTree.getC_position())
            {
                rightPositionFromNodeByRef = child.getC_left();
                break;
            }
        }
        
        if (nodeById != null && !comprehensiveTree.getCopyBooleanValue()
                && nodeById.getC_left() < rightPositionFromNodeByRef)
        {
            rightPositionFromNodeByRef -= spaceOfTargetNode;
        }
        
        this.stretchLeftRightForMyselfFromJstree(spaceOfTargetNode, rightPositionFromNodeByRef,
                                                 c_idsByChildNodeFromNodeById, comprehensiveTree.getCopy(),
                                                 comprehensiveTree);
        
        logger.debug(">>>>>>>>>>>>>>>>>>>>" + rightPositionFromNodeByRef);
        int targetNodeLevel = nodeById.getC_level() - (nodeByRef.getC_level() + 1);
        int comparePosition = nodeById.getC_left() - rightPositionFromNodeByRef;
        logger.debug(">>>>>>>>>>>>>>>>>>>>" + comparePosition);
        
        if (comprehensiveTree.getCopyBooleanValue())
        {
            
            int ind = this.pasteMyselfFromJstree(comprehensiveTree.getRef(), comparePosition, spaceOfTargetNode,
                                                 targetNodeLevel, c_idsByChildNodeFromNodeById,
                                                 rightPositionFromNodeByRef, nodeById);
            t_ComprehensiveTree.setId(ind);
            this.fixCopy(ind, comprehensiveTree.getC_position(), comprehensiveTree);
            
        }
        else
        {
            this.enterMyselfFromJstree(comprehensiveTree.getRef(), comprehensiveTree.getC_position(),
                                       comprehensiveTree.getC_id(), comparePosition, targetNodeLevel,
                                       c_idsByChildNodeFromNodeById, comprehensiveTree);
            
        }
        return t_ComprehensiveTree;
    }
    
    private <T extends ComprehensiveTree> void calculatePostion(T comprehensiveTree, T nodeById,
            List<T> childNodesFromNodeByRef, HttpServletRequest request) throws Exception
    {
        
        HttpSession session = request.getSession();
        
        if (comprehensiveTree.getRef() == nodeById.getC_parentid())
        {
            logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모안에서 움직일때");
            
            if (comprehensiveTree.getMultiCounter() == 0)
            {
                logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
                session.setAttribute("settedPosition", comprehensiveTree.getC_position());
                
                if (comprehensiveTree.getC_position() > nodeById.getC_position())
                {
                    logger.debug(">>>>>>>>>>>>>>>이동 할 노드가 현재보다 뒤일때");
                    logger.debug("노드값=" + nodeById.getC_title());
                    logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
                    logger.debug("노드의 요청받은 위치값=" + comprehensiveTree.getC_position());
                    logger.debug("노드의 요청받은 멀티카운터=" + comprehensiveTree.getMultiCounter());
                    
                    if (comprehensiveTree.getC_position() > childNodesFromNodeByRef.size())
                    {
                        logger.debug("노드 이동시 폴더를 대상으로 했을때 생기는 버그 발생 =" + comprehensiveTree.getC_position());
                        comprehensiveTree.setC_position(childNodesFromNodeByRef.size());
                    }
                    comprehensiveTree.setC_position(comprehensiveTree.getC_position() - 1);
                    
                    logger.debug("노드의 최종 위치값=" + comprehensiveTree.getC_position());
                    session.setAttribute("settedPosition", comprehensiveTree.getC_position());
                }
                
            }
            else
            {
                logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
                logger.debug("노드값=" + nodeById.getC_title());
                logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
                logger.debug("노드의 요청받은 위치값=" + comprehensiveTree.getC_position());
                logger.debug("노드의 요청받은 멀티카운터=" + comprehensiveTree.getMultiCounter());
                logger.debug("0번 노드의 위치값=" + session.getAttribute("settedPosition"));
                
                int increasePosition = 0;
                
                if ((Integer) session.getAttribute("settedPosition") < nodeById.getC_position())
                {
                    logger.debug(">>>>>>>>>>>>>>>멀티 노드의 위치가 0번 노드보다 뒤일때");
                    increasePosition = (Integer) session.getAttribute("settedPosition") + 1;
                }
                else
                {
                    logger.debug(">>>>>>>>>>>>>>>멀티 노드의 위치가 0번 노드보다 앞일때");
                    increasePosition = (Integer) session.getAttribute("settedPosition");
                }
                session.setAttribute("settedPosition", increasePosition);
                
                comprehensiveTree.setC_position(increasePosition);
                
                if (nodeById.getC_position() == comprehensiveTree.getC_position())
                {
                    logger.debug(">>>>>>>>>>>>>>>원래 노드 위치값과 최종 계산된 노드의 위치값이 동일한 경우");
                    session.setAttribute("settedPosition", increasePosition - 1);
                }
                logger.debug("노드의 최종 위치값=" + comprehensiveTree.getC_position());
            }
        }
        else
        {
            logger.debug(">>>>>>>>>>>>>>>이동할 노드가 내 부모밖으로 움직일때");
            
            if (comprehensiveTree.getMultiCounter() == 0)
            {
                logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 일때");
                logger.debug("노드값=" + nodeById.getC_title());
                logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
                logger.debug("노드의 요청받은 위치값=" + comprehensiveTree.getC_position());
                logger.debug("노드의 요청받은 멀티카운터=" + comprehensiveTree.getMultiCounter());
                comprehensiveTree.setC_position(comprehensiveTree.getC_position());
                logger.debug("노드의 최종 위치값=" + comprehensiveTree.getC_position());
                session.setAttribute("settedPosition", comprehensiveTree.getC_position());
            }
            else
            {
                logger.debug(">>>>>>>>>>>>>>>멀티 카운터가 0 이 아닐때");
                logger.debug("노드값=" + nodeById.getC_title());
                logger.debug("노드의 초기 위치값=" + nodeById.getC_position());
                logger.debug("노드의 요청받은 위치값=" + comprehensiveTree.getC_position());
                logger.debug("노드의 요청받은 멀티카운터=" + comprehensiveTree.getMultiCounter());
                
                int increasePosition = 0;
                increasePosition = (Integer) session.getAttribute("settedPosition") + 1;
                session.setAttribute("settedPosition", increasePosition);
                
                comprehensiveTree.setC_position(increasePosition);
                logger.debug("노드의 최종 위치값=" + comprehensiveTree.getC_position());
                session.setAttribute("settedPosition", comprehensiveTree.getC_position());
            }
        }
    }
    
    private <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree(int spaceOfTargetNode,
            int rightPositionFromNodeByRef, Collection<Integer> c_idsByChildNodeFromNodeById, int copy,
            T comprehensiveTree) throws Exception
    {
        
        T onlyStretchLeftRightForMyselfFromJstree = newInstance(comprehensiveTree);
        
        onlyStretchLeftRightForMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
        onlyStretchLeftRightForMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
        onlyStretchLeftRightForMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        onlyStretchLeftRightForMyselfFromJstree.setCopy(copy);
        
        coreDao.stretchLeftForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
        coreDao.stretchRightForMyselfFromJstree(onlyStretchLeftRightForMyselfFromJstree);
    }
    
    private <T extends ComprehensiveTree> int pasteMyselfFromJstree(int ref, int idif, int spaceOfTargetNode, int ldif,
            Collection<Integer> c_idsByChildNodeFromNodeById, int rightPositionFromNodeByRef, T nodeById)
            throws Exception
    {
        
        T onlyPasteMyselfFromJstree = newInstance(nodeById);
        
        onlyPasteMyselfFromJstree.setRef(ref);
        onlyPasteMyselfFromJstree.setIdif(idif);
        onlyPasteMyselfFromJstree.setSpaceOfTargetNode(spaceOfTargetNode);
        onlyPasteMyselfFromJstree.setLdif(ldif);
        onlyPasteMyselfFromJstree.setC_idsByChildNodeFromNodeById(c_idsByChildNodeFromNodeById);
        onlyPasteMyselfFromJstree.setRightPositionFromNodeByRef(rightPositionFromNodeByRef);
        onlyPasteMyselfFromJstree.setNodeById(nodeById);
        
        onlyPasteMyselfFromJstree.setIdifLeft(idif
                + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
        onlyPasteMyselfFromJstree.setIdifRight(idif
                + (nodeById.getC_left() >= rightPositionFromNodeByRef ? spaceOfTargetNode : 0));
        
        return coreDao.pasteMyselfFromJstree(onlyPasteMyselfFromJstree);
    }
    
    /**
     * 파라미터로 넘겨진 인스턴스의 정보를 이용해 리플렉션하여 새로운 인스턴스를 만들어 반환한다.
     * 
     * @param comprehensiveTree
     *            리플렉션을 위한 타입 정보를 제공하기 위한 인스턴스
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    private <T extends ComprehensiveTree> T newInstance(T comprehensiveTree) throws Exception
    {
        
        Class<T> target = (Class<T>) Class.forName(comprehensiveTree.getClass().getCanonicalName());
        return target.newInstance();
    }
}