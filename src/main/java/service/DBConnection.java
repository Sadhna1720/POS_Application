package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class DBConnection {

	Connection connection = null;
	PreparedStatement preparedStatement;
	ResultSet resultSet = null;
	HttpSession session;
	
	public Connection connectionMethod(){
		System.out.println("Connection Requested here..........");
		String username="student",pass="student",url="jdbc:mysql://localhost:3306/pos_db";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,pass);
		}catch(Exception e){
			System.out.println("DB connection exception.....");
			System.out.println(e);
		}
		System.out.println("Connection object returning here..........");
		return connection;
	}
	
	public ResultSet resultData(String id, String query){
		System.out.println("Resultset onject requested here..........");
		try {
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			System.out.println("DB resultSet exception.....");
			e.printStackTrace();
		}
		System.out.println("returning resultset here..........");
		return resultSet;
	}
}
