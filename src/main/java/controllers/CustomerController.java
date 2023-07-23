package controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.CustomerService;
import service.VariableService;

public class CustomerController extends MultiActionController{

	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ModelAndView mv;
	String msg;
	
//	redirecting CustomerAdd page
	public ModelAndView redirectCustomerAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		mv = new ModelAndView();
		mv.setViewName("pages/customerAdd");
		return mv;
	}
	
	public ModelAndView customerAdd(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("customerController/customerrAdd.....start.......");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		
		// calling customerAddServ method for add customer data in DB
		if(((CustomerService) applicationContext.getBean("customerService")).customerAddServ(req, res)==false) {
			msg="Fill all required fields!";
			mv.addObject("msg", msg);
			System.out.println("SupplierController/supplierAdd.....errorMsg set.....");
		}else {
			mv.setViewName("pages/customerAdd");
			System.out.println("customerController/customerAdd.....page(customerAdd) set.....");
		}
		System.out.println("customerController/customerAdd.....method end here.......");		
		
		return mv;
	}
	
	
	public ModelAndView customerList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		
		// calling customerListServ method for retrieve customer list
		List customerList=((CustomerService) applicationContext.getBean("customerService")).customerListServ(req, res);
		mv.addObject("customerList", customerList);
		mv.setViewName("pages/customerList");
		return mv;
	}
}
