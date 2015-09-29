package im360;

import java.util.HashMap;

import im360.writer.HibernateUtil;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Batch job start point
 * @author takaimasatomo
 *
 */
public class BatchLauncher {
 
  public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobParametersInvalidException, JobInstanceAlreadyCompleteException {
	  try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:batch.xml")) {
		  // get the launcher
	      JobLauncher jobLauncher = (JobLauncher) appContext.getBean("jobLauncher");
	      // get the job
	      Job job = (Job) appContext.getBean("courseEvaluationJob");
	      // run the job
	      jobLauncher.run(job, new JobParameters());
	      
	  } catch(Exception ex) {
		  ex.printStackTrace();
	  }
	  finally {
		  HibernateUtil.closeSessionFactory();
	  }
  }
}