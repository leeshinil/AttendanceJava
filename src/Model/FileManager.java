package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class FileManager {
	public void saveStudentInfoInFile(ArrayList<StudentInfo> studentInfoList, String fileName) {//담은 ArrayList를 파일에 저장.
		

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(studentInfoList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<StudentInfo> readStudentInforInFile(String fileName) { 
		ObjectInputStream ois = null;
		ArrayList<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
		
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			studentInfoList = (ArrayList<StudentInfo>) ois.readObject();
			return studentInfoList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
