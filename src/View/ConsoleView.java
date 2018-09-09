package View;

import java.util.HashMap;
import java.util.Iterator;

import Model.StudentInfo;

public class ConsoleView {
	public void printName(String name){
		System.out.println("내이름은 " + name);
	}
	public void printAddState(boolean addState) {
		if (addState) {
			System.out.println("***추가성공***");
		} else {
			System.out.println("중복!");
		}
	}
	public void printDeleteState(boolean deleteState) {
		if (deleteState) {
			System.out.println("*** 삭제성공  ***");
		} else {
			System.out.println(deleteState);
			System.out.println("없는 학생 입니다.");
		}
	}
	public void printAll(HashMap<Integer, StudentInfo> studentList) {
		Iterator<Integer> key = studentList.keySet().iterator();
		while(key.hasNext()) {
			int findKey = key.next();
			StudentInfo studentInfo = studentList.get(findKey);
			System.out.println("학번 = " + findKey + ", 이름 = " + studentInfo.getName() + ", 학년 = " + studentInfo.getGrade() + ", 평점 = " + studentInfo.getScore());
		}
	}
	public void printClassAll(HashMap<Integer, StudentInfo> studentList, int class_no) {
		Iterator<Integer> key = studentList.keySet().iterator();
		while(key.hasNext()) {
			int findKey = key.next();
			StudentInfo studentInfo = studentList.get(findKey);
			if(studentInfo.getClass_no() == class_no)
				System.out.println("학번 = " + findKey + ", 이름 = " + studentInfo.getName() + ", 학년 = " + studentInfo.getGrade() + ", 평점 = " + studentInfo.getScore());
		}
	}
}
