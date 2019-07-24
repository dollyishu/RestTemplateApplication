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

public class SearchBook {
    public SearchBook() {
        Display display = Display.getDefault();
        final Shell shell = new Shell();
        //shell.setLayout(new GridLayout(1,false));
        shell.setSize(500, 500);
        shell.setText("Search for a book");

        /*Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("1: Search with author name");
        label1.setSize(150, 20);
        label1.setLocation(30, 30);

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("2: Search with book title");
        label2.setSize(150, 20);
        label2.setLocation(30, 90);

        Label label3 = new Label(shell, SWT.BORDER);
        label3.setText("3: Search with isbn");
        label3.setSize(150, 20);
        label3.setLocation(30, 150);

*/
        final Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        String items[] = {"Search by Author name", "Search by Book name", "Search by Isbn"};
        combo.select(1);
        combo.setLocation(50, 150);
        combo.setSize(150, 30);
        combo.setItems(items);


        final Text text = new Text(shell, SWT.BORDER);
        text.setText("");
        text.setLocation(50, 200);
        text.setSize(150, 30);
        text.setTextLimit(30);
        text.addVerifyListener(new VerifyListener() {
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

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Search");
        button.setLocation(50, 250);
        button.setSize(100, 30);
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                try {
                    BookRestService bookRestService = new BookRestService();
                    bookRestService.getBooks();
                    bookRestService.getBook();

                    //new BookList();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        Button button1 = new Button(shell, PUSH);
        button1.setText("Back to main menu");
        button1.setLocation(150, 250);
        button1.setSize(120, 30);
        button1.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                shell.dispose();
            }
        });
        shell.layout();
        shell.open();
    }
}
