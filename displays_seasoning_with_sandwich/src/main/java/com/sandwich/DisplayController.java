package com.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {
    @GetMapping("/save")
    public String showList(){
        return "/sandwichCondiment";
    }
    @PostMapping("/save")
    public String save(@RequestParam("condiment") String condiment, Model model){
        model.addAttribute("listCondiment",condiment);
        return "/sandwichCondiment";
    }
}
