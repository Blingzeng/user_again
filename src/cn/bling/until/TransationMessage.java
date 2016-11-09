package cn.bling.until;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * 写这个类的原因是因为service层用到了dao层中的对象-connection 为了让service层解耦，使用threadLocal对象来存储connection对象
 * 然后service和到层都来threadlocal来拿这个connection对象。
 * @author Nelson
 *
 */
public class TransationMessage {
	private static Connection connection = DaoUtils.getConnection();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private TransationMessage(){
		
	}
	
	//获取连接
	public static Connection getConnection(){
		if(tl.get()==null){
			tl.set(connection);
		}
		return tl.get();
	}
	
	public static void start(){
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollBack(){
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void release(){
		tl.remove();
	}
	
}
