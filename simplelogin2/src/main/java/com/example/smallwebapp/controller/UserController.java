package com.example.smallwebapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.smallwebapp.entity.User;
import com.example.smallwebapp.repository.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	private UserRepo  repo;
	
	
	@GetMapping("/")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	@PostMapping("/userLogin")
	public String loginuser(@ModelAttribute("user") User user) {
//		System.out.println(user.getUserId());
//		System.out.println(user.getPassword());
		String userId =user.getUserId();
		Optional <User> userdata =repo.findById(userId);
		
		if(user.getPassword().equals(userdata.get().getPassword())) {
			return "home";
		}
		else {
			return "error";
		}
		
	}

}
