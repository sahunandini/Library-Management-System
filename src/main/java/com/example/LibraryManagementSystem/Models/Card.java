package com.example.LibraryManagementSystem.Models;


import com.example.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    // Plan is to save this card in Db.
    // Before saving I have to set its attributes : Rule 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // It's auto generated

    @CreationTimestamp // Auto timestamp the time when an entry is created
    Date createdOn; // It's auto generated

    @UpdateTimestamp // Set times when an entry is updated
    Date updatedOn; // It's auto generated

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus; // set this attribute


    @OneToOne
    @JoinColumn
    private Student student; // The variable is used in the parent class
    // while doing the bidirectional mapping


    // Card is parent with respect to Book
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();


    // Connecting the card class to the transaction
    // Bidireectional Mapping
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();



    public Card() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
