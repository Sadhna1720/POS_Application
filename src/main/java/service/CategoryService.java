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

public class CategoryService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	VariableService variableService ;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection;

	public Boolean categoryAddServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		variableService = ((VariableService) applicationContext.getBean("variableService"));
		connection = dbConnection.connectionMethod();  // calling connectionMethod() for establish connection
		Boolean flag = false;
		variableService.setCategory((req.getParameter("category")));  // mapping form data into VariableService class
		try {
			preparedStatement = connection.prepareStatement("insert into poscategory(category) values(?)");
			preparedStatement.setString(1, variableService.getCategory());
			if (preparedStatement.executeUpdate() == 1)
				flag = true;
		} catch (SQLException e) {
			System.out.println("CategoryService/categoryAddServ/catch......exception.........");
			flag = false;
			e.printStackTrace();
		}

		return flag;
	}

	public List categoryListServ(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("CategoryService/categoryListServ.............started........");
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		connection = dbConnection.connectionMethod(); // calling connectionMethod() for establish connection
		List<String> CategoryList = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareStatement("select category from poscategory");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CategoryList.add(resultSet.getString("category"));
			}
		} catch (SQLException e) {
			System.out.println("CategoryService/categoryListServ/catch......exception.........");
			e.printStackTrace();
		}
		return CategoryList;
	}

}
