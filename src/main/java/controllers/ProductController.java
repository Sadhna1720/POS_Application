package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ProductController extends MultiActionController{

	public ModelAndView productAdd(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/productAdd");
		return mv;
	}
	public ModelAndView productList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/productList");
		return mv;
	}
}