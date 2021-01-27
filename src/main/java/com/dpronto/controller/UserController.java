package com.dpronto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpronto.domain.Login;
import com.dpronto.dto.RequestBean;
import com.dpronto.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRep;

	@RequestMapping(value = "/doReg")
	
	public String doReg(ModelMap model) {
		
		model.addAttribute("user", new Login());
		
		return "user";
	}
	
	@PostMapping(value = "/createUser")
	public String createUser(@ModelAttribute  Login login,ModelMap model) {
		
		Login save = userRep.save(login);	
		if(save!=null) {
			model.addAttribute("msg", "save used");
		}
		return "user";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		model.addAttribute("login", new RequestBean());
		
		return "login";
		
	}
	
	@RequestMapping(value = "/dologin" ,method = RequestMethod.POST)
	public String doLogin(@ModelAttribute RequestBean requestBean, ModelMap  model) {
		
		Login findByUsernameandPassword = userRep.findByUsernameAndPassword(requestBean.getUsername(),requestBean.getPassword());
		
		if(findByUsernameandPassword!=null) {
			model.addAttribute("msg", "User login successfully");
			return "welcome";
		}else {
			model.addAttribute("msg", "Invalid username and Password");
			return "login";
		}
		
	}
}
