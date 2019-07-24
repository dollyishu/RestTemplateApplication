package com.demo.resttemplate.model;

public class Book {
    private long isbn;
    private String authorname;
    private String bookname;
    private String isacademic;
    private int bookstock;

    public Book(long isbn, String authorname, String bookname, String isacademic, int bookstock) {
        this.isbn = isbn;
        this.authorname = authorname;
        this.bookname = bookname;
        this.isacademic = isacademic;
        this.bookstock = bookstock;
    }

    public Book() {

    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIsacademic() {
        return isacademic;
    }

    public void setIsacademic(String isacademic) {
        this.isacademic = isacademic;
    }

    public int getBookstock() {
        return bookstock;
    }

    public void setBookstock(int bookstock) {
        this.bookstock = bookstock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", authorname='" + authorname + '\'' +
                ", bookname='" + bookname + '\'' +
                ", isacademic='" + isacademic + '\'' +
                ", bookstock=" + bookstock +
                '}';
    }
}
