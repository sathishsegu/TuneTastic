package com.ssktechhub.tunetastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssktechhub.tunetastic.entity.Song;
import com.ssktechhub.tunetastic.entity.User;
import com.ssktechhub.tunetastic.service.SongService;
import com.ssktechhub.tunetastic.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;

	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		String result = userService.addUser(user);
		if(result.equals("userexists")) {
			return "registration";
		}else {
			return "login";
		}
	}

	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {

		if (userService.validateUser(email, password) == true) {
			
			String role = userService.getRole(email);
			
			session.setAttribute("email",email);

			if (role.equals("admin")) {
				return "adminhome";
			} else {
				
				User user = userService.getUser(email);
				boolean userStatus = user.isIspremium();
				List<Song> songList = songService.fetAllSongs();
				model.addAttribute("songs", songList);
				model.addAttribute("ispremium", userStatus);
				return "customerhome";
			}
		} else {
			return "login";
		}
	}
	
	
		
}

//here when the controller reaches to (/register) then the method will render the home.html page because we are returning to that page. 
//We can use @ModelAttribute or @RequestParam in case of RequestParam we should mention all the attributes individually.

//@Autowired UserService userService in this line we are doing field injection using that annotation.
//By using that field we are accessing the method present in that class or interface.

/*
 * @PostMapping("/register") public String addUsers(@ModelAttribute User user) {
 * 
 * String email = user.getEmail(); boolean status =
 * userService.emailExists(email);
 * 
 * if(status == false) { return userService.addUser(user); }else { return
 * "user email already exists"; } }
 */