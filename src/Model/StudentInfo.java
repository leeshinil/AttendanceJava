/*
 학번 이름 학년 평점정보
 
 */

package Model;

import java.io.*;

@SuppressWarnings("serial")
public class StudentInfo implements Serializable {
	String name;
	int studentNum, grade;
	double score;
	int class_no;

	public StudentInfo(String name, int studentNum, int grade, double score, int class_no) {
		this.name = name;
		this.studentNum = studentNum;
		this.grade = grade;
		this.score = score;
		this.class_no = class_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getClass_no() {
		return class_no;
	}

	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}
}
