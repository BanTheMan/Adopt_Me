package edu.mu.adopt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.model.ExoticAnimalAdapter;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.utility.HandleJSON;
import edu.mu.adopt.utility.SortByAge;
import edu.mu.adopt.utility.SortBySpecies;
import edu.mu.adopt.view.AdoptionView;

public class AdoptionController <T extends Pet> {
	
	private Shelter<T> shelter;
	private AdoptionView view;
	private HandleJSON jsonHandler;
	private Comparator<T> currentFilter;
	
	public AdoptionController(Shelter<T> shelter) {
		this.shelter = new Shelter<T>();
		this.view = new AdoptionView();
		this.jsonHandler = new HandleJSON();
		
		setupActionListeners();
		
		loadPetsFromFiles();
		
		updateView();
	}
	
	private void setupActionListeners() {
        view.addActionListeners(
            e -> addButtonPressed(),           // Add button
            e -> adoptPetButtonPressed(),         // Adopt button
            e -> removePetButtonPressed() ,        // Remove button
            e -> viewDetailsButtonPressed(),      // View Details button
            e -> saveButtonPressed(),         // Save button
            e -> sortSelectionPressed()          // Sort combo box
        );
    }
	
	private void addButtonPressed() {
		// Get importable pets in table form
		String[][] importablePets = convertImportableToTableData();
		
		// Display add importable pet dialog
		// Get selected pet to be imported
		int selectedIndex = view.addImportableDialog(importablePets);
		
		if (selectedIndex >= 0) {
			// Get selected pet object
			List<T> importablePetsList = (List<T>) getSortedImportablePets();
			// Check in range
			if (selectedIndex < importablePetsList.size()) {
				// Add pet
				T selectedPet = importablePetsList.get(selectedIndex);
				boolean added = shelter.addPet(selectedPet);
				
				if (added) {
					// Success message
					view.showMessage(selectedPet.getName() + " was successfully added to shelter!", "Import Successful", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Failure message
					view.showMessage(selectedPet.getName() + " could not be added to shelter.", "Import Unsuccessful", JOptionPane.ERROR_MESSAGE);
				}
				updateView();
			}
		} else {
			// Pet not selected message
			view.showMessage("Please select a pet to add", "Selection Required", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private Set<T> importExoticPets(Set<ExoticAnimal> exoticAnimals) {
		Set<T> tamedExoAnis = new HashSet<T>();
		for (ExoticAnimal exoAni : exoticAnimals) {
			tamedExoAnis.add((T) new ExoticAnimalAdapter(exoAni));
		}
		return tamedExoAnis;
	}
	
	private void adoptPetButtonPressed() {
		// Get selected pet
		int selectedIndex = view.getSelectedPetIndex();
		if (selectedIndex >= 0) {
			List<T> petsInStockList = (List<T>) getSortedInStockPets();
			// Check in range
			if (selectedIndex < petsInStockList.size()) {
				T selectedPet = petsInStockList.get(selectedIndex);
				
				// Check if adopted
				if (selectedPet.isAdopted()) {
					// Pet is already adopted message
					view.showMessage(selectedPet.getName() + " is already adopted", "Can't Adopt", JOptionPane.WARNING_MESSAGE);
				} else {
					selectedPet.setAdopted(true);
					// Adopted pet message. 
					view.showMessage(selectedPet.getName() + " has been adopted!", "Pet Adopted", JOptionPane.INFORMATION_MESSAGE);
					updateView();
				}
			}
		} else {
			// Pet not selected message
			view.showMessage("Please select a pet to add", "Selection Required", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	private void removePetButtonPressed() {
		// Get selected pet
		int selectedIndex = view.getSelectedPetIndex();
		if (selectedIndex >= 0) {
			List<T> petsInStockList = (List<T>) getSortedInStockPets();
			// Check in range
			if (selectedIndex < petsInStockList.size()) {
				T selectedPet = petsInStockList.get(selectedIndex);
				
				// Remove from stock
				if (selectedPet.isAdopted()) {
					// Cannot remove message
					view.showMessage(selectedPet.getName() + " cannot be removed because they awaiting a home..", "Removal Failure", JOptionPane.WARNING_MESSAGE);
				} else {
					boolean removed = shelter.removePet(selectedPet);
					
					if (removed) {
						// Success message
						view.showMessage(selectedPet.getName() + " has been removed from the shelter :(", "Pet Removed", JOptionPane.INFORMATION_MESSAGE);
					} else {
						// Failure message
						view.showMessage(selectedPet.getName() + " could not be removed.", "Removal Failure", JOptionPane.ERROR_MESSAGE);
					}
				}
				updateView();
			}
		} else {
			// Pet not selected message
			view.showMessage("Please select a pet to add", "Selection Required", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void viewDetailsButtonPressed() {
		// Get selected pet
		int selectedIndex = view.getSelectedPetIndex();
		if (selectedIndex >= 0) {
			List<T> petsInStockList = (List<T>) getSortedInStockPets();
			// Check in range
			if (selectedIndex < petsInStockList.size()) {
				T selectedPet = petsInStockList.get(selectedIndex);
				
				// Details
				String[] petDetails = {
					selectedPet.getName(),
					selectedPet.getSpecies(),
					String.valueOf(selectedPet.getAge()),
					selectedPet.getType(),
					selectedPet.isAdopted() ? "Adopted" : "Available"
				};
				
				view.petDetailsDialog(petDetails);
			}
		} else {
			// Pet not selected message
			view.showMessage("Please select a pet to add", "Selection Required", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void saveButtonPressed() {
		// Get adopted pets
		Set<T> adoptedPets = new HashSet<T>();
		for (T pet : shelter.getPetsInStock()) {
			adoptedPets.add(pet);
		}
		jsonHandler.savePetList(adoptedPets);
		
		// File saved message
		view.showMessage("Adopted pets have been saved!", "Saved!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void sortSelectionPressed() {
		String sortOptionSelected = view.getSelectedSortOption();
		
		switch (sortOptionSelected) {
			case "Name":
				currentFilter = null;
				break;
			case "Age":
				currentFilter = (Comparator<T>) new SortByAge<T>();
				break;
			case "Species":
				currentFilter = (Comparator<T>) new SortBySpecies<T>();
				break;
			default:
				currentFilter = null;
		}
		
		updateView();
	}
	
	private void loadPetsFromFiles() {
		shelter.setPetsInStock((Set<T>) jsonHandler.loadpets());
		shelter.setImportablePets(importExoticPets(jsonHandler.loadexoticanimals()));
	}
	
	private List<T> getSortedInStockPets() {
		// Get pets from shelter
        Set<T> petsInStock = shelter.getPetsInStock();
        // Change to List for sorting
        List<T> petsList = new ArrayList<>(petsInStock); 
        
        if (currentFilter != null) {
            petsList.sort(currentFilter);
        } else {
            // Use natural ordering (Comparable implementation) if no comparator is set
            Collections.sort(petsList);
        }
        
        return petsList;
	}
	
	private String[][] convertStockToTableData() {
		List<T> petsList = getSortedInStockPets();
        
        // Convert to table data format
        String[][] tableData = new String[petsList.size()][4];
        
        for (int i = 0; i < petsList.size(); i++) {
            T pet = petsList.get(i);
            tableData[i][0] = pet.getName();
            tableData[i][1] = pet.getSpecies();
            tableData[i][2] = String.valueOf(pet.getAge());
            tableData[i][3] = pet.isAdopted() ? "Adopted" : "Available";
        }
        
        return tableData;
    }
	
	private List<T> getSortedImportablePets() {
		// Get pets from shelter
        Set<T> importableAnimals = shelter.getPetsInStock();
        // Change to List for sorting
        List<T> exoAniList = new ArrayList<>(importableAnimals); 
        
        if (currentFilter != null) {
        	exoAniList.sort(currentFilter);
        } else {
            // Use natural ordering (Comparable implementation) if no comparator is set
            Collections.sort(exoAniList);
        }
        
        return exoAniList;
	}
	
	private String[][] convertImportableToTableData() {
        List<T> exoAniList = getSortedImportablePets();
        
        // Convert to table data format
        String[][] tableData = new String[exoAniList.size()][4];
        
        for (int i = 0; i < exoAniList.size(); i++) {
            T pet = exoAniList.get(i);
            tableData[i][0] = pet.getName();
            tableData[i][1] = pet.getSpecies();
            tableData[i][2] = String.valueOf(pet.getAge());
            tableData[i][3] = pet.isAdopted() ? "Adopted" : "Available";
        }
        
        return tableData;
    }
	
	private void updateView() {
		String[][] tableData = convertStockToTableData();
		view.updatePetTable(tableData);
	}

}
