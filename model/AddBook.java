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
import java.sql.SQLException;

public class AddBook {
    //protected String message;

    public AddBook() {
        Display display = Display.getDefault();
        Shell shell = new Shell();
        shell.setSize(700, 700);
        shell.setText("Adding a book");

        Label label1 = new Label(shell,SWT.BORDER);
        label1.setText("Enter book isbn");
        label1.setSize(130, 20);
        label1.setLocation(30, 30);

        Label label2 = new Label(shell,SWT.BORDER);
        label2.setText("Enter author name");
        label2.setSize(130, 20);
        label2.setLocation(30, 90);

        Label label3 = new Label(shell,SWT.BORDER);
        label3.setText("Enter book name");
        label3.setSize(130, 20);
        label3.setLocation(30, 150);

        Label label4 = new Label(shell,SWT.BORDER);
        label4.setText("Enter academic or \n nonacademic");
        label4.setSize(130, 40);
        label4.setLocation(30, 210);

        Label label5 = new Label(shell,SWT.BORDER);
        label5.setText("Enter book stock");
        label5.setSize(130, 20);
        label5.setLocation(30, 270);

       /* Label label6 = new Label(shell, SWT.BORDER);
        label6.setText("Enter no of books");
        label6.setSize(130, 20);
        label6.setLocation(30, 330);

*/
        final Text text1 = new Text(shell,SWT.BORDER);
        text1.setText("");
        text1.setBounds(200, 30, 130, 20);
        text1.setTextLimit(13);
        text1.addVerifyListener(new VerifyListener(){
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

        final Text text2 = new Text(shell,SWT.BORDER);
        text2.setText("");
        text2.setBounds(200, 90, 130, 20);
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
        text3.setBounds(200, 150, 130, 20);
        text3.setTextLimit(30);
        text3.addVerifyListener(new VerifyListener() {
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
        text4.setBounds(200, 210, 130, 20);
        text4.setTextLimit(30);

        final Text text5 = new Text(shell, SWT.BORDER);
        text5.setText("");
        text5.setBounds(200, 270, 130, 20);
        text5.setTextLimit(10);
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


        Button button = new Button(shell,SWT.PUSH);
        button.setText("add book");
        button.setLocation(150, 350);
        button.setSize(100, 20);

        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String s1 = text1.getText();
                //long isbn = Long.parseLong(s1);
                String s2 = text2.getText();
                String s3 = text3.getText();
                String s4 = text4.getText();
                String s5 = text5.getText();
                //int bookstock = Integer.parseInt(s5);
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {
                    MessageBox dialog = new MessageBox(shell);

                    dialog.setText("Information");

                    dialog.setMessage("Fields should not be empty");

                    dialog.open();
                }else {
                    try {
                        BookRestService bookRestService = new BookRestService();
                        long isbn = Long.parseLong(s1);
                        int bookstock = Integer.parseInt(s5);
                        Book book = new Book(isbn, s2, s3, s4, bookstock);
                        bookRestService.createBook(book);
                        System.out.println("book added");
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        System.out.println("number not correct");
                    }
                    MessageBox dialog = new MessageBox(shell);

                    dialog.setText("Information");

                    dialog.setMessage("Book is added to the catalog successfully");

                    dialog.open();
                    shell.dispose();
                }

                }
        });
        shell.layout();
        shell.open();
    }
}
