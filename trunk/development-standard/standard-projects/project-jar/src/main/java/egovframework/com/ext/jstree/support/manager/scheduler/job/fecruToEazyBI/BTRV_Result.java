package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import egovframework.com.ext.jstree.springiBatis.core.vo.ComprehensiveTree;

public class BTRV_Result extends ComprehensiveTree
{
    
    private String c_resultdate;
    
    private String c_resultstring;
    
    private String orderString;
    
    

    public String getOrderString()
    {
        return orderString;
    }

    public void setOrderString(String orderString)
    {
        this.orderString = orderString;
    }

    public String getC_resultdate()
    {
        return c_resultdate;
    }
    
    public void setC_resultdate(String c_resultdate)
    {
        this.c_resultdate = c_resultdate;
    }
    
    public String getC_resultstring()
    {
        return c_resultstring;
    }
    
    public void setC_resultstring(String c_resultstring)
    {
        this.c_resultstring = c_resultstring;
    }
    
    @Override
    public String getSqlMapSelector()
    {
        return "BTRV_RESULT";
    }
    
}
