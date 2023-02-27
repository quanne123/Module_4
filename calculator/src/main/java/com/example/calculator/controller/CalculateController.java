package com.example.calculator.controller;

import com.example.calculator.service.CalculateService;
import com.example.calculator.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculateController {
    @Autowired
    ICalculateService calculateService = new CalculateService();
    @GetMapping("")
    public double calculate(@RequestParam(required = false) Double numberOne, Double numberTwo, int sum, Model model){
        if (numberOne == null & numberTwo == null){
            return "calculator";
        }
        String msg = "";
        String calculatorMsg = "";
        double result = calculateService.calculate(sum,numberOne,numberTwo);
        switch (sum){
            case "Addition" :
            calculatorMsg = "Addition";
            break;
            case "Subtraction(-)":
                calculatorMsg = "Subtraction";
                break;
            case "Multiplication(*)":
                calculatorMsg = "Multiplication";
                break;
            case "Division(/)":
                if (result != 0) {
                    calculatorMsg = "Division";
                } else {
                    msg = "Hãy nhập số khác 0";
                }
                break;
        }
        model.addAttribute(numberOne,numberTwo);
        model.addAttribute(numberTwo,numberTwo);
        model.addAttribute(result,result);
        model.addAttribute(msg,msg);
        model.addAttribute(calculatorMsg,calculatorMsg);
        return result;
        }
    }
}
