package com.demo.resttemplate.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class BookRentalGUI {

    public BookRentalGUI() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Welcome to BookRental Store");
        shell.setSize(800, 800);
        shell.open();

        Button button1=new Button(shell,SWT.PUSH);
        button1.setText("Add a book");
        button1.setLocation(50, 50);
        button1.setSize(160, 40);
        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                //System.out.println("book is added to the catalog");
                new AddBook();
            }
        });

        Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("Search for a book");
        button2.setLocation(50, 120);
        button2.setSize(160, 40);
        button2.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("book is found");
                new SearchBook();
            }
        });

        Button button3 = new Button(shell, SWT.PUSH);
        button3.setText("Deleting a book");
        button3.setLocation(50, 190);
        button3.setSize(160, 40);
        button3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("book is deleted ");
                new DeleteBook();
            }
        });

        Button button4 = new Button(shell, SWT.PUSH);
        button4.setText("List of books in the catalog");
        button4.setLocation(50, 260);
        button4.setSize(160, 40);
        button4.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("list of books ");
                //new BookList();
            }
        });

        Button button5 = new Button(shell, SWT.PUSH);
        button5.setText("Rent a book");
        button5.setLocation(50, 330);
        button5.setSize(160, 40);
        button5.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("book is rented ");
                new RentBook();
            }
        });

        Button button6 = new Button(shell, SWT.PUSH);
        button6.setText("Return a book");
        button6.setLocation(50, 400);
        button6.setSize(160, 40);
        button6.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("book is returned ");
                new ReturnBook();

            }
        });

        Button button7 = new Button(shell, SWT.PUSH);
        button7.setText("Print out borrower list");
        button7.setLocation(50, 470);
        button7.setSize(160, 40);
        button7.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //System.out.println("list is printed");
                //new BorrowerList();
            }
        });

        shell.open();
        while (!shell.isDisposed())

        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    public static void main(String[] args) {
        new BookRentalGUI();
    }

}
