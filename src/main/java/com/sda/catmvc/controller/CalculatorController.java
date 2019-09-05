package com.sda.catmvc.controller;

import com.sda.catmvc.model.Numbers;
import com.sda.catmvc.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // wyświetlanie widoku
    @GetMapping
    String calculatorView(){
        return "calculator";
    }

    @PostMapping("/add")
    String calculateResultAdd(Model model, Numbers numbers) {
        double result = calculatorService.add(numbers.getFirst(), numbers.getSecond());
        model.addAttribute("result", result);

        // result.html
        return "result";
    }

    @PostMapping("/sub")
    String calculateResultSub(Model model, Numbers numbers) {
        double result = calculatorService.sub(numbers.getFirst(), numbers.getSecond());
        model.addAttribute("result", result);

        // result.html
        return "result";
    }

    @PostMapping("/mul")
    String calculateResultMul(Model model, Numbers numbers) {
        double result = calculatorService.mul(numbers.getFirst(), numbers.getSecond());
        model.addAttribute("result", result);

        // result.html
        return "result";
    }

    @PostMapping("/div")
    String calculateResultDiv(Model model, Numbers numbers) {

        double result = calculatorService.div(numbers.getFirst(), numbers.getSecond());
        model.addAttribute("result", result);

        // result.html
        return "result";
    }

}
