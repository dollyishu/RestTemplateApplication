package com.demo.resttemplate.model;

public class Borrower {
    private long isbn;
    private String firstname;
    private String lastname;
    private String emailid;
    private int noofbooks;

    public Borrower(long isbn, String firstname, String lastname, String emailid, int noofbooks) {
        this.isbn = isbn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.noofbooks = noofbooks;
    }

    public Borrower() {
    }

    public long getIsbn(int i) {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getFirstname(String ishu) {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(String m) {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid(String s) {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getNoofbooks() {
        return noofbooks;
    }

    public void setNoofbooks(int noofbooks) {
        this.noofbooks = noofbooks;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "isbn=" + isbn +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailid='" + emailid + '\'' +
                ", noofbooks=" + noofbooks +
                '}';
    }
}
