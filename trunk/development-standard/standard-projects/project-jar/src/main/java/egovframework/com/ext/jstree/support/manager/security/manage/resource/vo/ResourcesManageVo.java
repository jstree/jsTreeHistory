package egovframework.com.ext.jstree.support.manager.security.manage.resource.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class ResourcesManageVo extends ComprehensiveTree
{
    
    private String pattern;
    
    private String description;
    
    private String resourceType;
    
    private int sort;
    
    private String regId;
    
    private String regDt;
    
    private String modId;
    
    private String modDt;
    
    private String roleId;
    
    public String getPattern()
    {
        return pattern;
    }
    
    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getResourceType()
    {
        return resourceType;
    }
    
    public void setResourceType(String resourceType)
    {
        this.resourceType = resourceType;
    }
    
    public int getSort()
    {
        return sort;
    }
    
    public void setSort(int sort)
    {
        this.sort = sort;
    }
    
    public String getRegId()
    {
        return regId;
    }
    
    public void setRegId(String regId)
    {
        this.regId = regId;
    }
    
    public String getRegDt()
    {
        return regDt;
    }
    
    public void setRegDt(String regDt)
    {
        this.regDt = regDt;
    }
    
    public String getModId()
    {
        return modId;
    }
    
    public void setModId(String modId)
    {
        this.modId = modId;
    }
    
    public String getModDt()
    {
        return modDt;
    }
    
    public void setModDt(String modDt)
    {
        this.modDt = modDt;
    }
    
    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String getSqlMapSelector()
    {
        return "resources";
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
