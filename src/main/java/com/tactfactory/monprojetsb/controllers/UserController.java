package com.tactfactory.monprojetsb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.repositories.UserRepository;

@Controller
@RequestMapping(value="users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	 @RequestMapping(value = {"/index", "/"})
	 public String index(Model model) {
		 model.addAttribute("page", "User index");
		 model.addAttribute("items", repository.findAll());
	
		 return "user/index";
	 }
	
	 @GetMapping(value = {"/create"})
	 public String createGet(Model model) {
		 model.addAttribute("page", "User create");
		 return"user/create";
	 }

	 @PostMapping(value={"/create"})
	 public String createPost(@ModelAttribute User user) {
		 if (user != null) {
			 repository.save(user);
		 }
		 return "redirect:index";
	 }
}
