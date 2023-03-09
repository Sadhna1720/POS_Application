package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.LoginService;
import service.VariableService;

public class LoginController  extends MultiActionController{

	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("loginController/login.....start.......");
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		VariableService variableService=((VariableService)applicationContext.getBean("variableService"));
		ModelAndView mv = new ModelAndView();
		variableService.setId(req.getParameter("UserId"));
		variableService.setPassword(req.getParameter("Password"));
		
		System.out.println("loginController/productAdd.....goes to call login method.......");
		if(((LoginService) applicationContext.getBean("loginService")).loginServ(req, res)==true) {
			System.out.println("loginController/productAdd.....login method executed and redirected to sales page.......");
			System.out.println("UserId="+variableService.getId()+" Password="+variableService.getPassword());
			mv.setViewName("pages/sales");}
		else {
			System.out.println("loginController/productAdd.....login method executed and redirected to login page again.......");
			mv.setViewName("pages/login");}
		return mv;
	}
	
}