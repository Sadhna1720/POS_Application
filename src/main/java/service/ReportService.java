package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportService {
	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public List<VariableService> ReportPurchaseServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		connection = dbConnection.connectionMethod(); // calling connectionMethod() for establish connection
		List<VariableService> productList = new ArrayList<VariableService>();
		productList= dbConnection.SPreportData("select pr.bill_number, pr.supplier_name, cr.product_name, pr.payable_price from purchasereport pr join commonreport cr on cr.bill_number=pr.bill_number","purchasereport");
		return productList;
	}
	public List<VariableService> ReportSalesServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		
		// calling connectionMethod() for establish connection
		connection = dbConnection.connectionMethod();  
		List<VariableService> productList = new ArrayList<VariableService>();
		
		//calling salesReportData() for retrieve sales-Report data
		productList=dbConnection.SPreportData("select sr.bill_number, sr.payable_price, cr.product_name from salesreport sr join commonreport cr on cr.bill_number=sr.bill_number","salesreport"); 		
		return productList;
	}
	public void export(HttpServletRequest req, HttpServletResponse res, String tableName) throws FileNotFoundException, IOException, SQLException {
		System.out.println("export method start............");
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		
		try {
			dbConnection.exportExcel(req, res, tableName);
		} catch (ServletException e) {
			e.printStackTrace();
		} 		
	}
}
