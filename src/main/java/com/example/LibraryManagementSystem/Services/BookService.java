package com.example.LibraryManagementSystem.Services;


import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.Models.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) {

        // I want to get the Author Entity ??
        int authorId = book.getAuthor().getId();

        // Now I will be fetching the Author Entity

        Author author = authorRepository.findById(authorId).get();


        // Basic attributes are already set from Postman

        // Setting the foreign key attr in the child class :
        book.setAuthor(author);


        // We need to update the listOfBooks written in the parent class

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);

        // Now the book is to be saved, but also author is also to be saved

        // Why do we need to again save (updating) the author ?? bcz
        // because the author Entity has been updated....we need to resave/update it

        authorRepository.save(author);

        // .save function works both as save function and as update function


        //bookRepo.save is not required : bcz it will be autocalled by cascading effect

        return "Book added successfully";


    }
}
