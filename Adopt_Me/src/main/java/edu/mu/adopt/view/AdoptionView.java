package edu.mu.adopt.view;

import javax.swing.*;
import java.awt.*;

/**
 * GUI
 */
public class AdoptionView {

	private JFrame frame;
	private JTable petTable;
	private JComboBox<String> sortComboBox;
	private JButton addButton, adoptButton, removeButton, viewDetailsButton, saveButton;
	
	
	
	public AdoptionView() {
		frame = new JFrame("Adopt Me - Pet Adoption Center");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		sortComboBox = new JComboBox<>(new String[] {"Sort by Name", "Sort by Age", "Sort by Species"});
		topPanel.add(new JLabel("Sort By:"));
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
		String[] columns = {"Name", "Species", "Age"};
		String[] [] emptyData = {};
		petTable = new JTable(emptyData, columns);
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
	
	public static void launch() {
		SwingUtilities.invokeLater(AdoptionView::new);
	}
	
	
	
}
