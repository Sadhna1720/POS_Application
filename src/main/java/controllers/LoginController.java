package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import service.LoginService;

public class LoginController extends MultiActionController {

	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("loginController/login.....start.......");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		ModelAndView mv = new ModelAndView();
		
		System.out.println("loginController/login.....goes to call login method.......");
		
		// calling loginServ method for login 
		if (((LoginService) applicationContext.getBean("loginService")).loginServ(req, res) == true) {
			System.out.println("loginController/login.....login method executed and redirected to sales page.......");
			mv=((SalesController) applicationContext.getBean("salesController")).sales(req, res);
			//mv.setViewName("pages/sales");
		} else {
			System.out.println(
					"loginController/login.....login method executed and redirected to login page again.......");
			String errorMsg="Either user-Id or password is incorrect";
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("pages/login");
		}
		return mv;
	}

}