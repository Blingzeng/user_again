package cn.bling.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import cn.bling.domain.Cust;
import cn.bling.until.DaoUtils;
import cn.bling.until.TransationMessage;

public class custDaoImpl implements custDao {

	public List<Cust> find(Cust cust) {
		// TODO Auto-generated method stub
		String sql = "select * from cust where 1=1 ";
		ArrayList list = new ArrayList();
		if(cust==null){
			
		}else{
			if(cust.getId()!=0){
				sql+="and id=? ";
				list.add(cust.getId());
			}
			if(cust.getGender()!=null){
				sql+="and gender=? ";
				list.add(cust.getGender());
			}
			if(cust.getBirthday()!=null){
				sql+="and birthday=? ";
				list.add(cust.getBirthday());
			}
			if(cust.getCellphone()!=null){
				sql+="and cellphone=? ";
				list.add(cust.getCellphone());
			}
			if(cust.getEmail()!=null){
				sql+="and email=? ";
				list.add(cust.getEmail());
			}
			if(cust.getType()!=null){
				sql+="and type=? ";
				list.add(cust.getType());
			}
			if(cust.getName()!=null){
				sql+="and name=? ";
				list.add(cust.getName());
			}
			                                                    
		}
		
			try {
				QueryRunner query = new QueryRunner(DaoUtils.getSource());
				if(list.size()==0){
					return query.query(sql, new BeanListHandler<Cust>(Cust.class));
				}else{
					return query.query(sql, new BeanListHandler<Cust>(Cust.class), list.toArray());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
			
		
		
	}

	public void add(Cust cust) {
		
		try {
			String sql = "insert into cust values (null,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(Cust cust) {
		
		try {
			String sql = "update cust set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=? where id=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void delete(int id) {
		
		try {
			String sql = "delete from cust where id=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchDel(int id) throws SQLException {
		
		
			String sql = "delete from cust where id=?";
			QueryRunner runner = new QueryRunner();
			runner.update(TransationMessage.getConnection(),sql,id);
		
	}

	


}
