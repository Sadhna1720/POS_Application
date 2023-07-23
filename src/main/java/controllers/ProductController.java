package controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.CategoryService;
import service.ProductService;
import service.VariableService;

public class ProductController extends MultiActionController{
	
	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ModelAndView mv;
	String msg;

//	redirecting ProductAdd page
	public ModelAndView redirectProductAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		List categoryList=((CategoryService)applicationContext.getBean("categoryService")).categoryListServ(req, res);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("pages/productAdd");
		return mv;
	}
	
	public ModelAndView productAdd(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("ProductController/productAdd.....start.......");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		
		// calling productAddServ method for add product details in DB
		if(((ProductService) applicationContext.getBean("productService")).productAddServ(req, res)==false) {
			msg="Fill all required fields!";
			mv.addObject("msg", msg);
			System.out.println("ProductController/productAdd.....errorMsg set.....");
		}else {
			mv.setViewName("pages/productAdd");
			System.out.println("ProductController/productAdd.....page9productAdd) set.....");
		}
		System.out.println("ProductController/productAdd.....method end here.......");
		return mv;
	}
	
	public ModelAndView productList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		
		// calling productListServ method for retrieve product details from DB
		List productList=((ProductService) applicationContext.getBean("productService")).productListServ(req, res);
		mv.addObject("productList", productList);
		mv.setViewName("pages/productList");
		return mv;
	}
}