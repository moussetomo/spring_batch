package im360.processor;

import im360.beans.GradeOutput;
import im360.beans.ScoreInput;

import org.springframework.batch.item.ItemProcessor;

/**
 * This class transforms ScoreInput object into GradeOutput, which is a mapping model for database
 * @author takaimasatomo
 *
 */
public class ScoreToGradeProcessor implements ItemProcessor<ScoreInput, GradeOutput> {

	@Override
	public GradeOutput process(ScoreInput score) throws Exception {
		GradeOutput grade = new GradeOutput(score.getStudentId(), score.getCourseId(), score.getScore(), score.calculateGrade());
		return grade;
	}
}
