package com.example.LibraryManagementSystem.Services;


import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Models.Card;
import com.example.LibraryManagementSystem.Models.Student;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student) {

        // Student from the Postman is already the basic attributes set

        // Card should be auto generated when createStudent function is called
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student); // Foreign key attribute
        // Filling the value of the unidirectional part


        // Let's go to the student
        student.setCard(card);


        // If there was a unidirectional mapping : we had to save both of them
        // studentRepo.save () and cardRepo.save()
        // but we're super advanced and are using bidirectional mapping : child will automatically be save

        studentRepository.save(student);

        // by cascading effect, child will automatically be saved

        return "Student and Card added";
    }

    public String findNameByEmail(String email) {

        Student student = studentRepository.findByEmail(email);

        return student.getName();
    }

    public String updateMobileNo(Student newStudent) {


        // First we will try to fetch original Data
        Student originalStudent = studentRepository.findById(newStudent.getId()).get();

        // We will keep the other properties as it is : and only change the required parameters

        originalStudent.setMobileNo(newStudent.getMobileNo());

        // Always entity object is being saved
        studentRepository.save(originalStudent);

        return "Student has been updated successfully. ";

    }

}

/*
    1. Existing Functions with no definition.
    2. Existing function + with defining.
    3. New Function (manual custom SQL queries)
 */