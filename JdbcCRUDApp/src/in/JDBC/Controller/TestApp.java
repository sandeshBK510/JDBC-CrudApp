package in.JDBC.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.JDBC.dto.Student;
import in.JDBC.service.IStudentService;
import in.JDBC.seviceFactory.StudentServiceFactory;

public class TestApp {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperstion();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}
			br.close();
			
		}
		
	}


	private static void updateOperation() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.print("Student oldName is :: " + student.getSname() + "  Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("Student oldAge is :: " + student.getSage() + "  Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: " + student.getSaddress() + "  Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudents(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}
	}


	
	private static void deleteOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id :: ");
		int sid = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudents(sid);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Result deleted succesfully");
		} else if (msg.equalsIgnoreCase("not found")) {
		  System.out.println("record not foundn for diven id  ...." + sid);
		}else {
			System.out.println("deletion failed...");
		}
		scanner.close();
	}


	
	private static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id :: ");
		int sid = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		
		if (std != null) {
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		} else {
			System.out.println("Record not found for the given id :: " + sid);
		}
		scanner.close();
	}
		
		
	
		private static void insertOperstion() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		         Scanner scanner = new Scanner(System.in) ;
				System.out.println("Enter the name of Student:: ");
				String sname = scanner.next();
				
				System.out.println("Enter the name of Age:: ");
				Integer sage=scanner.nextInt();
				
				System.out.println("Enter the name of Address:: ");
				String saddress=scanner.next();
				
				String msg = studentService.addStudents(sname,sage,saddress) ;
				
				if (msg.equalsIgnoreCase("success")) {
					System.out.println("Result inserted succesfully");
				} else {
				  System.out.println("record insertion failed....");
				}
				scanner.close();
	}	
	
}
	


