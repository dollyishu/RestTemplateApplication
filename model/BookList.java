package com.demo.resttemplate.model;

import com.demo.resttemplate.service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.eclipse.swt.SWT.PUSH;
import static org.eclipse.swt.SWT.SetData;


public class BookList {
    public BookList() {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1,false));
        shell.setSize(700, 700);
        shell.setText("List of books");
      //  shell.open();
        {
            final Table table = new Table(shell, SWT.VIRTUAL | SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
            table.setSize(600, 600);
            table.setVisible(true);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);
            table.setItemCount(1);
            /*for (int i = 0; i < 500; i++) {
                TableItem item = new TableItem(table, SWT.FILL);
                item.setText("");
            }*/
            table.addListener(SetData, new Listener() {
                @Override
                public void handleEvent(Event event) {
                    try {
                       /* Connection con = DBConnect.getCon();
                        PreparedStatement preparedStatement = con.prepareStatement(
                                "select * from book");
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            TableItem item = new TableItem(table, SWT.NONE);
                            item.setText(new String[]
                                    {rs.getString(1), rs.getString(2),
                                            rs.getString(3), rs.getString(4),
                                            rs.getString(5)});
                        }*/
                        BookRestService bookRestService = new BookRestService();
                        bookRestService.getBooks();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

            table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            {
                TableColumn column1 = new TableColumn(table, SWT.BORDER);
                column1.setWidth(100);
                column1.setText("Book isbn");
            }

            {
                TableColumn column2 = new TableColumn(table, SWT.BORDER);
                column2.setWidth(100);
                column2.setText("Author name");
            }

            {
                TableColumn column3 = new TableColumn(table, SWT.BORDER);
                column3.setWidth(100);
                column3.setText("Book name");
            }

            {
                TableColumn column4 = new TableColumn(table, SWT.BORDER);
                column4.setWidth(100);
                column4.setText("Academic or not");
            }

            {
                TableColumn column5 = new TableColumn(table, SWT.BORDER);
                column5.setWidth(100);
                column5.setText("Book Stock");
            }
        }


        Button button1 = new Button(shell, PUSH);
        button1.setText("Back to main menu");
        button1.setLocation(40, 620);
        button1.setSize(100, 20);
        button1.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                shell.dispose();
            }
        });
        shell.open();

        Button button2 = new Button(shell, PUSH);
        button2.setText("Rent");
        button2.setLocation(120, 630);
        button2.setSize(100, 20);
        button2.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new RentBook();
                shell.dispose();
            }
        });
        shell.open();
        /*while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();*/
    }
}