package egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SvnDataImporter implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public void execute(JobExecutionContext arg0) throws JobExecutionException {

            System.out.println("실행됨");
    }

   
}