package standard.mvc.component.business.community.menu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import standard.mvc.component.business.community.menu.vo.MenuComprehensiveTree;

public interface MenuService
{
    public List<MenuComprehensiveTree> getMenuList() throws Exception;
    
    public MenuComprehensiveTree getNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public List<MenuComprehensiveTree> getChildNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public List<String> searchNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public MenuComprehensiveTree addNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public int removeNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public int alterNode(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public int alterNodeType(MenuComprehensiveTree menuComprehensiveTree) throws Exception;
    
    public MenuComprehensiveTree moveNode(MenuComprehensiveTree menuComprehensiveTree, HttpServletRequest request)
            throws Exception;
}
