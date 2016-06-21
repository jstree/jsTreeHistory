package egovframework.com.ext.jstree.support.manager.security.manage.role.vo;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import edu.emory.mathcs.backport.java.util.Arrays;
import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class RolesManageVo extends ComprehensiveTree
{
    
    private String description;
    
    private String authority;
    
    private List<String> resources;
    
    private String resourcesStr;
    
    private String regId;
    
    private String regDt;
    
    private String modId;
    
    private String modDt;
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getAuthority()
    {
        return authority;
    }
    
    public void setAuthority(String authority)
    {
        this.authority = authority;
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
    
    public List<String> getResources()
    {
        return resources;
    }
    
    public void setResources(List<String> resources)
    {
        this.resources = resources;
    }
    
    public String getResourcesStr()
    {
        return resourcesStr;
    }
    
    public void setResourcesStr(String resourcesStr)
    {
        this.resourcesStr = resourcesStr;
    }
    
    @Override
    public String getSqlMapSelector()
    {
        return "roles";
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    public void split()
    {
        if (StringUtils.isNotEmpty(resourcesStr))
        {
            resources = Arrays.asList(StringUtils.split(resourcesStr, ","));
        }
    }
    
    public void join()
    {
        if (StringUtils.isNotEmpty(resourcesStr))
        {
            resourcesStr = StringUtils.join(resources, ",");
        }
    }
}
