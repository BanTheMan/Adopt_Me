package edu.mu.adopt.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Author: Nate Spencer.
 * GUI
 */
public class AdoptionView {

	private JFrame frame;
	private JTable petTable;
	private DefaultTableModel tableModel;
	private JComboBox<String> sortComboBox;
	private JButton addButton, adoptButton, removeButton, viewDetailsButton, saveButton;
	
	
	
	/**
	 * Constructor for GUI 
	 */
	public AdoptionView() {
		frame = new JFrame("Adopt Me - Pet Adoption Center");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});
		topPanel.add(new JLabel("Sort By:"));
		topPanel.add(sortComboBox);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
		String[] columns = {"Name", "Species", "Age"};
		tableModel = new DefaultTableModel(columns, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // make table cells read-only
            }
		};
		petTable = new JTable(tableModel);
		petTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // be able to select pets in table
		JScrollPane scrollPane = new JScrollPane(petTable); // be able to scroll through table
		mainPanel.add(new JScrollPane(petTable), BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		addButton = new JButton("Add");
		adoptButton = new JButton("Adopt");
		removeButton = new JButton("Remove");
		viewDetailsButton = new JButton("View Details");
		saveButton = new JButton("Save");
		
		bottomPanel.add(addButton);
		bottomPanel.add(adoptButton);
		bottomPanel.add(removeButton);
		bottomPanel.add(viewDetailsButton);
		bottomPanel.add(saveButton);
		
		
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		
	}
	
	/**
	 * Buttons for controller
	 * @param addListener
	 * @param adoptListener
	 * @param removeListener
	 * @param viewDetailsListener
	 * @param saveListener
	 * @param sortListener
	 */
	public void addActionListeners(
            ActionListener addListener,
            ActionListener adoptListener,
            ActionListener removeListener,
            ActionListener viewDetailsListener,
            ActionListener saveListener,
            ActionListener sortListener) {
        
        addButton.addActionListener(addListener);
        adoptButton.addActionListener(adoptListener);
        removeButton.addActionListener(removeListener);
        viewDetailsButton.addActionListener(viewDetailsListener);
        saveButton.addActionListener(saveListener);
        sortComboBox.addActionListener(sortListener);
    }
	
	/**
	 * Start the GUI
	 */
	public static void launch() {
		SwingUtilities.invokeLater(AdoptionView::new);
	}
	
	/**
	 * Update table with new data
	 * @param data
	 * 
	 */
	public void updatePetTable(String[][] data) {
        tableModel.setRowCount(0); // Clear existing data
        for (String[] row : data) {
            tableModel.addRow(row);
        }
    }
	
	/**
	 * @return selected row
	 */
	public int getSelectedPetIndex() {
        return petTable.getSelectedRow();
    }
	
	/**
	 * @return sort option selected
	 */
	public String getSelectedSortOption() {
		return (String) sortComboBox.getSelectedItem();
	}
	
	/**
	 * Shows table of importable pets for the user to select from
	 * @param importablePets
	 * @return selected row or -1
	 */
	public int addImportableDialog(String[][] importablePets) {
		String[] columnNames = {"Name", "Species", "Age"};
		
		JTable importedTable = new JTable(importablePets, columnNames);
		JScrollPane scrollPane = new JScrollPane(importedTable);
		
		int result;
		result = JOptionPane.showConfirmDialog(
				frame, scrollPane, "Select Pet to Import", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);	
		
		if (result == JOptionPane.OK_OPTION)
		{
			return importedTable.getSelectedRow();
		}
		
		else
		{
			return -1;
		}
	
	}
	
	/**
	 * Dialog for pet details
	 * @param petDetails
	 */
	public void petDetailsDialog(String[] petDetails) {
		String petMessage = String.format(
				"ID: %s\nName: %s\nType: %s\nSpecies: %s\nAge: %s\nStatus: %s", petDetails[0], petDetails[1], petDetails[2], petDetails[3], petDetails[4], petDetails[5]);
		
		JOptionPane.showMessageDialog(frame, petMessage, "Pet Details", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Shows message
	 * @param message
	 * @param title
	 * @param messageType
	 */
	public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
