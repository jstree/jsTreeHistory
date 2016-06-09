package egovframework.com.ext.jstree.support.manager.security.manage.role.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class ResourcesRolesManageVo extends ComprehensiveTree
{
    
    private int rolesId;
    
    private int resourcesId;
    
    
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

    @Override
    public String getSqlMapSelector()
    {
        return "rolesResources";
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
