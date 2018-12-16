package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(){
		System.out.println("Entrei no index");
		return "index";
	}
	
	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model){
		System.out.println("Entrei no hello");
		model.addAttribute("name", name);
		return "hello";
	}
	
}
