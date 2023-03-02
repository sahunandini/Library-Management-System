package com.example.LibraryManagementSystem.Services;


import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor (Author author) {

        authorRepository.save(author);

        return "Author added successfully";
    }
}
