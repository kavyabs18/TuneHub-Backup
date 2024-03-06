package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		// Email taken from registration form
		String email = user.getEmail();

		// Checking if email as entered in registration from is present in DB or not
		boolean status = userService.emailExists(email);

		if (!status) {
			userService.addUser(user);
			System.out.println("User Added");

		} else {
			System.out.println("User already Exists");
		}
		return "login";
	}
	
	@PostMapping("/validate")
	public String validate( @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {
		if(userService.validateUser(email, password) == true){
			String role = userService.getRole(email);
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminhome";				
			}
			else {
				User user = userService.getUser(email);
				boolean userstatus = user.isIspremium();
				
				//logic
				List<Song> fetchAllSongs = songService.fetchAllSongs();
				model.addAttribute("Songs", fetchAllSongs);
				
				model.addAttribute("ispremium", userstatus);
				return "customerhome";
			}
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
