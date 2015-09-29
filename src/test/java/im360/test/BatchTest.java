package im360.test;

import static org.junit.Assert.*;
import im360.beans.ScoreInput;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test class for spring batch job
 * @author takaimasatomo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:batch-test.xml"})
public class BatchTest {

	/**
	 * job launcher
	 */
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    /**
     * test gradeCalculationStep
     * @throws Exception
     */
    @Test
    public void launchJob() throws Exception {

    	JobExecution jobExecution = jobLauncherTestUtils.launchStep("gradeCalculationStep");
        
    	// make sure batch is completed
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        
    }
    
    /**
     * test grade calculation
     */
    @Test
    public void testCalculateGrade() {
    	ScoreInput scoreInput = new ScoreInput();
    	scoreInput.setScore(0);
    	assertEquals("F", scoreInput.calculateGrade());
    	scoreInput.setScore(60);
    	assertEquals("D", scoreInput.calculateGrade());
    	scoreInput.setScore(70);
    	assertEquals("C", scoreInput.calculateGrade());
    	scoreInput.setScore(80);
    	assertEquals("B", scoreInput.calculateGrade());
    	scoreInput.setScore(90);
    	assertEquals("A", scoreInput.calculateGrade());
    }
}
