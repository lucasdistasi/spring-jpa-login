package com.lucasdistasi.login.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model, Principal principal,
			RedirectAttributes ra) {
		if (principal != null) {
			return "redirect:/home";
		}

		if (error != null) {
			ra.addFlashAttribute("login_error", true);
			return "redirect:/login";
		}

		return "login";
	}

}
