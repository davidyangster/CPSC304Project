import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontEnd {
    private JTable table1;
    private JPanel panel1;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton selectButton;
    private JButton projectAttributesButton;
    private JButton joinButton;
    private JButton findCountButton;
    private JButton divideButton;
    private JFormattedTextField trainTablesFormattedTextField;

    public FrontEnd() {
        panel1 = new JPanel();
        insertButton = new JButton("INSERT");
        deleteButton = new JButton("DELETE");
        updateButton = new JButton("UPDATE");
        selectButton = new JButton("SELECT");
        projectAttributesButton = new JButton("ATTRIBUTES");
        joinButton = new JButton("JOIN");
        findCountButton = new JButton("COUNT");
        divideButton = new JButton("DIVIDE");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        JFrame frame = new JFrame("FrontEnd");
        frame.setContentPane(new FrontEnd().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
