package edu.mu.adopt.controller;

import edu.mu.adopt.model.Home;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.view.AdoptionView;

public class AdoptionController {
	
	private Shelter shelter;
	private Home home;
	private AdoptionView view;
	
	public AdoptionController() {
		this.shelter = new Shelter<>();
		this.view = new AdoptionView();
		this.home = new Home<Pet>();
	}
	
	public <T extends Pet> void addButtonPressed(T pet) {
		
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

}
