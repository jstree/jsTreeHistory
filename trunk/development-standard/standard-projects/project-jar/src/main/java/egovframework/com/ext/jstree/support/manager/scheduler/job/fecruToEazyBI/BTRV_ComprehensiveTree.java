package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class BTRV_ComprehensiveTree extends ComprehensiveTree
{
    private String c_project;
    private String c_path;
    private String c_rev;
    private String c_author;
    private String c_commitdate;
    private String c_rv;
    private String c_bt;
    private String c_svnlog;
    
    public String getC_project()
    {
        return c_project;
    }
    public void setC_project(String c_project)
    {
        this.c_project = c_project;
    }
    public String getC_path()
    {
        return c_path;
    }
    public void setC_path(String c_path)
    {
        this.c_path = c_path;
    }
    public String getC_rev()
    {
        return c_rev;
    }
    public void setC_rev(String c_rev)
    {
        this.c_rev = c_rev;
    }
    public String getC_author()
    {
        return c_author;
    }
    public void setC_author(String c_author)
    {
        this.c_author = c_author;
    }
    public String getC_commitdate()
    {
        return c_commitdate;
    }
    public void setC_commitdate(String c_commitdate)
    {
        this.c_commitdate = c_commitdate;
    }
    public String getC_rv()
    {
        return c_rv;
    }
    public void setC_rv(String c_rv)
    {
        this.c_rv = c_rv;
    }
    public String getC_bt()
    {
        return c_bt;
    }
    public void setC_bt(String c_bt)
    {
        this.c_bt = c_bt;
    }
    public String getC_svnlog()
    {
        return c_svnlog;
    }
    public void setC_svnlog(String c_svnlog)
    {
        this.c_svnlog = c_svnlog;
    }
    
    @Override
    public String getSqlMapSelector()
    {
        return "BTRV";
    }
    
}
