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

public class CustomerService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	
	public Boolean customerAddServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		VariableService variableService = ((VariableService) applicationContext.getBean("variableService"));
		connection = dbConnection.connectionMethod();  // calling connectionMethod() for establish connection
		Boolean flag = false;
		
		// mapping form data into VariableService class
		variableService.setName(req.getParameter("customerName"));
		variableService.setContact(req.getParameter("customerContact"));
		variableService.setAddress(req.getParameter("customerCity"));
		
		if (variableService.getAddress() == null || variableService.getContact()== null
				|| variableService.getName() == null ) {
			System.out.println("Error in customerService/customerAddServ................");
			flag = false;
		} else {
			try {
				// calling resulttAdd() for store data in DB
					flag =(dbConnection.resulttAdd(variableService,
							"insert into customerinfo(customer_name,customer_contact,customer_city) values(?,?,?)"));
			} catch (Exception e) {
				System.out.println("customerService/customerAddServ...catch.......exception.........");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List<VariableService> customerListServ(HttpServletRequest req, HttpServletResponse res) {

		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		connection = dbConnection.connectionMethod(); // calling connectionMethod() for establish connection
		List<VariableService> customerList = new ArrayList<VariableService>();
		try {
			preparedStatement = connection.prepareStatement("select * from customerinfo");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				VariableService variableService = new VariableService();				
				variableService.setName(resultSet.getString("customer_name"));
				variableService.setContact(resultSet.getString("customer_contact"));
				variableService.setAddress(resultSet.getString("customer_city"));
				customerList.add(variableService);  
			}
		} catch (SQLException e) {
			System.out.println("customerService/customerListServ/catch......exception.........");
			e.printStackTrace();
		}
		return customerList;
	}
}
