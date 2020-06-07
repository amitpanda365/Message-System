package com.ics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ics.services.MessageService;
import com.ics.utils.MessageHelper;

@Controller
public class MessageController {

	@Autowired
	MessageService messageService;

	@RequestMapping("/sendMessage")
	public String showMessage(Model model) {

		MessageHelper messageHelper = new MessageHelper();
		model.addAttribute("messageHelper", messageHelper);
		return "compose";
	}

	@PostMapping("/sendMessage")
	@ResponseBody
	public String createUser(@ModelAttribute MessageHelper messageHelper) {

		messageService.sendMessage(messageHelper);

		return "message sent successfully";
	}

}
