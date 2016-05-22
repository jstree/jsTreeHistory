package egovframework.com.ext.jstree.support.manager.security.roles.vo;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class SecuredObjectMapping extends ComprehensiveTree
{
    private int rolesId;
    
    private int resourcesId;
    
    private int userId;

    public int getRolesId()
    {
        return rolesId;
    }

    public void setRolesId(int rolesId)
    {
        this.rolesId = rolesId;
    }

    public int getResourcesId()
    {
        return resourcesId;
    }

    public void setResourcesId(int resourcesId)
    {
        this.resourcesId = resourcesId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    
}
