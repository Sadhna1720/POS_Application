package controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.ReportService;
import service.VariableService;

public class ReportController extends MultiActionController{

	ApplicationContext applicationContext;
	VariableService variableService;
	PreparedStatement preparedStatement;
	ModelAndView mv;
	String msg;
	
	public ModelAndView reportPurchase(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		
		// calling ReportPurchaseServ method for retrieve list productList from DB for purchase report
		List productList=((ReportService) applicationContext.getBean("reportService")).ReportPurchaseServ(req, res);
		mv.addObject("productList", productList);
		mv.setViewName("pages/reportPurchase");
		return mv;
	}
	public ModelAndView reportSales(HttpServletRequest req, HttpServletResponse res) throws Exception{
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		
		// calling ReportSalesServ method for retrieve list productList from DB for sales report
		List productList=((ReportService) applicationContext.getBean("reportService")).ReportSalesServ(req, res);
    	mv.addObject("productList", productList);
		mv.setViewName("pages/reportSales");
		return mv;
	}
	
	public ModelAndView salesReportExport(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("Export method in controller started ........");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		((ReportService)applicationContext.getBean("reportService")).export(req, res, "salesreport");		
		return mv;
	}
	public ModelAndView purchaseReportExport(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("Export method in controller started ........");
		applicationContext= new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv=new ModelAndView();
		((ReportService)applicationContext.getBean("reportService")).export(req, res, "purchasereport");		
		return mv;
	}
	
	
}

