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

public class SupplierService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	
	public Boolean supplierAddServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		VariableService variableService = ((VariableService) applicationContext.getBean("variableService"));
		connection = dbConnection.connectionMethod(); // calling connectionMethod() for establish connection
		Boolean flag = false;
		
		// mapping form data into VariableService class
		variableService.setName(req.getParameter("supplierName"));
		variableService.setContact(req.getParameter("supplierContact"));
		variableService.setAddress(req.getParameter("supplierAddress"));
		
		if (variableService.getAddress() == null || variableService.getContact()== null
				|| variableService.getName() == null ) {
			System.out.println("Error in SupplierService/SupplierAddServ................");
			flag = false;
		} else {
			try {
				// calling resulttAdd() for store data in DB
					flag = (dbConnection.resulttAdd(variableService,
							"insert into supplierinfo(supplier_name,supplier_contact,supplier_address) values(?,?,?)"));
			} catch (Exception e) {
				System.out.println("SupplierService/supplierAddServ...catch.......exception.........");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List<VariableService> supplierListServ(HttpServletRequest req, HttpServletResponse res) {

		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		connection = dbConnection.connectionMethod();  // calling connectionMethod() for establish connection
		List<VariableService> supplierList = new ArrayList<VariableService>();
		try {
			preparedStatement = connection.prepareStatement("select * from supplierinfo");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				VariableService variableService = new VariableService();				
				variableService.setName(resultSet.getString("supplier_name"));
				variableService.setContact(resultSet.getString("supplier_contact"));
				variableService.setAddress(resultSet.getString("supplier_address"));
				supplierList.add(variableService);
			}
		} catch (SQLException e) {
			System.out.println("suppierService/supplierListServ/catch......exception.........");
			e.printStackTrace();
		}
		return supplierList;
	}
}
