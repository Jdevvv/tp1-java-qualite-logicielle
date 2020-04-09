package com.tactfactory.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.repositories.ProductRepository;


@Controller
@RequestMapping(value="products")
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping(value = {"/index", "/"})
	 public String index(Model model) {
		 model.addAttribute("page", "Product index");
		 model.addAttribute("items", repository.findAll());
	
		 return "product/index";
	 }
	
	@GetMapping(value = {"/create"})
	public String createGet(Model model) {
		model.addAttribute("page", "Product create");
		return "product/create";  
	}
	
	@PostMapping(value = {"/create"})
	public String createPost(@ModelAttribute Product product) {
		 if (product != null) {
	            repository.save(product);
	        }
        return "redirect:index";  
	}
	
	@GetMapping("/details/{id}")
    public String details(@ModelAttribute Product product, Model model) {
		model.addAttribute("page", "Product details");
        model.addAttribute("item", repository.findById(product.getId()).get());
        
        return "product/details";
    }
	
	@PostMapping("/delete")
	public String delete(Long id) {
		Product product = repository.getOne(id);
		repository.delete(product);
		
		return "redirect:index";
	}
}
