package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {

    @Override
    public double calculate( double numberOne, double numberTwo,String calculation) {
        String msg = "";
        double result = 0;
        switch (calculation) {
            case "Addition":
                result = numberOne + numberTwo;
                break;
            case "Subtraction":
                result = numberOne - numberTwo;
                break;
            case "Mutiplication":
                result = numberOne * numberTwo;
                break;
            case "Division":
                if(numberTwo != 0) {
                    result = numberOne / numberTwo;
                }else {
                     msg = "Error";
                }
                break;
        }
        return result;
    }
}
