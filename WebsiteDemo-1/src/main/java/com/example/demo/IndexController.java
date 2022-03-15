package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
	@RequestMapping("home")
	public ModelAndView home(User user)
	{
		System.out.println("test");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo",user);
		mav.setViewName("IndexA.jsp");
		return mav;
	}
	@RequestMapping("/addCustomer")
	public ModelAndView add(User user)
	{
		System.out.println("test");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo",user);
		mav.setViewName("display.jsp");
		return mav;
	}
}
