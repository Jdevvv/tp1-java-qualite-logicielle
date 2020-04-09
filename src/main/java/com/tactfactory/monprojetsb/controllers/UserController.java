package com.tactfactory.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		 return "user/create";
	 }

	 @PostMapping(value = {"/create"})
	 public String createPost(@ModelAttribute User user) {
		 if (user != null) {
			 repository.save(user);
		 }
		 return "redirect:index";
	 }
	 
	 @GetMapping("/details/{id}")
	    public String details(@ModelAttribute User user, Model model) {
			model.addAttribute("page", "User details");
	        model.addAttribute("item", repository.findById(user.getId()).get());
	        
	        return "user/details";
	    }
	 
	 @PostMapping("/delete")
		public String delete(Long id) {
			User user = repository.getOne(id);
			repository.delete(user);
			
			return "redirect:index";
		}
}
