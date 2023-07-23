package controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.InventoryService;
import service.VariableService;

public class InventoryController extends MultiActionController{
	
	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ModelAndView mv;
	String msg;

	public ModelAndView inventory(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("inventoryController/inventory.....start.......");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		
		// calling inventory method for getting inventory list from DB
		List productList =((InventoryService) applicationContext.getBean("inventoryService")).inventory(req, res);
		
		mv.addObject("productList", productList);
		mv.setViewName("pages/inventory");
		System.out.println("InventoryController/inventory.....page (inventory) set.....");
		
		System.out.println("InventoryController/inventory.....method end here.......");
		return mv;
	}
}