package cn.bling.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;



import cn.bling.dao.custDao;
import cn.bling.domain.Cust;
import cn.bling.exception.msgException;
import cn.bling.factor.BasicFactory;
import cn.bling.service.custService;

public class test {

	custDao dao = BasicFactory.getFactory().getInstance(custDao.class);
	custService service =BasicFactory.getFactory().getInstance(custService.class);
	@Test
	public void daoTest(){
//		System.out.println(test.class.getClassLoader().getResource("config.properties").getPath());
//		File file = new File(test.class.getClassLoader().getResource("config.properties").getPath());
//		if(file.isFile()){
//			try {
//				InputStream in = new FileInputStream(file);
//				int temp = 0;
//				while((temp=in.read())!=-1){
//					System.out.write(temp);
//				}
//				in.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		Cust cust = new Cust();
		cust.setName("wangwu");
		cust.setGender("男");
		String str = "2001-1-1";
		java.util.Date da = new java.util.Date();
		SimpleDateFormat fm =new SimpleDateFormat("yyyy-mm-dd");
		try {
			da = fm.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date= new Date(da.getTime());
		cust.setBirthday(date);
		cust.setCellphone("123456789");
		cust.setEmail("123@123.com");
		cust.setPreference("jfi");
		cust.setType("黄金用户");
		dao.add(cust);
	}
	
	@Test
	public void momeyTest() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		runner.update("insert into memoy values (null,?,?)","c",888);
	}
	
	@Test
	public void momeyTestOld(){
		Connection connection = null;
		PreparedStatement pre = null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			connection = source.getConnection();
			pre=connection.prepareStatement("insert into momey values (null,?,?)");
			pre.setString(0, "c");
			pre.setDouble(1, 444);
			pre.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Test
	public void findTest(){
		Cust cust = new Cust();
		cust.setName("张三");
		List<Cust> list = dao.find(cust);
		if(list!=null){
			for(Cust c : list){
				System.out.println(c.getName());
			}
		}
	}
	
	
	@Test
	public void addServiceTest() throws msgException{
		Cust cust = new Cust();
		cust.setName("wangwru");
		cust.setGender("男");
		String str = "2001-1-1";
		java.util.Date da = new java.util.Date();
		SimpleDateFormat fm =new SimpleDateFormat("yyyy-mm-dd");
		try {
			da = fm.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date= new Date(da.getTime());
		cust.setBirthday(date);
		cust.setCellphone("123456789");
		cust.setEmail("123@123.com");
		cust.setPreference("jfi");
		cust.setType("黄金用户");
		service.addCust(cust);
	}
}
