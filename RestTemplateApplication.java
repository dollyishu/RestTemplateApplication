package com.demo.resttemplate;

import com.demo.resttemplate.model.Book;
import com.demo.resttemplate.model.Borrower;
import com.demo.resttemplate.service.BookRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestTemplateApplication {
    private Book book;
    private Borrower borrower;
    public static void main(String[] args) {

        BookRestService bookRestService = new BookRestService();
        //bookRestService.createBook();
        bookRestService.getBooks();
        bookRestService.getBook();
        bookRestService.deleteBook();
        //bookRestService.createBorrower();
        bookRestService.getBorrowers();
        bookRestService.getBorrower();
        bookRestService.deleteBorrower();
    }
}
