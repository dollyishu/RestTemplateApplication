package com.demo.resttemplate.service;

import com.demo.resttemplate.model.Book;
import com.demo.resttemplate.model.Borrower;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

public class BookRestService {
    private RestTemplate restTemplate;

    public BookRestService() {
        this.restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);

    }

    public void createBook(Book book) {
        String url = "http://localhost:8080/book";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        /*Book book = new Book();
        book.setIsbn(564657880);
        book.setAuthorname("ishrath");
        book.setBookname("java");
        book.setIsacademic("academic");
        book.setBookstock(10);*/

        HttpEntity<Book> request = new HttpEntity<>(book, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.postForEntity(url, request, Book.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void getBooks() {
        String url = "http://localhost:8080/books";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void getBook() {
        String url = "http://localhost:8080/book/6564687236";
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void deleteBook() {
        String url = "http://localhost:8080/book/564657880";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity(url, String.class);
        System.out.println("the book has deleted successfully");
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void createBorrower(Borrower borrower, long isbn, String str2, String str3, String str4, int noofbooks) {
        String url = "http://localhost:8080/borrowers";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);
        borrower.setIsbn(isbn);
        borrower.setFirstname(str2);
        borrower.setLastname(str3);
        borrower.setEmailid(str4);
        borrower.setNoofbooks(noofbooks);
        HttpEntity<Borrower> request = new HttpEntity<>(borrower, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Borrower> response = restTemplate.postForEntity(url, request, Borrower.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void getBorrowers() {
        String url = "http://localhost:8080/borrowers";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void getBorrower() {
        String url = "http://localhost:8080/borrower/6364565772";
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Borrower> response = restTemplate.getForEntity(url, Borrower.class);
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }

    public void deleteBorrower() {
        String url = "http://localhost:8080/borrower/636458582";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity(url, String.class);
        System.out.println("borrower details are deleted");
        System.out.println("status code is" + response.getStatusCode());
        System.out.println("response body is" + response.getBody());
        System.out.println("response header is" + response.getHeaders());
    }
}