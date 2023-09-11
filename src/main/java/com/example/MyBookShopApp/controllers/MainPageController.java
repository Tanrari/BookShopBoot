package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.services.AuthorService;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;
    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
//
//    @GetMapping("/genres")
//    public String genres(){
//        System.out.println("2");
//        return "../books/genres";
//    }
//
//    @GetMapping("/authors")
//    public String authors(Model model){
////        System.out.println(authorService.getAuthorsData().toString());
//     model.addAttribute("authorData", authorService.getAuthorsData());
////        System.out.println(authorService.getAuthorsData().entrySet());
//       return "../authors/index";

//    }

    @ModelAttribute("recomendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";

    }

}
