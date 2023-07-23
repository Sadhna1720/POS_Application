package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import service.DBConnection;
import service.VariableService;

public class PurchaseController extends MultiActionController{
	
	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection;
	DBConnection dbConnection;
	ModelAndView mv;
	String msg;

	public ModelAndView redirectPurchase(HttpServletRequest req, HttpServletResponse res) throws Exception {
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		connection = dbConnection.connectionMethod();
		// calling resultData() and retreiveList() for retrieve productList
		resultSet=dbConnection.resultData("select product_name from posproduct");  
		List productList=dbConnection.retreiveList(resultSet,"product_name");
		mv.addObject("productList", productList);
		
		// calling resultData() and retreiveList() for retrieve SupplierList
		resultSet=dbConnection.resultData("select supplier_name from supplierinfo");
		List supplierList=dbConnection.retreiveList(resultSet,"supplier_name");
		mv.addObject("supplierList", supplierList);
		
		mv.setViewName("pages/purchase");
		return mv;
	}
	
	public ModelAndView purchase(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		mv = new ModelAndView();
		System.out.println("============================");
		return mv;
	}

}
