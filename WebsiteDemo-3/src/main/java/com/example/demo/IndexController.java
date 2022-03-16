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
			mav.addObject("UserInfo",user);
			mav.setViewName("index.jsp");
			return mav;
		}
		@RequestMapping("/addCustomer")
		public ModelAndView addCustomer(User user)
		{
			userDAO.save(user);
			System.out.println("Test");
			ModelAndView mav = new ModelAndView();
			mav.addObject("UserInfo",user);
			mav.setViewName("display.jsp");
			return mav;
		}
		@RequestMapping("/showCustomer")
		public ModelAndView showCustomer(User user)
		{
		    user= userDAO.findById(user.getMobileNo()).orElse(new User());
			ModelAndView mav = new ModelAndView();
			mav.addObject("UserInfo",user);
			mav.setViewName("show.jsp");
			return mav;
		}
		/*public String index(String name, HttpSession session)
		{
			System.out.println("Test");
			session.setAttribute("Contact",name);
			return "index.jsp";
		}*/
}
