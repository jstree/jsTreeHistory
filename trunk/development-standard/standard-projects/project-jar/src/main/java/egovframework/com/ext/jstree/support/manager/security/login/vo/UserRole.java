package egovframework.com.ext.jstree.support.manager.security.login.vo;

import org.springframework.security.core.GrantedAuthority;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class UserRole extends ComprehensiveTree implements GrantedAuthority
{
    
    private static final long serialVersionUID = 9118124824701495647L;
    
    private int email;
    
    private String role;
    
    public int getEmail()
    {
        return email;
    }
    
    public void setEmail(int email)
    {
        this.email = email;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    @Override
    public String getAuthority()
    {
        return this.role;
    }
    
    @Override
    public String getSqlMapSelector()
    {
        return "userRole";
    }
    
}
