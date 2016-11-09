package cn.bling.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;



import cn.bling.domain.Cust;
import cn.bling.exception.msgException;
import cn.bling.factor.BasicFactory;
import cn.bling.service.custService;

public class AddCustServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCustServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//1 将数据封装成javabean
		BasicFactory factory = BasicFactory.getFactory();
		custService service = factory.getInstance(custService.class);
		Cust cust =null; 
		
		try {
			cust= new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//因为爱好是由多个值在一起的，所以要另外的设置。
			String pre[] = request.getParameterValues("preference");
			if(pre!=null){
				StringBuffer s = new StringBuffer();
				for(String pref:pre){
					s.append(pref+",");
				}
				String prefe=s.substring(0, s.length()-1);
				cust.setPreference(prefe);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} 
		
		//2.调用service 中的addCust方法添加客户
		try {
			service.addCust(cust);
		} catch (msgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.重定向到主页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
