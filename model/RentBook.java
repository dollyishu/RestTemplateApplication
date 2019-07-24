package com.demo.resttemplate.model;

import com.demo.resttemplate.service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static org.eclipse.swt.SWT.PUSH;

public class RentBook extends Borrower{
    public RentBook() {

        Display display = Display.getDefault();
        final Shell shell = new Shell();
        //shell.setLayout(new GridLayout(1,false));
        shell.setSize(700, 700);
        shell.setText("Renting a book");


        final Label label1 = new Label(shell, SWT.NONE);
        label1.setText("Enter isbn");
        label1.setSize(150, 20);
        label1.setLocation(50, 50);

        Label label2 = new Label(shell, SWT.NONE);
        label2.setText("Enter first name");
        label2.setSize(150, 20);
        label2.setLocation(50, 100);

        Label label3 = new Label(shell, SWT.NONE);
        label3.setText("Enter last name");
        label3.setSize(150, 20);
        label3.setLocation(50, 150);

        Label label5 = new Label(shell, SWT.NONE);
        label5.setText("Enter email id");
        label5.setSize(150, 20);
        label5.setLocation(50, 200);

        Label label6 = new Label(shell, SWT.NONE);
        label6.setText("Enter no of books");
        label6.setSize(150, 20);
        label6.setLocation(50, 250);
        //new BookList();

        final Text text1 = new Text(shell, SWT.BORDER);
        text1.setText("");
        text1.setSize(150, 20);
        text1.setLocation(200, 50);
        text1.setTextLimit(13);
        text1.addVerifyListener(new VerifyListener() {
            public void verifyText(VerifyEvent event) {
                event.doit = false;
                char myChar = event.character;
                String text = ((Text) event.widget).getText();
                if (Character.isDigit(myChar))
                    event.doit = true;
                if (myChar == '\b') {
                    event.doit = true;
                }
                if (myChar == '-') {
                    event.doit = true;
                }
            }
        });

        final Text text2 = new Text(shell, SWT.BORDER);
        text2.setText("");
        text2.setSize(150, 20);
        text2.setLocation(200, 100);
        text2.setTextLimit(30);
        text2.addVerifyListener(new VerifyListener() {
            public void verifyText(VerifyEvent event) {
                event.doit = false;
                char myChar = event.character;
                String text = ((Text) event.widget).getText();
                if (Character.isLetter(myChar))
                    event.doit = true;
                if (myChar == '\b') {
                    event.doit = true;
                }
            }
        });

        final Text text3 = new Text(shell, SWT.BORDER);
        text3.setText("");
        text3.setSize(150, 20);
        text3.setLocation(200, 150);
        text3.setTextLimit(30);
        text3.addVerifyListener(new VerifyListener(){
            public void verifyText(VerifyEvent event) {
                event.doit = false;
                char myChar = event.character;
                String text = ((Text) event.widget).getText();
                if (Character.isLetter(myChar))
                    event.doit = true;
                if (myChar == '\b') {
                    event.doit = true;
                }
            }

        });

        final Text text4 = new Text(shell, SWT.BORDER);
        text4.setText("");
        text4.setSize(150, 20);
        text4.setLocation(200, 200);
        text4.setTextLimit(30);
        final Label label4 = new Label(shell, SWT.NONE);
        label4.setText("");
        label4.setSize(150, 20);
        label4.setLocation(200, 220);
        text4.addVerifyListener(new VerifyListener() {
            public void verifyText(VerifyEvent event) {
                boolean status = Email.email_Valid(text4.getText());
                if(status) {
                    label4.setText("");
                } else{
                    label4.setText("Please enter a valid email");
                }
            }
        });

        final Text text5 = new Text(shell, SWT.BORDER);
        text5.setText("");
        text5.setSize(150, 20);
        text5.setLocation(200, 250);
        text5.setTextLimit(20);
        text5.addVerifyListener(new VerifyListener(){
            public void verifyText(VerifyEvent event) {
                event.doit = false;
                char myChar = event.character;
                String text = ((Text) event.widget).getText();
                if (Character.isDigit(myChar))
                    event.doit = true;
                if (myChar == '\b') {
                    event.doit = true;
                }
            }

        });


        Button button = new Button(shell, PUSH);
        button.setText("Rent book");
        button.setBounds(100, 400, 100, 30);

        Button button1 = new Button(shell, PUSH);
        button1.setText("Back to main menu");
        button1.setBounds(250, 400, 140, 30);

        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent selectionEvent) {
                String str1 = text1.getText();
                String str2 = text2.getText();
                String str3 = text3.getText();
                String str4 = text4.getText();
                String str5 = text5.getText();
                if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty() || str5.isEmpty()) {
                    MessageBox dialog = new MessageBox(shell);

                    dialog.setText("Information");

                    dialog.setMessage("Fields should not be empty");

                    dialog.open();
                }else {
                    try {
                        BookRestService bookRestService = new BookRestService();
                        long isbn = Long.parseLong(str1);

                        int noofbooks = Integer.parseInt(str5);
                        //setNoofbooks(noofbooks);
                        Borrower borrower = new Borrower();
                        borrower.setNoofbooks(noofbooks);
                        borrower.setEmailid(str4);
                        borrower.setLastname(str3);
                        borrower.setFirstname(str2);
                        borrower.setIsbn(isbn);
                        bookRestService.createBorrower(borrower,isbn,str2,str3,str4,noofbooks);
                        System.out.println("book rented");
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        System.out.println("number not correct");
                    }
                        MessageBox dialog = new MessageBox(shell);

                        dialog.setText("Information");

                        dialog.setMessage("Book has been rented");
                        dialog.open();
                        shell.dispose();
                }
            }
        });

        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.dispose();
            }
        });

        shell.layout();
        shell.open();
    }
}