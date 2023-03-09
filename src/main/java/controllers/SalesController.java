package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SalesController extends MultiActionController{

	public ModelAndView sales(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("pages/sales");
		return mv;
	}
}