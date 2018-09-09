/*
 학생정보보기, 학과별보기 추가 삭제 저장 불러오기기능
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
			System.out.println("숫자를 입력하세요 : (1)전체학생목록, (2)학과학생목록,(3)학생추가, (4)학생삭제, (5)저장, (6)불러오기, (7)끝내기 ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				consoleView.printAll(studentManager.getStudentList());
				break;

			case 2:
				System.out.println("학과코드를 입력하세요 :");
				int class_no = Integer.parseInt(sc.nextLine());
				consoleView.printClassAll(studentManager.getStudentList(), class_no);
				break;

			case 3:
				System.out.println("학번을 입력하세요. OOOOXXX000 형식, XXX는 학과코드:  ");
				int studentNum = Integer.parseInt(sc.nextLine());
				System.out.println("이름을 입력하세요 : ");
				String name = sc.nextLine();
				System.out.println("학년을 입력하세요 : ");
				int grade = Integer.parseInt(sc.nextLine());
				System.out.println("평점을 입력하세요 : ");
				double score = Double.parseDouble(sc.nextLine());
				boolean addState = studentManager.addStudent(name, studentNum, grade, score);
				consoleView.printAddState(addState);
				break;

			case 4:// 학생 삭제
				System.out.println("학번을 입력하세요 : ");
				studentNum = Integer.parseInt(sc.nextLine());
				boolean deleteState = studentManager.deleteStudent(studentNum);
				consoleView.printDeleteState(deleteState);
				break;

			case 5:
				System.out.println("저장할 파일명을 입력하세요. 파일이 존재하면 이전 내용은 지워집니다. : ");
				String fileName = sc.nextLine();
				fileManager.saveStudentInfoInFile(studentManager.getStudentInfoList(), fileName);
				break;

			case 6:
				System.out.println("불러올 파일명을 입력하세요. 저장하지 않은 내용은 지워집니다. : ");
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