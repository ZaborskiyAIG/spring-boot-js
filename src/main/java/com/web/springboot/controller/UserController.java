package com.web.springboot.controller;

import com.web.springboot.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping
public class UserController {

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/admin")
	public String getUsers(Model model){
		return "admin_page";
	}

	@GetMapping("/user")
	public String getUser(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("firstName", auth.getName());
		return "user_page";
	}

	@PostMapping(value = "/admin/add")
	public String addUser(@ModelAttribute User user, @RequestParam(value = "role") Long[] rolesId){
		return "redirect:/admin";
	}

	@PostMapping(value = "/admin/update")
	public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role", required = false) Long[] rolesId){
		return "redirect:/admin";
	}
}