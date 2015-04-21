package egovframework.com.ext.jstree.support.manager.jarExcute;

import egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI.SvnDataImporter;

public class App
{
    
    public static void main(String[] args)
    {
        SvnDataImporter svnDataImporter = new SvnDataImporter();
        svnDataImporter.execute();
        
    }
    
}
