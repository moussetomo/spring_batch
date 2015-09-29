package im360.beans;

import java.io.Serializable;

/**
 * This class represents mapping to database table
 * @author takaimasatomo
 *
 */
public class GradeOutput implements Serializable {
	/**
	 * default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
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
	 * Grade
	 */
	private String grade;
	
	/**
	 * default constructor
	 */
	public GradeOutput() {}
	
	/**
	 * constructor with parameters
	 * @param studentId
	 * @param courseId
	 * @param score
	 * @param grade
	 */
	public GradeOutput(int studentId, String courseId, int score, String grade) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.score = score;
		this.grade = grade;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if (!(other instanceof GradeOutput)) {
			return false;
		}
		
		GradeOutput otherGrade = (GradeOutput) other;
		return (this.studentId == otherGrade.studentId)
                && ((this.courseId == null) ? (otherGrade.courseId == null) : this.courseId.equals(otherGrade.courseId));
	}
	
	@Override
	public int hashCode() {
        int hashCode = 0;
        hashCode ^= this.studentId; 
        if (this.courseId != null)
            hashCode ^= this.courseId.hashCode();
        return hashCode;
    }
}
