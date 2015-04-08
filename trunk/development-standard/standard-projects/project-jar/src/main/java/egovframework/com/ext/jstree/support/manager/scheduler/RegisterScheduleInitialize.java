package egovframework.com.ext.jstree.support.manager.scheduler;

import java.text.ParseException;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import egovframework.com.ext.jstree.support.manager.scheduler.job.fecruToEazyBI.SvnDataImporter;

public class RegisterScheduleInitialize extends HttpServlet
{
    
    private static final long serialVersionUID = -8681590480839466978L;
    
    private SchedulerFactory schedulerFactory = null;
    
    private Scheduler scheduler = null;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public RegisterScheduleInitialize()
    {
        try
        {
            logger.info(this.getClass() + "scheduler call");
            schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            
            JobDetail job1 = new JobDetail("job1", "group1", SvnDataImporter.class);
            CronTrigger trigger1 = new CronTrigger("trigger1", "group1", "1 * * * * ?");
            scheduler.scheduleJob(job1, trigger1);
            //
            // JobDetail job2 = new JobDetail("job2", "group2",
            // MakeCsvFromTelnetLog.class);
            // CronTrigger trigger2 = new CronTrigger("trigger2", "group2",
            // "00 20 * * * ?");
            // scheduler.scheduleJob(job2, trigger2);
            //
            // JobDetail job3 = new JobDetail("job3", "group3",
            // TelnetFileDelete.class);
            // CronTrigger trigger3 = new CronTrigger("trigger3", "group3",
            // "00 22 * * * ?");
            // scheduler.scheduleJob(job3, trigger3);
            //
            // JobDetail job4 = new JobDetail("job4", "group4",
            // InsertDBFromCsv.class);
            // CronTrigger trigger4 = new CronTrigger("trigger4", "group4",
            // "00 23 * * * ?");
            // scheduler.scheduleJob(job4, trigger4);
            //
            // JobDetail job5 = new JobDetail("job5", "group5",
            // DeleteCsvData.class);
            // CronTrigger trigger5 = new CronTrigger("trigger5", "group5",
            // "00 30 * * * ?");
            // scheduler.scheduleJob(job5, trigger5);
        }
        catch (SchedulerException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
