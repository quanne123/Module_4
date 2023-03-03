package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.service.IProductService;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
@Autowired
private IProductService productService;

@GetMapping("")
    public String index(Model model, @RequestParam(name = "search", required = false) String search){

    model.addAttribute("products",productService.findAll(search));
    return "/index";
}
@GetMapping("/create")
    public String create(Model model){
    model.addAttribute("product",new Product());
    return "/create";
}
@PostMapping("/save")
    public String save(Product product){
    productService.save(product);
    return "redirect:/product";
}
@GetMapping("{id}/edit")
    public String edit(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "/edit";
}
@PostMapping("/update")
    public String update(Product product){
    productService.update(product.getId(), product);
    return "redirect:/product";
}
@GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "/delete";
}
@PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
    productService.remove(product.getId());
    redirectAttributes.addFlashAttribute("success","remove successfully");
     return "redirect:/product";
}
@GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "/view";
}
}
