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

public class InventoryService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	VariableService variableService;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public List<VariableService> inventory(HttpServletRequest req, HttpServletResponse res) {
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
				variableService.setQty(resultSet.getString("qty"));
				productList.add(variableService);
			}
		} catch (SQLException e) {
			System.out.println("CategoryService/categoryListServ/catch......exception.........");
			e.printStackTrace();
		}
		return productList;
	}
}
