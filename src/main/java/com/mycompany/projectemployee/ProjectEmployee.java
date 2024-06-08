

package com.mycompany.projectemployee;

import Clases.Employee;
import Clases.HourlyEmployee;
import Clases.PermanentEmployee;
import Clases.TemporaryEmployee;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;


public class ProjectEmployee extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField firstNameField, lastNameField, idNumberField, childrenField;
    private JTextField hoursWorkedField, startDateField, endDateField, yearsOfServiceField;
    private JComboBox<String> employeeTypeComboBox;

    public ProjectEmployee() {
        setTitle("Employee Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table model
        tableModel = new DefaultTableModel(new Object[]{"First Name", "Last Name", "ID Number", "Children", "Employee Type", "Details"}, 0);
        table = new JTable(tableModel);

        // Panels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Text fields
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        idNumberField = new JTextField(15);
        childrenField = new JTextField(5);

        hoursWorkedField = new JTextField(10);
        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        yearsOfServiceField = new JTextField(10);

        employeeTypeComboBox = new JComboBox<>(new String[]{"Hourly", "Temporary", "Permanent"});

        // Data entry panel
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("ID Number:"));
        panel.add(idNumberField);
        panel.add(new JLabel("Number of Children:"));
        panel.add(childrenField);
        panel.add(new JLabel("Employee Type:"));
        panel.add(employeeTypeComboBox);

        panel.add(new JLabel("Hours Worked:"));
        panel.add(hoursWorkedField);
        panel.add(new JLabel("Start Date:"));
        panel.add(startDateField);
        panel.add(new JLabel("End Date:"));
        panel.add(endDateField);
        panel.add(new JLabel("Years of Service:"));
        panel.add(yearsOfServiceField);

        // Buttons
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Do you want to save the information?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    addEmployee();
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Data saved successfully.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all fields?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    clearFields();
                }
            }
        });

        panel.add(saveButton);
        panel.add(clearButton);

        // Add table to panel
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Add panel to window
        add(panel);
    }

    private void addEmployee() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String idNumber = idNumberField.getText();
        int numberOfChildren = Integer.parseInt(childrenField.getText());
        String employeeType = (String) employeeTypeComboBox.getSelectedItem();
        Employee employee = null;

        switch (employeeType) {
            case "Hourly":
                int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
                employee = new HourlyEmployee(firstName, lastName, idNumber, numberOfChildren, hoursWorked);
                tableModel.addRow(new Object[]{firstName, lastName, idNumber, numberOfChildren, "Hourly", hoursWorked + " hours"});
                break;
            case "Temporary":
                Date startDate = new Date(startDateField.getText());
                Date endDate = new Date(endDateField.getText());
                employee = new TemporaryEmployee(firstName, lastName, idNumber, numberOfChildren, startDate, endDate);
                tableModel.addRow(new Object[]{firstName, lastName, idNumber, numberOfChildren, "Temporary", "Start: " + startDate + ", End: " + endDate});
                break;
            case "Permanent":
                int yearsOfService = Integer.parseInt(yearsOfServiceField.getText());
                employee = new PermanentEmployee(firstName, lastName, idNumber, numberOfChildren, yearsOfService);
                tableModel.addRow(new Object[]{firstName, lastName, idNumber, numberOfChildren, "Permanent", yearsOfService + " years"});
                break;
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        idNumberField.setText("");
        childrenField.setText("");
        hoursWorkedField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        yearsOfServiceField.setText("");
        employeeTypeComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectEmployee().setVisible(true);
            }
        });
    }
}
