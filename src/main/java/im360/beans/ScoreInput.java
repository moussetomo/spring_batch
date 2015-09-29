package im360.beans;

/**
 * This class represents a mapped object from input file
 * @author takaimasatomo
 *
 */
public class ScoreInput {
	/**
	 * Student ID
	 */
	private int studentId;
	
	/**
	 * Course ID
	 */
	private String courseId;
	
	/**
	 * Score
	 */
	private int score;
	
	/**
	 * calculate course grade based on its score
	 * @return A for >= 90, B for >= 80, C for >= 70, D for >= 60, F otherwise
	 */
	public String calculateGrade() {
		if(this.score >= 90) {
			return "A";
		}
		else if(this.score >= 80) {
			return "B";
		}
		else if(this.score >= 70) {
			return "C";
		}
		else if(this.score >= 60) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	// getters and setters
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
