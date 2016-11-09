package cn.bling.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;




import cn.bling.dao.custDao;
import cn.bling.domain.Cust;
import cn.bling.exception.msgException;
import cn.bling.factor.BasicFactory;
import cn.bling.until.DaoUtils;
import cn.bling.until.TransationMessage;

public class custServiceImpl implements custService {

	custDao dao = BasicFactory.getFactory().getInstance(custDao.class);
	
	public void addCust(Cust cust) throws msgException {
		// TODO Auto-generated method stub
		//1. 检查用户是否存在
		Cust temp = new Cust();
		temp.setName(cust.getName());
		List<Cust> list = dao.find(temp);
		if(list.size()!=0){
			throw new msgException("该用户已经存在");
		}else{
			//2.调用到dao层的add方法
			dao.add(cust);
		}
		
		
	}

	public List<Cust> findAll() {
		// TODO Auto-generated method stub
		return dao.find(null);
		
	}

	public void delete(int parseInt) {
		dao.delete(parseInt);
		
	}

	/**
	 * 带有事物管理的批量删除的方法
	 */
	public void batchDel(String[] strs) {
		//遍历集合中的id，然后一个一个的删除，为了预防一些情况发生不恰当的事故，导致删除进行到一半就不再进行，
		//我们启用事物管理来处理这一种情况，如果在删除的中途发生什么事故，那么便会回滚到事物的最开始。
		
		try {
			TransationMessage.start();
			for(String id : strs){
				dao.batchDel(Integer.parseInt(id));
			}
			TransationMessage.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			TransationMessage.rollBack();
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			TransationMessage.release();
		}
		
	}

	public Cust findCustById(String id) {
		//调用dao层的find方法，查询用户，将查询到的用户放回
		Cust temp = new Cust();
		temp.setId(Integer.parseInt(id));
		List<Cust> list = dao.find(temp);
		return list.size()==0? null:list.get(0);
	}

	public void updateCust(Cust cust) {
		dao.update(cust);
		
	}

}
