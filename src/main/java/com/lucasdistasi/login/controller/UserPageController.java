package com.lucasdistasi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

	@GetMapping(value="/userpage")
	public String userPage(Model model) {
		model.addAttribute("userpage_current", true);
		return "user";
	}
	
}
