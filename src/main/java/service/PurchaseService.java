package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PurchaseService {

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public Boolean purchaseServ(HttpServletRequest req, HttpServletResponse res) {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		dbConnection = (DBConnection) applicationContext.getBean("dbConnectionService");
		VariableService variableService = ((VariableService) applicationContext.getBean("variableService"));
		connection = dbConnection.connectionMethod();
		
		
		
		return true;
	}
}