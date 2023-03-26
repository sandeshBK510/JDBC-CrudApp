package in.JDBC.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.JDBC.dto.Student;
import in.JDBC.util.JdbcUtil;

public class StudentDaoImp implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addStudents(String sname, Integer sage, String saddress) {
		
		String sqlInsertQuery = "INSERT INTO `mydb`.`student` (`name`, `age`, `address`) VALUES (?, ?, ?)";
		try {
			connection =JdbcUtil.getJdbcConnection();
			
			
			if (connection != null) {
			pstmt=	connection.prepareStatement(sqlInsertQuery);
				
			}
			if (pstmt != null) {
				pstmt.setString(1,sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddress); 
				
				int rowAffected = pstmt.executeUpdate();
				
				if (rowAffected == 1) {
					return "success";
				}
				
				
			}
			
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlInsertQuery = "SELECT * FROM mydb.student where id=?";
		Student student = null;
		try {
			connection =JdbcUtil.getJdbcConnection();
			if (connection != null) {
			pstmt=	connection.prepareStatement(sqlInsertQuery);
				
			}
			if (pstmt != null) {
				pstmt.setInt(1, sid);
				
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				
				student = new Student();
				if (resultSet.next()) {
					
					
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddress(resultSet.getString(4));
					
					return student;
					
				}
				
			}
			
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	

		return null;
	}

	@Override
	public String updateStudents(Student student) {
		
		String sqlUpdateQuery = "update student set name=?,age=?,address=? where id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4, student.getSid());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}
	

	@Override
	public String deleteStudents(Integer sid) {
		String sqlDeleteQuery = "delete from mydb.student where id=?";
		try {
			connection =JdbcUtil.getJdbcConnection();
			if (connection != null) {
			pstmt=	connection.prepareStatement(sqlDeleteQuery);
				
			}
			if (pstmt != null) {
				
				pstmt.setInt(1, sid);
				
				int rowAffected = pstmt.executeUpdate();
				
				if (rowAffected == 1) {
					return "success";
				}else {
					return "not found";
				}
				
				
			}
			
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

}
