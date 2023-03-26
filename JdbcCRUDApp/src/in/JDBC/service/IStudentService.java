package in.JDBC.service;

import in.JDBC.dto.Student;

public interface IStudentService {

	 public String addStudents(String sname ,Integer sage , String saddress ) ;
	  
	   public Student searchStudent(Integer sid);
	   
	   public String updateStudents(Student student);
	   
	   public String deleteStudents(Integer sid);

	
}
