package in.JDBC.service;

import in.JDBC.daoFactory.StudentDaoFactory;
import in.JDBC.dto.Student;
import in.JDBC.persistence.IStudentDao;


public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	@Override
	public String addStudents(String sname, Integer sage, String saddress)  {
		
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.addStudents(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudents(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudents(student);
	}

	@Override
	public String deleteStudents(Integer sid) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudents(sid);
	}

}
