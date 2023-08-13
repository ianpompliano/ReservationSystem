//Ian Pompliano and Rakshit Sridhar
//Final Project: Restaurant reservation system
//Compile with: javac MainGUI.java
//Run with: java MainGUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MainGUI extends JFrame {
    private JButton addReservationButton;
    private JButton cancelReservationButton;
    private JButton editReservationButton;
    private JButton searchReservationsButton;
    private JButton displayReservationsButton;
    private JTable reservationsTable;

    private Schedule schedule;

    public MainGUI() {
        setTitle("Restaurant Reservation System");
        setSize(850, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addReservationButton = new JButton("Add Reservation");
        searchReservationsButton = new JButton("Search Reservations");
        displayReservationsButton = new JButton("Display Reservations");

        setLayout(new GridLayout(3, 1));
        add(addReservationButton);
        add(searchReservationsButton);
        add(displayReservationsButton);

        schedule = new Schedule();

        //Sample Data: uncomment to add to schedule
        /*
        schedule.addReservation("Smith", "713-310-1493", "Peanuts, shellfish, gluten", "08/15/23", 8, 3);
        schedule.addReservation("Johnson", "832-555-7890", "Vegetarian", "09/22/23", 2, 4);
        schedule.addReservation("Williams", "281-123-4567", "No restrictions", "10/05/23", 5, 6);
        schedule.addReservation("Brown", "713-987-6543", "Dairy-free", "11/18/23", 1, 2);
        schedule.addReservation("Jones", "832-111-2222", "Nut-free", "12/01/23", 7, 8);
        schedule.addReservation("Miller", "281-333-4444", "Vegan", "01/12/24", 6, 10);
        schedule.addReservation("Davis", "713-310-1493", "Peanuts, shellfish, gluten", "02/25/24", 4, 8);
        schedule.addReservation("Garcia", "832-555-7890", "Vegetarian", "03/10/24", 3, 6);
        schedule.addReservation("Rodriguez", "281-123-4567", "No restrictions", "04/22/24", 9, 4);
        schedule.addReservation("Martinez", "713-987-6543", "Dairy-free", "05/03/24", 5, 2);
        schedule.addReservation("Taylor", "832-111-2222", "Nut-free", "06/14/24", 2, 6);
        schedule.addReservation("Thomas", "281-333-4444", "Vegan", "07/27/24", 8, 3);
        schedule.addReservation("Jackson", "713-310-1493", "Peanuts, shellfish, gluten", "08/09/24", 1, 10);
        schedule.addReservation("White", "832-555-7890", "Vegetarian", "09/15/24", 4, 5);
        schedule.addReservation("Harris", "281-123-4567", "No restrictions", "10/20/24", 6, 8);
        schedule.addReservation("Martin", "713-987-6543", "Dairy-free", "11/02/24", 9, 4);
        schedule.addReservation("Thompson", "832-111-2222", "Nut-free", "12/08/24", 3, 6);
        schedule.addReservation("Garcia", "281-333-4444", "Vegan", "01/15/25", 7, 2);
        schedule.addReservation("Lee", "713-310-1493", "Peanuts, shellfish, gluten", "02/28/25", 6, 6);
        schedule.addReservation("Hall", "832-555-7890", "Vegetarian", "03/06/25", 2, 4);
        schedule.addReservation("Allen", "281-123-4567", "No restrictions", "04/12/25", 8, 8);
        schedule.addReservation("Young", "713-987-6543", "Dairy-free", "05/18/25", 5, 3);
        schedule.addReservation("Walker", "832-111-2222", "Nut-free", "06/22/25", 4, 4);
        schedule.addReservation("King", "281-333-4444", "Vegan", "07/27/25", 1, 6);
        schedule.addReservation("Wright", "713-310-1493", "Peanuts, shellfish, gluten", "08/03/25", 9, 2);
        schedule.addReservation("Lewis", "832-555-7890", "Vegetarian", "09/11/25", 6, 8);
        schedule.addReservation("Scott", "281-123-4567", "No restrictions", "10/19/25", 3, 4);
        schedule.addReservation("Turner", "713-987-6543", "Dairy-free", "11/22/25", 5, 5);
        schedule.addReservation("Adams", "832-111-2222", "Nut-free", "12/25/25", 7, 10);
        schedule.addReservation("Baker", "281-333-4444", "Vegan", "01/01/26", 2, 3);
        schedule.addReservation("Cook", "713-310-1493", "Peanuts, shellfish, gluten", "02/08/26", 8, 8);
        schedule.addReservation("Green", "832-555-7890", "Vegetarian", "03/14/26", 1, 6);
        schedule.addReservation("Hill", "281-123-4567", "No restrictions", "04/21/26", 4, 2);
        schedule.addReservation("Carter", "713-987-6543", "Dairy-free", "05/29/26", 6, 5);
        schedule.addReservation("Mitchell", "832-111-2222", "Nut-free", "06/03/26", 3, 4);
        schedule.addReservation("Turner", "281-333-4444", "Vegan", "07/12/26", 5, 8);
        schedule.addReservation("Phillips", "713-310-1493", "Peanuts, shellfish, gluten", "08/20/26", 7, 10);
        schedule.addReservation("Roberts", "832-555-7890", "Vegetarian", "09/28/26", 1, 2);
        schedule.addReservation("Morris", "281-123-4567", "No restrictions", "10/30/26", 9, 4);
        schedule.addReservation("Turner", "713-987-6543", "Dairy-free", "11/06/26", 3, 6);
        schedule.addReservation("White", "832-111-2222", "Nut-free", "12/13/26", 6, 8);
        schedule.addReservation("Kelly", "281-333-4444", "Vegan", "01/21/27", 2, 5);
        schedule.addReservation("Young", "713-310-1493", "Peanuts, shellfish, gluten", "02/28/27", 7, 3);
        */

        addReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame addContactFrame = new JFrame("Add Reservation");
                addContactFrame.setSize(850, 600);

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField();

                JLabel phoneNumberLabel = new JLabel("Phone Number:");
                JTextField phoneNumberField = new JTextField();

                JLabel dietaryRestrictionsLabel = new JLabel("Dietary Restrictions:");
                JTextField dietaryRestrictionsField = new JTextField();

                JLabel dateLabel = new JLabel("Date (mm/dd/yy):");
                JTextField dateField = new JTextField();

                JLabel timeLabel = new JLabel("Time (1-9pm):");
                JTextField timeField = new JTextField();

                JLabel partySizeLabel = new JLabel("Party Size:");
                JTextField partySizeField = new JTextField();

                JButton addButton = new JButton("Add");
                JButton cancelButton = new JButton("Cancel"); 

                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = nameField.getText();
                        String phoneNumber = phoneNumberField.getText();
                        String dietaryRestrictions = dietaryRestrictionsField.getText();
                        String date = dateField.getText();
                        int time = 0;
                        int partySize = 0;

                        //Validating inputs:
                        if (!date.matches("\\d{2}/\\d{2}/\\d{2}")) {
                            JOptionPane.showMessageDialog(null, "Please use mm/dd/yy format for date.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        try {
                            time = Integer.parseInt(timeField.getText());
                            if (time < 1 || time > 9) {
                                JOptionPane.showMessageDialog(null, "Invalid time. Enter a value between 1 and 9.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid time. Enter a value between 1 and 9.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        try {
                            partySize = Integer.parseInt(partySizeField.getText());
                            if (partySize <= 0) {
                                JOptionPane.showMessageDialog(null, "Invalid party size. Enter a value greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid party size. Enter an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        if (schedule.isDuplicate(name, phoneNumber, dietaryRestrictions, date, time, partySize)) {
                            JOptionPane.showMessageDialog(null, "Reservation already exits. Please revise input.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        if (schedule.moreThanThree(date, time)) {
                            JOptionPane.showMessageDialog(null, "Too many reservations. Select another time.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        schedule.addReservation(name, phoneNumber, dietaryRestrictions, date, time, partySize);
                        schedule.sortByDate();
                        addContactFrame.dispose();
                    }
                });

                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addContactFrame.dispose();
                    }
                });

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(8, 2));
                panel.add(nameLabel);
                panel.add(nameField);
                panel.add(phoneNumberLabel);
                panel.add(phoneNumberField);
                panel.add(dietaryRestrictionsLabel);
                panel.add(dietaryRestrictionsField);
                panel.add(dateLabel);
                panel.add(dateField);
                panel.add(timeLabel);
                panel.add(timeField);
                panel.add(partySizeLabel);
                panel.add(partySizeField);
                panel.add(cancelButton);
                panel.add(addButton);

                addContactFrame.add(panel);
                addContactFrame.setVisible(true);
            }
        });

        searchReservationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame searchReservationsFrame = new JFrame("Search Reservations (Sorted by Date)");
                searchReservationsFrame.setSize(850, 600);

                String[] columnNames = {"Name", "Phone Number", "Dietary Restrictions", "Date", "Time (pm)", "Party Size"};

                DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                for (Reservation reservation : schedule.reservations) {
                    Object[] rowData = {
                        reservation.getName(),
                        reservation.getPhoneNumber(),
                        reservation.getDietaryRestrictions(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getPartySize()
                    };
                    model.addRow(rowData);
                }

                JTable reservationsTable = new JTable(model);
                reservationsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn nameColumn = reservationsTable.getColumnModel().getColumn(0);
                nameColumn.setPreferredWidth(150);

                TableColumn phoneNumberColumn = reservationsTable.getColumnModel().getColumn(1);
                phoneNumberColumn.setPreferredWidth(150);

                TableColumn dietColumn = reservationsTable.getColumnModel().getColumn(2);
                dietColumn.setPreferredWidth(300);

                reservationsTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                reservationsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JScrollPane scrollPane = new JScrollPane(reservationsTable);
                searchReservationsFrame.add(scrollPane);

                JButton backButton = new JButton("Back");
                JButton editButton = new JButton("Edit Reservation");
                JButton cancelButton = new JButton("Cancel Reservation");

                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        searchReservationsFrame.dispose();
                    }
                });              

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = reservationsTable.getSelectedRow();

                        if (selectedRow != -1) { 
                            int rowIndex = reservationsTable.convertRowIndexToModel(selectedRow); 
                            Reservation selectedReservation = schedule.reservations[rowIndex]; 

                            JFrame editContactFrame = new JFrame("Edit Reservation");
                            editContactFrame.setSize(850, 600);

                            JLabel nameLabel = new JLabel("Name:");
                            JTextField nameField = new JTextField(selectedReservation.getName());

                            JLabel phoneNumberLabel = new JLabel("Phone Number:");
                            JTextField phoneNumberField = new JTextField(selectedReservation.getPhoneNumber());

                            JLabel dietaryRestrictionsLabel = new JLabel("Dietary Restrictions:");
                            JTextField dietaryRestrictionsField = new JTextField(selectedReservation.getDietaryRestrictions());

                            JLabel dateLabel = new JLabel("Date:");
                            JTextField dateField = new JTextField(selectedReservation.getDate());

                            JLabel timeLabel = new JLabel("Time (1-9pm):");
                            JTextField timeField = new JTextField(String.valueOf(selectedReservation.getTime()));

                            JLabel partySizeLabel = new JLabel("Party Size:");
                            JTextField partySizeField = new JTextField(String.valueOf(selectedReservation.getPartySize()));

                            JButton updateButton = new JButton("Update");
                            updateButton.addActionListener(new ActionListener() {

                                public void actionPerformed(ActionEvent e) {
                                    String name = nameField.getText();
                                    String phoneNumber = phoneNumberField.getText();
                                    String dietaryRestrictions = dietaryRestrictionsField.getText();
                                    String date = dateField.getText();
                                    int time = 0;
                                    int partySize = 0;

                                    //Validating inputs:
                                    if (!date.matches("\\d{2}/\\d{2}/\\d{2}")) {
                                        JOptionPane.showMessageDialog(null, "Please use mm/dd/yy format for date.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    try {
                                        time = Integer.parseInt(timeField.getText());
                                        if (time < 1 || time > 9) {
                                            JOptionPane.showMessageDialog(null, "Invalid time. Enter a value between 1 and 9.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid time. Enter a value between 1 and 9.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    try {
                                        partySize = Integer.parseInt(partySizeField.getText());
                                        if (partySize <= 0) {
                                            JOptionPane.showMessageDialog(null, "Invalid party size. Enter a value greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid party size. Enter an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    if (schedule.isDuplicate(name, phoneNumber, dietaryRestrictions, date, time, partySize)) {
                                        JOptionPane.showMessageDialog(null, "Reservation already exits. Please revise input.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    if (schedule.moreThanThree(date, time)) {
                                        JOptionPane.showMessageDialog(null, "Too many reservations. Select another time.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    schedule.editReservation(selectedReservation, 
                                                             nameField.getText(), 
                                                             phoneNumberField.getText(),
                                                             dietaryRestrictionsField.getText(), 
                                                             dateField.getText(), 
                                                             Integer.parseInt(timeField.getText()), 
                                                             Integer.parseInt(partySizeField.getText())
                                                            );

                                    schedule.sortByDate();
                                    editContactFrame.dispose();

                                    setVisible(true);
                                    toFront();
                                }
                            });

                            JButton cancelButton = new JButton("Cancel");
                            cancelButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    editContactFrame.dispose();
                                }
                            });                         

                            JPanel panel = new JPanel();
                            panel.setLayout(new GridLayout(8, 2));
                            panel.add(nameLabel);
                            panel.add(nameField);
                            panel.add(phoneNumberLabel);
                            panel.add(phoneNumberField);
                            panel.add(dietaryRestrictionsLabel);
                            panel.add(dietaryRestrictionsField);
                            panel.add(dateLabel);
                            panel.add(dateField);
                            panel.add(timeLabel);
                            panel.add(timeField);
                            panel.add(partySizeLabel);
                            panel.add(partySizeField);
                            panel.add(cancelButton);
                            panel.add(updateButton);

                            editContactFrame.add(panel);
                            editContactFrame.setVisible(true);
                        }
                    }
                });

                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = reservationsTable.getSelectedRow();

                        if (selectedRow != -1) {
                            int rowIndex = reservationsTable.convertRowIndexToModel(selectedRow); 
                            schedule.cancelReservation(rowIndex);

                            DefaultTableModel tableModel = (DefaultTableModel) reservationsTable.getModel();
                            tableModel.removeRow(rowIndex);
                        }
                    }
                });


                JPanel buttonPanel = new JPanel();
                buttonPanel.add(backButton);
                buttonPanel.add(editButton);
                buttonPanel.add(cancelButton);

                searchReservationsFrame.add(buttonPanel, BorderLayout.SOUTH);
                searchReservationsFrame.setVisible(true);
            }
        });
    
        displayReservationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JFrame displayReservationsFrame = new JFrame("Display Reservations");
                displayReservationsFrame.setSize(850, 600);

                String[] columnNames = {"Name", "Phone Number", "Dietary Restrictions", "Date", "Time (pm)", "Party Size"};

                DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                for (Reservation reservation : schedule.reservations) {
                    Object[] rowData = {
                        reservation.getName(),
                        reservation.getPhoneNumber(),
                        reservation.getDietaryRestrictions(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getPartySize()
                    };
                    model.addRow(rowData);
                }

                JTable reservationsTable = new JTable(model);
                reservationsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn nameColumn = reservationsTable.getColumnModel().getColumn(0);
                nameColumn.setPreferredWidth(150);

                TableColumn phoneNumberColumn = reservationsTable.getColumnModel().getColumn(1);
                phoneNumberColumn.setPreferredWidth(150);

                TableColumn dietColumn = reservationsTable.getColumnModel().getColumn(2);
                dietColumn.setPreferredWidth(300);

                reservationsTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                reservationsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JScrollPane scrollPane = new JScrollPane(reservationsTable);
                displayReservationsFrame.add(scrollPane);

                JButton backButton = new JButton("Back");
                
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayReservationsFrame.dispose();
                    }
                });             
                
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(backButton);

                displayReservationsFrame.add(buttonPanel, BorderLayout.SOUTH);
                displayReservationsFrame.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
            }
        });
    }
}
