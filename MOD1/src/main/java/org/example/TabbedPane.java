package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedPane {

    private DefaultTableModel tableModel;

    public TabbedPane(){
        this.createAndShowGUI();
    }
    public JFrame createAndShowGUI() {
        JFrame frame = new JFrame("TabbedPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(114, 204, 204));
        backgroundPanel.setLayout(new BorderLayout());


        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.ORANGE);
        redPanel.setLayout(new GridLayout(1, 3));


        Border labelBorder = BorderFactory.createTitledBorder("Labels");
        Border textFieldBorder = BorderFactory.createTitledBorder("Text Fields");
        Border emptyBorder = BorderFactory.createTitledBorder("");


        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        labelPanel.setBorder(labelBorder);
        labelPanel.add(new JLabel("FILE NAME:"));
        labelPanel.add(new JLabel("FILE TYPE:"));
        labelPanel.add(new JLabel("AUTHOR:"));

        JPanel textFieldPanel = new JPanel(new GridLayout(3, 1));
        textFieldPanel.setBorder(textFieldBorder);


        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 20));
        textFieldPanel.add(nameField);

        JTextField typeField = new JTextField();
        typeField.setPreferredSize(new Dimension(150, 20));
        textFieldPanel.add(typeField);

        JTextField authorField = new JTextField();
        authorField.setPreferredSize(new Dimension(150, 20));
        textFieldPanel.add(authorField);


        JPanel emptyPanel = new JPanel();
        emptyPanel.setBorder(emptyBorder);


        redPanel.add(labelPanel);
        redPanel.add(textFieldPanel);
        redPanel.add(emptyPanel);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setLayout(new FlowLayout());

        JButton messageButton = new JButton("Show Message");
        messageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click calculate to enter the name and age");
            }
        });

        JButton calculationButton = new JButton("Calculate");
        calculationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter first number:"));
                int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter second number:"));
                int result = num1 + num2;
                JOptionPane.showMessageDialog(null, "Result: " + result);
            }
        });

        panel.add(messageButton);
        panel. add(calculationButton);

        JMenuBar menuBar = new JMenuBar();
        panel.add(menuBar);

        JMenu menu = new JMenu("Options");
        JMenu menu1 = new JMenu("Files");
        JMenu menu2 = new JMenu("Something");
        JMenu menu3 = new JMenu("A Menu");
        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        JMenuItem menuItem1 = new JMenuItem("Rename File");
        JMenuItem menuItem2 = new JMenuItem("Delete File");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Rename selected");
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Delete selected");
            }
        });
        menu.add(menuItem1);
        menu.add(menuItem2);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);


        String[] columnNames = { "Name", "Reg. No" };


        Object[][] data = {
                { "Item 1", "Reg001" },
                { "Item 2", "Reg002" },
                { "Item 3", "Reg003" },
                { "Item 4", "Reg004" }
        };


        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setPreferredSize(new Dimension(300, 100));
        bluePanel.add(scrollPane);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        yellowPanel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        table = new JTable(tableModel);
        yellowPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter name:");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
                tableModel.addRow(new Object[]{name, age});
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to clear the list?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    tableModel.setRowCount(0);
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        yellowPanel.add(buttonPanel, BorderLayout.SOUTH);


        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(new Color(114, 204, 204));
        blackPanel.setLayout(new BorderLayout());


        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton returnButton = new JButton("Return to Form");


        JPanel BlackbuttonPanel = new JPanel();
        BlackbuttonPanel.setLayout(new FlowLayout());
        BlackbuttonPanel.add(returnButton);
        BlackbuttonPanel.add(exitButton);

        blackPanel.add(BlackbuttonPanel, BorderLayout.SOUTH);


        tabbedPane.addTab("The Form", redPanel);
        tabbedPane.addTab("The Display", panel);
        tabbedPane.addTab("The Table", bluePanel);
        tabbedPane.addTab("Final List", yellowPanel);
        tabbedPane.addTab("APP OPTIONS", blackPanel);

        contentPanel.add(tabbedPane, BorderLayout.CENTER);

        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        frame.getContentPane().add(backgroundPanel);

        frame.setSize(700, 600);
        frame.setVisible(true);
        return frame;
    }

}
