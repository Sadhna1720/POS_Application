package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SupplierController extends MultiActionController{

	public ModelAndView supplierAdd(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/supplierAdd");
		return mv;
	}
	public ModelAndView supplierList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/supplierList");
		return mv;
	}
}
