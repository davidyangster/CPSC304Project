// import database.DatabaseConnectionHandler;

import controller.QueryResult;
import controller.UserInputHandler;
import delegates.TrainSystemDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrontEnd {
    private JTable table1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton selectButton;
    private JButton projectAttributesButton;
    private JButton joinButton;
    private JButton findCountButton;
    private JButton nestedAggButton;
    private JButton divideButton;
    private JButton printbutton;
    private JScrollPane textError;
    public JFrame mainFrame;
    private JScrollPane scrollable;
    private JFormattedTextField trainTablesFormattedTextField;
    private TrainSystemDelegate ourQuery = UserInputHandler.getInstance();

    public FrontEnd() {
        nestedAggButton = new JButton();
        mainFrame = new JFrame();
        JTextArea texts = new JTextArea();
        textError = new JScrollPane(texts);
        panel1 = new JPanel();
        // panel2 = new JPanel();
        scrollable = new JScrollPane();
        insertButton = new JButton("INSERT");
        deleteButton = new JButton("DELETE");
        updateButton = new JButton("UPDATE");
        selectButton = new JButton("SELECT");
        projectAttributesButton = new JButton("ATTRIBUTES");
        joinButton = new JButton("JOIN");
        findCountButton = new JButton("COUNT");
        divideButton = new JButton("DIVIDE");
        printbutton = new JButton("PRINT");
        String[] stuff = new String[2];
        stuff[0] = "david";
        stuff[1] = "yang";
        Object[][] data = {{"one", "two"}, {"one", "two"}};
        table1 = new JTable(data, stuff);
        table1.setFont(new Font("Serif", Font.BOLD, 15));
        String[] tables = {"Ticket", "Passenger"};
        scrollable.setViewportView(table1);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for (int i = 0; i < tablesLength; i ++) {
                //
                //}
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Choose Table For Insert",
                        JOptionPane.PLAIN_MESSAGE, null, tables, null);
                if (s == "Ticket") {
                    //TODO: input ticket adding function
                    JTextField seatNoField = new JTextField(5);
                    JTextField pidField = new JTextField(5);
                    JTextField classField = new JTextField(5);
                    JTextField trainIdField = new JTextField(5);
                    JTextField rowField = new JTextField(5);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("seatClass:"));
                    myPanel.add(classField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("trainId:"));
                    myPanel.add(trainIdField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("row:"));
                    myPanel.add(rowField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("seat_no:"));
                    myPanel.add(seatNoField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter Ticket Tuple Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        QueryResult thisOne = ourQuery.buyTickets(pidField.getText(), classField.getText(), trainIdField.getText(), rowField.getText(), seatNoField.getText());
                        if (!thisOne.success) {
                            texts.setText(texts.getText() + "\n" + thisOne.sqlResult);
                        }
                    }
                    // table1 = // implement jtable return;
                } else if (s == "Passenger") {
                    JTextField pidField = new JTextField(5);
                    JTextField firstNameField = new JTextField(5);
                    JTextField lastNameField = new JTextField(5);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("first_name:"));
                    myPanel.add(firstNameField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("last_name:"));
                    myPanel.add(lastNameField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter Passenger Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        String pid = pidField.getText();
                        String firstName = firstNameField.getText();
                        String lastName = lastNameField.getText();
                        ourQuery.createPassenger(pid,firstName,lastName);
                        QueryResult thisOne = ourQuery.createPassenger(pid,firstName,lastName);;
                        if (!thisOne.success) {
                            texts.setText(texts.getText() + "\n" + thisOne.sqlResult);
                        }
                        //TODO: implement addPassenger
                        // ourQuery.createPassenger(newPassenger);
                    }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Choose Table to Delete From",
                        JOptionPane.PLAIN_MESSAGE, null, tables, null);
                if (s == "Ticket") {
                    //TODO: input ticket adding function
                    JTextField ticketNoField = new JTextField(7);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("ticket_no:"));
                    myPanel.add(ticketNoField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter Ticket Primary Key", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        //TODO: implement finding the tuple with this primary key and deleting it
                        ourQuery.deleteTicket(ticketNoField.getText());
                        QueryResult thisOne = ourQuery.deleteTicket(ticketNoField.getText());
                        if (!thisOne.success) {
                            texts.setText(texts.getText() + "\n" + thisOne.sqlResult);
                        }

                    }
                    // table1 = // implement jtable return;
                } else if (s == "Passenger") {
                    //TODO: input ticket adding function
                    JTextField pidField = new JTextField(7);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter Passenger Primary Key", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        //TODO: implement finding the tuple with this primary key and deleting it
                        QueryResult thisOne = ourQuery.deletePassenger(pidField.getText());
                        if (!thisOne.success) {
                            texts.setText(texts.getText() + "\n" + thisOne.sqlResult);
                        }
                    }
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] newTables = {"Ticket_book_status"};
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Choose Table to Update",
                        JOptionPane.PLAIN_MESSAGE, null, newTables, null);
                if (s == "Ticket_book_status") {
                    JTextField ticketNoField = new JTextField(7);
                    JTextField pidField = new JTextField(7);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("ticket_no:"));
                    myPanel.add(ticketNoField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Enter TicketBookStatus Primary Keys", JOptionPane.OK_CANCEL_OPTION);
                    String[] bookStatus = {"booked", "cancelled"};
                    String status = (String)JOptionPane.showInputDialog(
                            mainFrame,
                            "Select Table", "book_status",
                            JOptionPane.PLAIN_MESSAGE, null, bookStatus, null);

                    if (result == JOptionPane.OK_OPTION) {
                        String ticketNo = ticketNoField.getText();
                        String pid = pidField.getText();
                        QueryResult thisOne = ourQuery.updateBookStatus(ticketNo, pid, status);
                        if (!thisOne.success) {
                            texts.setText(texts.getText() + "\n" + thisOne.sqlResult);
                        }

                        //TODO: search in the database for this info with status as the input
                    }
                }
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] newTable ={"Economy", "First Class"};
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Enter Selected Class attribute",
                        JOptionPane.PLAIN_MESSAGE, null, newTable, null);
                JTable tempTable;
                if (s == "Economy") {
                    //TODO: get all tuples with economy, store in temp
                    tempTable = ourQuery.showPassengersByClass("economy");
                } else {
                    //TODO: get all tuples with First class, store in temp
                    tempTable = ourQuery.showPassengersByClass("first class");
                }
                JScrollPane scrolls = new JScrollPane();
                JFrame tempFrame = new JFrame();
                scrolls.add(tempTable);
                scrolls.setViewportView(tempTable);
                tempFrame.add(scrolls);
                tempFrame.setVisible(true);
            }
        });
        projectAttributesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // implement
                JCheckBox status_Id = new JCheckBox("status_Id");
                JCheckBox booked_seats = new JCheckBox("booked_seats");
                JCheckBox max_seats = new JCheckBox("max_seats");
                JCheckBox avail_seats = new JCheckBox("avail_seats");
                JCheckBox waitlist = new JCheckBox("waitlst");

                JPanel myPanel = new JPanel();
                //myPanel.add(new JLabel("ticket_no:"));
                myPanel.add(status_Id);
                //myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                //myPanel.add(new JLabel("pid:"));
                myPanel.add(booked_seats);
                myPanel.add(max_seats);
                myPanel.add(avail_seats);
                myPanel.add(waitlist);
                ArrayList<String> selectedColumns= new ArrayList<>();

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                if (status_Id.isSelected()) {
                    selectedColumns.add(status_Id.getText());
                }
                if (booked_seats.isSelected()) {
                    selectedColumns.add(booked_seats.getText());
                }
                if (max_seats.isSelected()) {
                    selectedColumns.add(max_seats.getText());
                }
                if (avail_seats.isSelected()) {
                    selectedColumns.add(avail_seats.getText());
                }
                if (waitlist.isSelected()) {
                    selectedColumns.add(waitlist.getText());
                }
                String[] newSelected = new String[selectedColumns.size() - 1];
                selectedColumns.toArray(newSelected);
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = ourQuery.projectStatus(newSelected);; // set table2 to a method that returns the tables using selectedcolumns
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = ourQuery.join(); // set table equal to the join of two tables
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        findCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implement
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = ourQuery.aggregate(); // set this table equal to count
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        nestedAggButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implement
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = ourQuery.nested_aggregation(); // set this table equal to count
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implement
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = ourQuery.divide(); // set table2 to a method that returns the divided table
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        printbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] allTables = {"Ticket Book Status", "Ticket", "Passenger"};
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, allTables, null);
                JTable table2;
                if (s == "Ticket Book Status") {
                    table2 = ourQuery.getTickBookStatusTable();
                } else if (s == "Ticket"){
                    table2 = ourQuery.getTicketTable();
                } else {
                    table2 = ourQuery.getPassengerInfo();
                }
                //String[] stuffs = new String[2];
                //stuffs[0] = "davids";
                //stuffs[1] = "yangs";
                //Object[][] data = {{"onehundo", "twohundo"}, {"fourty", "six"}};
                //JTable table5 = new JTable(data, stuffs); // set table2 to a method that returns the tables,
                // if (s == "Passenger") { set jtable equal to passenger}
                //texts.setText(texts.getText() + "\n 1");
                scrollable.setViewportView(table2);
            }
        });
        scrollable.add(table1);
        JScrollPane pane = new JScrollPane(textError);
        // pane.setMaximumSize(new Dimension(pane.getWidth(), 3000));
        panel1.add(insertButton);
        panel1.add(deleteButton);
        panel1.add(updateButton);
        panel1.add(selectButton);
        panel1.add(projectAttributesButton);
        panel1.add(joinButton);
        panel1.add(findCountButton);
        panel1.add(nestedAggButton);
        panel1.add(divideButton);
        panel1.add(printbutton);
        texts.setText("Welcome To our GUI!");


    }

    public void refreshTable() {

    }

    public static void main(String[] args) {
        // JFrame frame = new JFrame("FrontEnd");
        // frame.setContentPane(new FrontEnd().panel2);
        FrontEnd lol = new FrontEnd();
        lol.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        // frame.getContentPane().add(BorderLayout.SOUTH, );
        lol.mainFrame.getContentPane().add(BorderLayout.NORTH, lol.panel1);
        lol.mainFrame.getContentPane().add(BorderLayout.CENTER, lol.scrollable);
        lol.mainFrame.getContentPane().add(BorderLayout.SOUTH, lol.textError);
        lol.mainFrame.setVisible(true);
    }
}
