package com.demo.resttemplate.model;

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

public class ReturnBook {
    public ReturnBook() {
        Display display = Display.getDefault();
        final Shell shell = new Shell();
        //shell.setLayout(new GridLayout(1,false));
        shell.setSize(700, 700);
        shell.setText("Returning a book");

        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("Please enter the email id");
        label1.setSize(150, 20);
        label1.setLocation(70, 150);

        final Text text = new Text(shell, SWT.BORDER);
        text.setText("");
        text.setSize(180, 20);
        text.setLocation(70, 200);
        text.setTextLimit(30);
        final Label label2 = new Label(shell, SWT.NONE);
        label2.setText("");
        label2.setSize(150, 20);
        label2.setLocation(70, 220);
        text.addVerifyListener(new VerifyListener() {
            public void verifyText(VerifyEvent event) {
                boolean status = Email.email_Valid(text.getText());
                if(status) {
                    label2.setText("");
                } else{
                    label2.setText("Please enter a valid email");
                }
            }
        });

        Button button = new Button(shell, PUSH);
        button.setText("Return book");
        button.setBounds(100, 400, 100, 30);

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String string = text.getText();
                if (string.isEmpty()){
                    MessageBox dialog = new MessageBox(shell);

                    dialog.setText("Information");

                    dialog.setMessage("Field should not be empty");

                    dialog.open();
                }
                    try {
                        /*Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/bookrental", "root", "root");
                        Statement statement = con.createStatement();
                        String query = "delete from rental where email = ?";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, string);
                        preparedStatement.execute();
                        preparedStatement.close();*/

                        MessageBox dialog = new MessageBox(shell);

                        dialog.setText("Information");

                        dialog.setMessage("Book has been returned successfully");

                        dialog.open();
                        shell.dispose();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        });

        shell.layout();
        shell.open();
    }
}