package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import service.CategoryService;
import service.LoginService;

public class CategoryController extends MultiActionController {

	ApplicationContext applicationContext;
	ModelAndView mv;
	
//	redirecting CategoryAdd page
	public ModelAndView redirectCategoryAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		mv = new ModelAndView();
		mv.setViewName("pages/categoryAdd");
		return mv;
	}
	public ModelAndView categoryAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("categoryController/controllerAdd............started.......");
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		mv = new ModelAndView();
		System.out.println("in caegory add controler.................");
		
		// calling categoryAddServ method for add category in DB
		if (((CategoryService) applicationContext.getBean("categoryService")).categoryAddServ(req, res) == true) {
			System.out.println(
					"CategoryController/categoryAdd.....categoryAdd method executed and redirected to categoryAdd page.......");
			mv.setViewName("pages/categoryAdd");
		} else {
			System.out.println("CategoryController/categoryAdd.....categoryAdd/errorMsg set.......");
			String errorMsg = "fill required fields!!";
			mv.addObject("errorMsg", errorMsg);
		}
		return mv;
	}

	public ModelAndView categoryList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("resources/dependancy.xml");
		System.out.println("In CategoryController/categoryList..........");
		mv = new ModelAndView();

		// calling categoryListServ method for retrieve category list
		List categoryList = ((CategoryService) applicationContext.getBean("categoryService")).categoryListServ(req,res);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("pages/categoryList");
		return mv;
	}

}
