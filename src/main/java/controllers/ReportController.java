package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReportController extends MultiActionController{

	public ModelAndView reportPurchase(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/reportPurchase");
		return mv;
	}
	public ModelAndView reportSales(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/reportSales");
		return mv;
	}

}