package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	UserDAO userDAO;
	@RequestMapping("home")
	public ModelAndView index(User user)
	{
		
		System.out.println("Test");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo",user);
		mav.setViewName("indexA.jsp");
		return mav;
	}
	@RequestMapping("/addCustomer")
	public ModelAndView add(User user)
	{
		userDAO.save(user);
		System.out.println("Test");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo",user);
		mav.setViewName("display.jsp");
		return mav;
}
	@RequestMapping("/showCustomer")
	public ModelAndView show(User user)
	{
		ModelAndView mav = new ModelAndView();
		user = userDAO.findById(user.getDoorNo()).orElse(new User());
		mav.addObject("userInfo", user);
		mav.setViewName("show.jsp");
		return mav;
	}
	
	
	
	
	
	
}
