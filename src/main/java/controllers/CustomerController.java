package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CustomerController extends MultiActionController{

	public ModelAndView customer(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/customer");
		return mv;
	}
}
