package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    String showForm(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }
    @GetMapping("product/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("product/update")
    public String updateProduct(Product product,RedirectAttributes redirect) {
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/product/"+product.getId();
    }
    @GetMapping("product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("product/save")
    public String createCustomer(@ModelAttribute("product") Product product, Model model, RedirectAttributes redirect) {
        productService.add(product);
        model.addAttribute("products", productService.findAll());
        redirect.addFlashAttribute("success", "Add product successfully!");
        return "redirect:/product/create";
    }
    @GetMapping("product/delete/{id}")
    public String deleteForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("product/deleteReal")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Delete product successfully!");
        return "redirect:/product/delete/"+(productService.findAll().size()+2);
    }
    @GetMapping("products/search/")
    public ModelAndView searchForm(@PathVariable String search,RedirectAttributes redirect) {
        ModelAndView modelAndView = new ModelAndView("index");
        ArrayList<Product> result = productService.findByName(search);
        modelAndView.addObject("products", result);
        if(result.size()==0){
            redirect.addFlashAttribute("success", "Not found any product!");
        }
        return modelAndView;
    }
}