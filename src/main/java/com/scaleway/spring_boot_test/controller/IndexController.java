package com.scaleway.spring_boot_test.controller;

import com.scaleway.spring_boot_test.model.Book;
import com.scaleway.spring_boot_test.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "index";      
    }
}
