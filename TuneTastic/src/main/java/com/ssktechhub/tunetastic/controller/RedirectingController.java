package com.ssktechhub.tunetastic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RedirectingController {
	
	@GetMapping("/login")
	public String redirectLogin() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String redirectRegistration() {
		return "registration";
	}
	
	@GetMapping("/newsong")
	public String redirectNewSong() {
		return "newsong";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
