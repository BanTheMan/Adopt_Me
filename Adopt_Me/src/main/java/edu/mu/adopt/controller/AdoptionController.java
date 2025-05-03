package edu.mu.adopt.controller;

import java.util.Comparator;

import edu.mu.adopt.model.Home;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.utility.HandleJSON;
import edu.mu.adopt.view.AdoptionView;

public class AdoptionController <T extends Pet> {
	
	private Shelter shelter;
	private Home home;
	private AdoptionView view;
	private HandleJSON jsonHandler;
	private Comparator<T> currentFilter;
	
	public AdoptionController(Shelter<T> shelter, AdoptionView view) {
		this.shelter = shelter;
		this.view = view;
		this.home = new Home<Pet>();
		this.jsonHandler = new HandleJSON();
		
		
		setupActionListeners();
		
//		loadPetsFromFiles();
		
//		updateView();
	}
	
	private void setupActionListeners() {
        view.addActionListeners(
            e -> addButtonPressed(null),           // Add button
            e -> adoptPetButtonPressed(null),         // Adopt button
            e -> removePetButtonPressed(null) ,        // Remove button
            e -> viewDetailsButtonPressed(null),      // View Details button
            e -> saveButtonPressed(null),         // Save button
            e -> sortSelectionPressed()          // Sort combo box
        );
    }
	
	public <T extends Pet> void addButtonPressed(T pet) {
//        String[][] importablePetsData = ;
//        
//        // Show dialog with importable pets
//        int selectedIndex = view.showImportablePetsDialog(importablePetsData);
//        
//        if (selectedIndex >= 0) {
//            // Get the selected pet from the importable list
//            List<T> importablePetsList = new ArrayList<>(shelter.getImportablePets());
//            if (selectedIndex < importablePetsList.size()) {
//                T selectedPet = importablePetsList.get(selectedIndex);
//                
//                // Add the pet to stock (which also removes it from importable)
//                shelter.addPet(selectedPet);
//                
//                view.showMessage("Pet imported successfully!", "Import Successful", JOptionPane.INFORMATION_MESSAGE);
//                updateView();
//            }
//        }
	}
	
	public <T extends Pet> void importExoticPet(T pet) {
		
	}
	
	public <T extends Pet> void adoptPetButtonPressed(T pet) {
		// Remove pet from shelter
		// Place pet in home
		
	}
	
	public <T extends Pet> void removePetButtonPressed(T pet) {
		
	}
	
	public <T extends Pet> void viewDetailsButtonPressed(T pet) {
		
	}
	
	public <T extends Pet> void saveButtonPressed(T pet) {
		
	}
	
	public void sortSelectionPressed() {
		
	}
	
	private String[][] convertPetsToTableData() {
//        // Get pets from shelter and sort them if a comparator is set
//        List<T> petsInStock = new ArrayList<>(shelter.getPetsInStock());
//        
//        if (currentComparator != null) {
//            petsInStock.sort(currentComparator);
//        } else {
//            // Use natural ordering (Comparable implementation) if no comparator is set
//            Collections.sort(petsInStock);
//        }
//        
//        // Convert to table data format
//        String[][] tableData = new String[petsInStock.size()][4];
//        
//        for (int i = 0; i < petsInStock.size(); i++) {
//            T pet = petsInStock.get(i);
//            tableData[i][0] = pet.getName();
//            tableData[i][1] = pet.getSpecies();
//            tableData[i][2] = String.valueOf(pet.getAge());
//            tableData[i][3] = pet.isAdopted() ? "Adopted" : "Available";
//        }
//        
//        return tableData;
		return null;
    }

}
