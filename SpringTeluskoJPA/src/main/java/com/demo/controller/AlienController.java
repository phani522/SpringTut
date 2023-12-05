package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.AlienRepo;
import com.demo.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo alienRepo;
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	
	@RequestMapping(value={"/addAlien","/updateAlien"})
	
	public String add(Alien alien) {
		alienRepo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv=new ModelAndView();
		Alien al= alienRepo.findById(aid).orElse(new Alien());
		//Alien al=alien.get();
		System.out.println("alien is "+al);
		List<Alien> alList=alienRepo.findByAidGreaterThan(aid);
		System.out.println("ALien greater than ID "+alienRepo.findByAidGreaterThan(aid) );
		System.out.println("Alien sorted by lang "+alienRepo.findByAidSorted(aid));

		mv.addObject("alien", al);
		mv.setViewName("showAlien.jsp");
		return mv;
	}
	
	
}
