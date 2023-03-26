package in.JDBC.persistence;

import in.JDBC.dto.Student;

public interface IStudentDao {
	
	//operations to be implemented
   public String addStudents(String sname ,Integer sage , String saddress ) throws Exception ;
	  
   public Student searchStudent(Integer sid);
   
   public String updateStudents(Student student);
   
   public String deleteStudents(Integer sid);
   
}
