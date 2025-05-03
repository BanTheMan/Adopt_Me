package edu.mu.adopt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.model.ExoticAnimalAdapter;
import edu.mu.adopt.model.Home;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.utility.HandleJSON;
import edu.mu.adopt.view.AdoptionView;

public class AdoptionController <T extends Pet> {
	
	private Shelter<T> shelter;
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
		
		// TODO:
		// Show importable pets in view
		// Get index
		int selectedIndex;
		
		if (selectedIndex >= 0) {
			// Get selected pet
			List<T> importablePetsList = (List<T>) getSortedImportablePets();
			// Check in range
			if (selectedIndex < importablePetsList.size()) {
				// Add pet
				boolean added = shelter.addPet(importablePetsList.get(selectedIndex));
				
				if (added) {
					// TODO: success message
				} else {
					// TODO: failure message
				}
				updateView();
			}
		} else {
			// TODO: pet not selected message
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
		int selectedIndex;
		if (selectedIndex >= 0) {
			List<T> petsInStockList = (List<T>) getSortedInStockPets();
			// Check in range
			if (selectedIndex < petsInStockList.size()) {
				T selectedPet = petsInStockList.get(selectedIndex);
				
				// Check if adopted
				if (selectedPet.isAdopted()) {
					// TODO: pet is already adopted message
				} else {
					selectedPet.setAdopted(true);
					// TODO: adopted pet message. Move to home? 
					updateView();
				}
			}
		} else {
			// TODO: pet not selected message
		}
		
	}
	
	private void removePetButtonPressed() {
		// Get selected pet
		int selectedIndex;
		if (selectedIndex >= 0) {
			List<T> petsInStockList = (List<T>) getSortedInStockPets();
			// Check in range
			if (selectedIndex < petsInStockList.size()) {
				T selectedPet = petsInStockList.get(selectedIndex);
				
				// Remove from stock
				
			}
		}
	}
	
	private void viewDetailsButtonPressed() {
		
	}
	
	private void saveButtonPressed() {
		
	}
	
	private void sortSelectionPressed() {
		
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
            // TODO: Display or move to home?
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
            // TODO: Display or move to home?
            tableData[i][3] = pet.isAdopted() ? "Adopted" : "Available";
        }
        
        return tableData;
    }
	
	private void updateView() {
		
	}

}
