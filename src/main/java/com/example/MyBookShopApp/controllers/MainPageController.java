package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    @GetMapping("/main")
    public String mainPage(){
        System.out.println("1");
        return "index";
    }

    @GetMapping("/genres")
    public String genres(){
        System.out.println("2");
        return "../books/genres";
    }

    @GetMapping("/authors")
    public String authors(){
        return "../authors/index";
    }
}
