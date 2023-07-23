package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public Boolean productAddServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		VariableService variableService = ((VariableService) applicationContext.getBean("variableService"));
		connection = dbConnection.connectionMethod(); // calling connectionMethod() for establish connection
		Boolean flag = false;
		
		// mapping form data into VariableService class
		variableService.setName(req.getParameter("productName"));
		variableService.setProductId(req.getParameter("productId"));
		variableService.setSellingPrice(req.getParameter("sellPrice"));
		variableService.setTax(req.getParameter("tax"));
		variableService.setCategory(req.getParameter("category"));

		if (variableService.getName() == null || variableService.getProductId() == null
				|| variableService.getSellingPrice() == null || variableService.getTax() == null
				|| variableService.getCategory() == null) {
			System.out.println("Error in productService/productAddServ................");
			flag = false;
		} else {
			resultSet = dbConnection.resultData("select * from poscategory where category='"+variableService.getCategory()+"'");
			try {
				if (resultSet.next()) {
					// calling resultProductAdd() for store data in DB
					flag = (dbConnection.resultProductAdd(variableService,
							"insert into posproduct(product_name,product_Id,selling_price,tax,category) values(?,?,?,?,?)"));
				}
			} catch (SQLException e) {
				System.out.println("ProductSet/productAddServ...catch.......exception.........");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List<VariableService> productListServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService"); 
		connection = dbConnection.connectionMethod();  // calling connectionMethod() for establish connection
		List<VariableService> productList = new ArrayList<VariableService>();
		try {
			preparedStatement = connection.prepareStatement("select * from posproduct");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				VariableService variableService = new VariableService();				
				variableService.setName(resultSet.getString("product_name"));
				variableService.setProductId(resultSet.getString("product_Id"));
				variableService.setCategory(resultSet.getString("category"));
				variableService.setSellingPrice(resultSet.getString("selling_price"));
				variableService.setTax(resultSet.getString("tax"));
				productList.add(variableService);
			}
		} catch (SQLException e) {
			System.out.println("CategoryService/categoryListServ/catch......exception.........");
			e.printStackTrace();
		}
		return productList;
	}
}
