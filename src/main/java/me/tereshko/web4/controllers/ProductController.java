package me.tereshko.web4.controllers;

import lombok.RequiredArgsConstructor;
import me.tereshko.web4.model.Product;
import me.tereshko.web4.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/remove/{id}")
    public String removeByID(@PathVariable Long id) {
        productService.removeById(id);
        return "redirect:/products/";
    }

    @GetMapping("/add")
    public String add(@RequestParam Long id, @RequestParam String name, @RequestParam double price) {
        Product product = new Product(id, name, price);
        productService.add(product);
        return "redirect:/products/";
    }


}
