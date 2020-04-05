package ui;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JFormattedTextField trainTablesFormattedTextField;

    public FrontEnd() {
        mainFrame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
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
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for (int i = 0; i < tablesLength; i ++) {
                //
                //}
                String[] tables = {"MyName","YourName"};
                String s = (String)JOptionPane.showInputDialog(
                        mainFrame,
                        "Select Table", "Customized Dialogue",
                        JOptionPane.PLAIN_MESSAGE, null, tables, null);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        projectAttributesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        findCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel2.add(table1);
        panel1.add(insertButton);
        panel1.add(deleteButton);
        panel1.add(updateButton);
        panel1.add(selectButton);
        panel1.add(projectAttributesButton);
        panel1.add(joinButton);
        panel1.add(findCountButton);
        panel1.add(divideButton);


    }

    public static void main(String[] args) {
        // JFrame frame = new JFrame("FrontEnd");
        // frame.setContentPane(new FrontEnd().panel2);
        FrontEnd lol = new FrontEnd();
        lol.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        // frame.getContentPane().add(BorderLayout.SOUTH, );
        lol.mainFrame.getContentPane().add(BorderLayout.NORTH, lol.panel1);
        lol.mainFrame.getContentPane().add(BorderLayout.CENTER, lol.panel2);
        lol.mainFrame.setVisible(true);
    }
}
