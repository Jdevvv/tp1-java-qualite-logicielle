package com.tactfactory.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		return"product/create";  
	}
	
	@PostMapping(value = {"/create"})
	public String createPost(@ModelAttribute("product") Product product) {
		Product newProduct = repository.save(product);
		
		return "redirect:product/details/" + String.valueOf(newProduct.getId());  
	}
	
	@GetMapping("/details/{id}")
    public String details(@ModelAttribute Product product, Model model) {
		model.addAttribute("page", "Product details");
        model.addAttribute("item", repository.findById(product.getId()).get());
        
        return "product/details";
    }
	
	@DeleteMapping("/delete")
	public String delete(@ModelAttribute Product product, Model model) {
		model.addAttribute("page", "Product delete");
        repository.deleteById(product.getId());
        
        return "product/delete";
	}
}
