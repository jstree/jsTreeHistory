/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.ext.jstree.springiBatis.core.mock;

import java.util.ArrayList;
import java.util.List;

import egovframework.com.ext.jstree.springiBatis.core.dao.CoreDao;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2015. 1. 27.
 * @version 1.0
 * @param <T>
 * @see <pre>
 *  Class Name  : MockCoreDao.java
 *  Description : JsTree Spring+iBatis 버젼의 JUnit4 테스트 클래스
 *  Infomation  : JsTree 코어 서비스를 검증하는데 사용되는, DB를 사용하지 않는 Mock DAO
 * 
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2015. 1. 27.  류강하                 최초 생성
 * 
 *  Copyright (C) 2015 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class MockCoreDao<T> implements CoreDao {

    private List<ComprehensiveTree> tree = new ArrayList<>();
    
    public MockCoreDao() {
        ComprehensiveTree rootNode = new ComprehensiveTree();
        rootNode.setC_id(1);
        rootNode.setC_type(null);
        rootNode.setC_left(1);
        rootNode.setC_right(4);
        rootNode.setC_position(0);
        rootNode.setC_title("Root Node");
        rootNode.setC_parentid(0);
        tree.add(rootNode);
        
        ComprehensiveTree firstChildNode = new ComprehensiveTree();
        firstChildNode.setC_id(2);
        firstChildNode.setC_type("drive");
        firstChildNode.setC_left(2);
        firstChildNode.setC_right(3);
        firstChildNode.setC_position(0);
        firstChildNode.setC_title("First Child Node");
        firstChildNode.setC_parentid(1);
        tree.add(firstChildNode);
    }
    
    @SuppressWarnings({ "hiding", "unchecked" })
    @Override
    public <T extends ComprehensiveTree> List<T> getChildNode(T pNode) 
            throws Exception {
        
        List<ComprehensiveTree> rChildNodes = new ArrayList<>();
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_parentid() == pNode.getC_id()) {
                rChildNodes.add(node);
            }
        }
        
        // TODO ORDER BY C_POSITION
        
        return (List<T>) rChildNodes;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> List<T> searchNodeByString(
            T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings({ "hiding"})
    @Override
    public <T extends ComprehensiveTree> List<String> searchNodeByPosition(
            List<T> searchNodeByPositions) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings({ "hiding", "unchecked" })
    @Override
    public <T extends ComprehensiveTree> T getNode(T pNode)
            throws Exception {
        
        ComprehensiveTree rNode = null;
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_id() == pNode.getC_id()) {
                rNode = node;
                break;
            }
        }
        
        return (T) rNode;
    }

    @SuppressWarnings({ "hiding", "unchecked" })
    @Override
    public <T extends ComprehensiveTree> T getNodeByRef(T pNode)
            throws Exception {
        
        ComprehensiveTree rNode = null;
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_id() == pNode.getRef()) {
                rNode = node;
                break;
            }
        }
        
        return (T) rNode;
    }

    @SuppressWarnings({ "hiding"})
    @Override
    public <T extends ComprehensiveTree> void cutMyself(
            T p_OnlyCutMyselfFromJstree) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings({ "hiding"})
    @Override
    public <T extends ComprehensiveTree> void stretchPositionForMyselfFromJstree(T pNode) 
            throws Exception {
        
        for (ComprehensiveTree node : tree) {
            
            if ( node.getC_parentid() == pNode.getRef() 
              && node.getC_position() >= pNode.getC_position() ) {
              
                node.setC_position(node.getC_position() + 1);
            }
        }
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void stretchLeftRightForMyselfFromJstree(T pNode) 
            throws Exception {
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_left() >= pNode.getRightPositionFromNodeByRef()) {
              
                node.setC_left(node.getC_left() + pNode.getSpaceOfTargetNode());
            }
        }
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_right() >= pNode.getRightPositionFromNodeByRef()) {
              
                node.setC_right(node.getC_right() + pNode.getSpaceOfTargetNode());
            }
        }
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> int pasteMyselfFromJstree(
            T p_OnlyPasteMyselfFromJstree) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> List<T> getChildNodeByLeftRight(
            T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void fixCopy(T comprehensiveTree)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void fixCopyIF(T comprehensiveTree)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void enterMyselfFromJstree(
            T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> int addMyselfFromJstree(T node) 
            throws Exception {
        
        int id = generateId();
        
        node.setC_id(id);
        
        tree.add(node);
        
        return id;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> int alterNode(T pNode)
            throws Exception {
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_id() == pNode.getC_id()) {
                
                node.setC_type(pNode.getC_type());
                node.setC_title(pNode.getC_title());
            }
        }
        
        return 1;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> int removeNode(T pNode)
            throws Exception {
        
        for (ComprehensiveTree node : tree) {
            
            if ( node.getC_left()  >= pNode.getC_left() 
              && node.getC_right() <= pNode.getC_right() ) {
                
                tree.remove(node);
            }
        }
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_left() > pNode.getC_right()) {

                node.setC_left( node.getC_left() - pNode.getSpaceOfTargetNode() );
            }
        }
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_right() > pNode.getC_left()) {

                node.setC_right( node.getC_right() - pNode.getSpaceOfTargetNode() );
            }
        }
        
        for (ComprehensiveTree node : tree) {
            
            if ( node.getC_parentid() == pNode.getC_parentid()
              && node.getC_position() >  pNode.getC_position() ) {

                node.setC_position( node.getC_position() - 1 );
            }
        }
        
        return 0;
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> int alterNodeType(T comprehensiveTree)
            throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }


    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void enterMyselfFixPosition(
            T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings({ "hiding" })
    @Override
    public <T extends ComprehensiveTree> void enterMyselfFixLeftRight(
            T comprehensiveTree) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
    
    private int generateId() {
        
        int id = 0;
        
        for (ComprehensiveTree node : tree) {
            
            if (node.getC_id() > id) {
                
                id = node.getC_id();
            }
        }
        
        return id + 1;
    }
    
    public int generatePosition(ComprehensiveTree pNode) {
        
        int maxPosition = 0;
        
        for (ComprehensiveTree node : tree) {
            
            if ( node.getC_parentid() == pNode.getC_id() 
              && node.getC_position() > maxPosition ) {
                
                maxPosition = node.getC_position();
            }
        }
        
        return maxPosition + 1;
    }
}