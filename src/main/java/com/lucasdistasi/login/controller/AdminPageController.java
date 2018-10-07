package com.lucasdistasi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
	
	@GetMapping(value="/adminpage")
	public String adminPage(Model model) {
		model.addAttribute("adminpage_current", true);
		return "admin";
	}

}
