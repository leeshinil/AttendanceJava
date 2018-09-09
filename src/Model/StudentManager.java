package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StudentManager {
	HashMap<Integer, StudentInfo> studentList = new HashMap<Integer, StudentInfo>();

	public HashMap<Integer, StudentInfo> getStudentList() {
		return studentList;
	}

	public StudentInfo getStudent(int studentNum) {
		return studentList.get(studentNum);
	}

	public boolean deleteStudent(int studentNum) {
		if (isStudent(studentNum)) {
			studentList.remove(studentNum);
			return false;
		} else {
			return true;
		}
	}

	public void addStudentFromFile(ArrayList<StudentInfo> studentInfoList) {
		for (int i = 0; i < studentInfoList.size(); i++) {
			addStudent(studentInfoList.get(i).getName(), studentInfoList.get(i).getStudentNum(),
					studentInfoList.get(i).getGrade(), studentInfoList.get(i).getScore());
		}
	}

	public boolean addStudent(String name, int studentNum, int grade, double score) {
		if (isStudent(studentNum)) {
			String str_studentNum = String.valueOf(studentNum);
			int class_no = Integer.parseInt(str_studentNum.substring(4, 7));
			studentList.put(studentNum, new StudentInfo(name, studentNum, grade, score, class_no));
			return true;
		} else {
			return false;
		}
	}

	public boolean isStudent(int studentNum) {
		if (!studentList.containsKey(studentNum)) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<StudentInfo> getStudentInfoList() {// StudentInfo에 저장된 것들을
														// ArrayList에 담는 메소드
		ArrayList<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
		Iterator<Integer> key = studentList.keySet().iterator();
		while (key.hasNext()) {
			int findKey = key.next();
			StudentInfo studentInfo = studentList.get(findKey);
			studentInfoList.add(studentInfo);
		}
		return studentInfoList;
	}
}
