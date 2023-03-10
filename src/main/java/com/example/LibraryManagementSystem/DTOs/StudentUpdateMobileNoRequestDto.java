package com.example.LibraryManagementSystem.DTOs;


public class StudentUpdateMobileNoRequestDto {


    private int id;

    private String mobileNo;

    // Dto's depend on the API's being called...add
    // atributes as required.


    public StudentUpdateMobileNoRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


}