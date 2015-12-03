package standard.mvc.component.business.community.menu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import standard.mvc.component.business.community.menu.vo.MenuComprehensiveTree;
import egovframework.com.ext.jstree.springiBatis.core.service.CoreService;

/**
 * Modification Information
 * 
 * @author 류강하
 * @since 2014. 10. 12.
 * @version 1.0
 * @see <pre>
 *  Class Name  : MenuServiceImpl.java
 *  Description : jstree Spring + iBatis 버젼의 메뉴 서비스 구현체
 *  Information : jstree 코어 기능은 코어 서비스를 사용하고, 추가적인 메뉴 관련 작업을 처리하는 클래스이다.
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일               수정자                 수정내용
 *  -------       ------------   -----------------------
 *  2014. 10. 12.  류강하                 최초 생성
 * 
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService
{
    
    @Resource(name = "CoreService")
    CoreService coreService;
    
    public List<MenuComprehensiveTree> getMenuList() throws Exception
    {
        MenuComprehensiveTree menuComprehensiveTree = new MenuComprehensiveTree();
        menuComprehensiveTree.setC_id(7453);
        List<MenuComprehensiveTree> list = new ArrayList<MenuComprehensiveTree>();
        findChildNode(menuComprehensiveTree, list);
        return list;
    }
    
    private void findChildNode(MenuComprehensiveTree menuComprehensiveTree, List<MenuComprehensiveTree> childeNodeList)
            throws Exception
    {
        
        List<MenuComprehensiveTree> list = coreService.getChildNode(menuComprehensiveTree);
        childeNodeList.addAll(list);
        for (MenuComprehensiveTree childNode : list)
        {
            if (isChildNode(childNode))
            {
                findChildNode(childNode, childeNodeList);
            }
        }
    }
    
    private boolean isChildNode(MenuComprehensiveTree menuComprehensiveTree)
    {
        return menuComprehensiveTree.getC_right() - menuComprehensiveTree.getC_left() > 1;
    }
    
    @Override
    public MenuComprehensiveTree getNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        
        return coreService.getNode(menuComprehensiveTree);
    }
    
    @Override
    public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        
        return coreService.getChildNode(menuComprehensiveTree);
    }
    
    @Override
    public List<String> searchNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        return coreService.searchNode(menuComprehensiveTree);
    }
    
    @Override
    public MenuComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        return coreService.addNode(menuComprehensiveTree);
    }
    
    @Override
    public int removeNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        return coreService.removeNode(menuComprehensiveTree);
    }
    
    @Override
    public int alterNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        return coreService.alterNode(menuComprehensiveTree);
    }
    
    @Override
    public int alterNodeType(MenuComprehensiveTree menuComprehensiveTree) throws Exception
    {
        return coreService.alterNodeType(menuComprehensiveTree);
    }
    
    @Override
    public MenuComprehensiveTree moveNode(MenuComprehensiveTree menuComprehensiveTree, HttpServletRequest request)
            throws Exception
    {
        return coreService.moveNode(menuComprehensiveTree, request);
    }
    
}