package com.sda.catmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{ourName}")
    String hello(Model model, @PathVariable("ourName") String ourName) {    //localhost:8080/hello/Filip
        model.addAttribute("name", ourName);

        //hello.html
        return "hello";
    }

    @GetMapping
    String helloRequestParam(Model model, @RequestParam(value = "ourName", required = false) String ourName) {  //localhost:8080/hello?ourName=Filip

        if (ourName != null && !ourName.isEmpty()) {
            model.addAttribute("name", ourName);
        } else {
            model.addAttribute("name", "Anonymous");
        }


        //hello.html
        return "hello";
    }
}
