package ui;
import javax.swing.*;
import javax.swing.table.TableColumn;
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
    private JButton divideButton;
    private JButton printbutton;
    public JFrame mainFrame;
    private JScrollPane scrollable;
    private JFormattedTextField trainTablesFormattedTextField;

    public FrontEnd() {
        mainFrame = new JFrame();
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
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, tables, null);
                if (s == "Ticket") {
                    //TODO: input ticket adding function
                    JTextField ticketNoField = new JTextField(5);
                    JTextField pidField = new JTextField(5);
                    JTextField classField = new JTextField(5);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("ticket_no:"));
                    myPanel.add(ticketNoField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("class:"));
                    myPanel.add(classField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        System.out.println(ticketNoField.getText());
                    }
                    // table1 = // implement jtable return;
                } else if (s == "Passenger") {
                    //TODO: input passenger adding function
                    // table1 = // implement jtable return;
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
                            "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        System.out.println(pidField.getText());
                    }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, tables, null);
                if (s == "Ticket") {
                    //TODO: input ticket adding function
                    JTextField ticketNoField = new JTextField(7);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("ticket_no:"));
                    myPanel.add(ticketNoField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        //TODO: implement finding the tuple with this primary key and deleting it
                    }
                    // table1 = // implement jtable return;
                } else if (s == "Passenger") {
                    //TODO: input ticket adding function
                    JTextField pidField = new JTextField(7);

                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("pid:"));
                    myPanel.add(pidField);

                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        //TODO: implement finding the tuple with this primary key and deleting it
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
                        "Select Table", "Customized Dialogue",
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
                            "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                    String[] bookStatus = {"booked", "cancelled"};
                    String status = (String)JOptionPane.showInputDialog(
                            mainFrame,
                            "Select Table", "book_status",
                            JOptionPane.PLAIN_MESSAGE, null, bookStatus, null);

                    if (result == JOptionPane.OK_OPTION) {
                        String ticketNo = ticketNoField.getText();
                        String pid = pidField.getText();
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
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, newTable, null);
                JTable tempTable;
                if (s == "Economy") {
                    //TODO: get all tuples with economy, store in temp
                } else if (s == "First Class"){
                    //TODO: get all tuples with First class, store in temp
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
                JFrame temp = new JFrame();
                JScrollPane scrolls = new JScrollPane();
                JTable table3 = null; // set table2 to a method that returns the tables using selectedcolumns
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
                JTable table3 = null; // set table equal to the join of two tables
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
                JTable table3 = null; // set this table equal to count
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
                JTable table3 = null; // set table2 to a method that returns the divided table
                scrolls.add(table3);
                scrolls.setViewportView(table3);
                temp.add(scrolls);
                temp.setVisible(true);
            }
        });
        printbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] allTables = {"Passenger", "Class", "Ticket Book Status", "Ticket", "Train Status",
                        "Train", "Seat", "First Class", "Economy", "Route Name", " Route Details",
                        "Station on Route", "Train Operates On Route", "Station", "Arrives", "Departs"};
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, allTables, null);
                String[] stuffs = new String[2];
                stuffs[0] = "davids";
                stuffs[1] = "yangs";
                Object[][] data = {{"onehundo", "twohundo"}, {"fourty", "six"}};
                JTable table2 = new JTable(data, stuffs); // set table2 to a method that returns the tables,
                // if (s == "Passenger") { set jtable equal to passenger}
                scrollable.setViewportView(table2);
            }
        });
        scrollable.add(table1);
        panel1.add(insertButton);
        panel1.add(deleteButton);
        panel1.add(updateButton);
        panel1.add(selectButton);
        panel1.add(projectAttributesButton);
        panel1.add(joinButton);
        panel1.add(findCountButton);
        panel1.add(divideButton);
        panel1.add(printbutton);


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
        lol.mainFrame.setVisible(true);
    }
}
