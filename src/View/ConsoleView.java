package View;

import java.util.HashMap;
import java.util.Iterator;

import Model.StudentInfo;

public class ConsoleView {
	public void printName(String name){
		System.out.println("���̸��� " + name);
	}
	public void printAddState(boolean addState) {
		if (addState) {
			System.out.println("***�߰�����***");
		} else {
			System.out.println("�ߺ�!");
		}
	}
	public void printDeleteState(boolean deleteState) {
		if (deleteState) {
			System.out.println("*** ��������  ***");
		} else {
			System.out.println(deleteState);
			System.out.println("���� �л� �Դϴ�.");
		}
	}
	public void printAll(HashMap<Integer, StudentInfo> studentList) {
		Iterator<Integer> key = studentList.keySet().iterator();
		while(key.hasNext()) {
			int findKey = key.next();
			StudentInfo studentInfo = studentList.get(findKey);
			System.out.println("�й� = " + findKey + ", �̸� = " + studentInfo.getName() + ", �г� = " + studentInfo.getGrade() + ", ���� = " + studentInfo.getScore());
		}
	}
	public void printClassAll(HashMap<Integer, StudentInfo> studentList, int class_no) {
		Iterator<Integer> key = studentList.keySet().iterator();
		while(key.hasNext()) {
			int findKey = key.next();
			StudentInfo studentInfo = studentList.get(findKey);
			if(studentInfo.getClass_no() == class_no)
				System.out.println("�й� = " + findKey + ", �̸� = " + studentInfo.getName() + ", �г� = " + studentInfo.getGrade() + ", ���� = " + studentInfo.getScore());
		}
	}
}
