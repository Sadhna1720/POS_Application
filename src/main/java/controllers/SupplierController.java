package controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import service.SupplierService;
import service.VariableService;

public class SupplierController extends MultiActionController{

	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ModelAndView mv;
	String msg;
	
//	redirecting SupplierAdd page
	public ModelAndView redirectSupplierAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		mv = new ModelAndView();
		mv.setViewName("pages/supplierAdd");
		return mv;
	}
	
	public ModelAndView supplierAdd(HttpServletRequest req, HttpServletResponse res) throws Exception{

		System.out.println("SupplierController/supplierAdd.....start.......");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		
		// calling supplierAddServ method for add supplier details in DB
		if(((SupplierService) applicationContext.getBean("supplierService")).supplierAddServ(req, res)==false) {
			msg="Fill all required fields!";
			mv.addObject("msg", msg);
			System.out.println("SupplierController/supplierAdd.....errorMsg set.....");
		}else {
			mv.setViewName("pages/supplierAdd");
			System.out.println("SupplierController/supplierAdd.....page(supplierAdd) set.....");
		}
		System.out.println("ProductController/productAdd.....method end here.......");		
		
		return mv;
	}
	public ModelAndView supplierList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		
		// calling supplierListServ method for retrieve supplierList
		List supplierList=((SupplierService) applicationContext.getBean("supplierService")).supplierListServ(req, res);
		mv.addObject("supplierList", supplierList);
		mv.setViewName("pages/supplierList");
		return mv;
	}
}
