package cn.bling.until;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DaoUtils {
	private static ComboPooledDataSource source = null;
	private DaoUtils(){
		
	}
	
	static{
		source = new ComboPooledDataSource();
	}
	
	public static ComboPooledDataSource getSource(){
		return source;
	}
	
	public static Connection getConnection(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
