package cn.bling.factor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BasicFactory {
	private static BasicFactory basicFactory= new BasicFactory();
	private static Properties properties = null;
	private BasicFactory(){
		
	}
	static{
		
		try {
			properties = new Properties();
			properties.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static BasicFactory getFactory(){
		return basicFactory;
	}
	 
	@SuppressWarnings("unchecked")
	public <T> T getInstance(Class<T> clazz) {
		
		try {
			String name = clazz.getSimpleName();
			String fullName = properties.getProperty(name);
			return (T)Class.forName(fullName).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException() ;
		}
	}
	
	
	
	
}
