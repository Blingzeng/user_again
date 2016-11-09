package cn.bling.service;

import java.util.List;

import cn.bling.domain.Cust;
import cn.bling.exception.msgException;


public interface custService {

	/**
	 * 增加用户的方法，先调用dao层中的find方法，如果确认没有同名的情况下，在调用add方法，如果有同名的方法，则抛出一个msgEXception
	 * @param cust
	 * @throws msgException
	 */
	void addCust(Cust cust) throws msgException;

	List<Cust> findAll();

	void delete(int parseInt);

	void batchDel(String[] strs);

	Cust findCustById(String id);

	void updateCust(Cust cust);

	

}
