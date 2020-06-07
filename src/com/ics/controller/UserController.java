package com.ics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ics.dao.UserDAO;
import com.ics.domainObjects.EnterpriseUser;
import com.ics.services.MessageService;
import com.ics.services.UserService;

@Controller
@RequestMapping("/systems")
public class UserController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserService userService;

	@Autowired
	MessageService messageService;

	@RequestMapping(value = { "/showUsers" })
	public String showUser(Model model) {
		List<EnterpriseUser> users = userDAO.getAllUsers();
		model.addAttribute("users", users);
		return "allUsers";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam String userID) {
		System.out.println("deleteUser starts in UserController");
		userDAO.deleteUser(userID);
		System.out.println("deleteUser ends in UserController");
		return "redirect:/showUsers";
	}

	@RequestMapping("/createUser")
	public String createUser(Model model) {
		EnterpriseUser user = new EnterpriseUser();
		model.addAttribute("user", user);
		return "userRegistrationForm";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute EnterpriseUser user) {

		userService.createUser(user);
		messageService.sendWelcomeMessage(user.getUserID());

		return "redirect:/showUsers";
	}

}
