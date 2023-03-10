package com.example.LibraryManagementSystem.Controllers;


import com.example.LibraryManagementSystem.DTOs.AuthorEntryDto;
import com.example.LibraryManagementSystem.DTOs.AuthorResponseDto;
import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    //   / is optional if you want to write you can
    // otherwise not required

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor (@RequestBody AuthorEntryDto authorEntryDto) {

        return authorService.createAuthor(authorEntryDto);
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId){
        return authorService.getAuthor(authorId);
    }


}
