package com.demo.resttemplate.model;

import com.demo.resttemplate.service.BookRestService;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static org.eclipse.swt.SWT.BORDER;
import static org.eclipse.swt.SWT.NONE;
import static org.eclipse.swt.SWT.PUSH;

public class DeleteBook {
    public DeleteBook(){
        Display display = Display.getDefault();
        final Shell shell = new Shell();
        shell.setSize(700, 700);
        shell.setText("Deleting a book");

        Label label1 = new Label(shell, NONE);
        label1.setText("Enter the isbn to delete");
        label1.setBounds(50, 50, 400, 30);

        final Text text = new Text(shell, BORDER);
        text.setBounds(50, 100, 200, 30);
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

        Button button = new Button(shell, PUSH);
        button.setBounds(100, 150, 100, 30);
        button.setText("Delete a book");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String string = text.getText();
                if (string.isEmpty()) {
                    MessageBox dialog = new MessageBox(shell);

                    dialog.setText("Information");

                    dialog.setMessage("Field should not be empty");

                    dialog.open();
                } else {
                    try {
                        /*Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/bookrental", "root", "root");
                        Statement statement = con.createStatement();
                        String query = "delete from book where isbn= ?";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, string);
                        preparedStatement.execute();
                        preparedStatement.close();*/
                        BookRestService bookRestService = new BookRestService();
                        bookRestService.deleteBook();
                        MessageBox dialog = new MessageBox(shell);

                        dialog.setText("Information");

                        dialog.setMessage("Book deleted from the catalog");

                        dialog.open();

                        shell.dispose();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        shell.layout();
        shell.open();
    }

}
