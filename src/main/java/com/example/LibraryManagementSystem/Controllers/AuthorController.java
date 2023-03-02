package com.example.LibraryManagementSystem.Controllers;


import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    //   / is optional if you want to write you can
    // otherwise not required

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor (@RequestBody Author author) {

        return authorService.createAuthor(author);

    }

}
