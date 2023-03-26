package in.JDBC.util;

import java.sql.Connection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static Connection getJdbcConnection() throws Exception {

		HikariConfig config = new HikariConfig("src\\in\\JDBC\\properties\\application.properties");
		 HikariDataSource datasource = new  HikariDataSource(config); 
		 
		 
			return datasource.getConnection();
		
		
	}

	

}
