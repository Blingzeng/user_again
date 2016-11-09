package cn.bling.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



import cn.bling.domain.Cust;

public interface custDao {
	
	public List<Cust> find(Cust cust);
	
	public void add(Cust cust);
	
	public void update(Cust cust);
	
	public void delete(int id);
	
	/**
	 * 带事物管理器的删除方法，用于批量删除，
	 * @param con
	 * @param id
	 * @throws SQLException
	 */
	public void batchDel(int id) throws SQLException;
}
