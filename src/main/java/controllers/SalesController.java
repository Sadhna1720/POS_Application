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
import service.SalesService;

public class SalesController extends MultiActionController{

	ApplicationContext applicationContext;
	DBConnection dbConnection;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	
	public ModelAndView sales(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		ModelAndView mv=new ModelAndView();

		List salesList=((SalesService) applicationContext.getBean("salesService")).salesDataServ(req, res);
		mv.addObject("salesList", salesList);
		
		mv.setViewName("pages/sales");
		return mv;
	}
}