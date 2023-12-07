package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {

	
@RequestMapping("/home")
/*public String home(HttpServletRequest req) {
	HttpSession httpSession=req.getSession();
	String st=req.getParameter("name");
	httpSession.setAttribute("name", st);
	return "home";
}*/
/*
public ModelAndView home(@RequestParam("name") String myName) {
	ModelAndView modelAndView= new ModelAndView();
	modelAndView.addObject("name", myName);
	modelAndView.setViewName("home");
	return modelAndView;
}
*/

public ModelAndView home(Alien al) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("obj", al);
	mv.setViewName("home");
	System.out.println("controller called");
	return mv;
}


}
