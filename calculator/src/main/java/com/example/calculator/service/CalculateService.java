package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {

    @Override
    public double calculate(double sum, double numberOne, double numberTwo) {
        String action = null;
        String msg = "";
        switch (action) {
            case "Addition":
                sum = numberOne + numberTwo;
                break;
            case "Subtraction":
                sum = numberOne - numberTwo;
                break;
            case "Mutiplication":
                sum = numberOne * numberTwo;
                break;
            case "Division":
                if(numberTwo != 0) {
                    sum = numberOne / numberTwo;
                }else {
                     msg = "Error";
                }
                break;
        }
        return sum;
    }
}
