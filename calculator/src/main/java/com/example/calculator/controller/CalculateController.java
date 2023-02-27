package com.example.calculator.controller;

import com.example.calculator.service.CalculateService;
import com.example.calculator.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    ICalculateService calculateService;

    @GetMapping("/calculator")
    public String showFormCalculator(){
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double numberOne,@RequestParam double numberTwo,@RequestParam String calculation, Model model){
        model.addAttribute("result", calculateService.calculate(numberOne,numberTwo,calculation));
        return "/calculator";
    }
}
