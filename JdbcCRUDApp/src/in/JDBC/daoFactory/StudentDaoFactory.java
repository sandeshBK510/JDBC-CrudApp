package in.JDBC.daoFactory;

import in.JDBC.persistence.IStudentDao;
import in.JDBC.persistence.StudentDaoImp;

public class StudentDaoFactory {
	
	private StudentDaoFactory() {}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImp();
		}
		return studentDao;
	}

}
