/*
 �л���������, �а������� �߰� ���� ���� �ҷ�������
 */

package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import Model.FileManager;
import Model.StudentInfo;
import Model.StudentManager;
import View.ConsoleView;

public class StudentController {

	public void run() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ConsoleView consoleView = new ConsoleView();
		StudentManager studentManager = new StudentManager();
		FileManager fileManager = new FileManager();
		while (true) {
			System.out.println("���ڸ� �Է��ϼ��� : (1)��ü�л����, (2)�а��л����,(3)�л��߰�, (4)�л�����, (5)����, (6)�ҷ�����, (7)������ ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				consoleView.printAll(studentManager.getStudentList());
				break;

			case 2:
				System.out.println("�а��ڵ带 �Է��ϼ��� :");
				int class_no = Integer.parseInt(sc.nextLine());
				consoleView.printClassAll(studentManager.getStudentList(), class_no);
				break;

			case 3:
				System.out.println("�й��� �Է��ϼ���. OOOOXXX000 ����, XXX�� �а��ڵ�:  ");
				int studentNum = Integer.parseInt(sc.nextLine());
				System.out.println("�̸��� �Է��ϼ��� : ");
				String name = sc.nextLine();
				System.out.println("�г��� �Է��ϼ��� : ");
				int grade = Integer.parseInt(sc.nextLine());
				System.out.println("������ �Է��ϼ��� : ");
				double score = Double.parseDouble(sc.nextLine());
				boolean addState = studentManager.addStudent(name, studentNum, grade, score);
				consoleView.printAddState(addState);
				break;

			case 4:// �л� ����
				System.out.println("�й��� �Է��ϼ��� : ");
				studentNum = Integer.parseInt(sc.nextLine());
				boolean deleteState = studentManager.deleteStudent(studentNum);
				consoleView.printDeleteState(deleteState);
				break;

			case 5:
				System.out.println("������ ���ϸ��� �Է��ϼ���. ������ �����ϸ� ���� ������ �������ϴ�. : ");
				String fileName = sc.nextLine();
				fileManager.saveStudentInfoInFile(studentManager.getStudentInfoList(), fileName);
				break;

			case 6:
				System.out.println("�ҷ��� ���ϸ��� �Է��ϼ���. �������� ���� ������ �������ϴ�. : ");
				fileName = sc.nextLine();
				ArrayList<StudentInfo> studentInfoList = fileManager.readStudentInforInFile(fileName);
				studentManager.addStudentFromFile(studentInfoList);
				break;

			case 7:
				return;
			default:
				break;
			}
		}

	}
}