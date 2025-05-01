package edu.mu.adopt.model;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC Container Model
 */
public class Shelter<T extends Pet> {
	
	private List<T> adoptablePets;
	private List<T> unadoptablePets;
	
	public Shelter() {
		this.adoptablePets = new ArrayList<>();
	}
	
	public List<T> getAdoptablePets() {
		return adoptablePets;
	}

	public void setAdoptablePets(List<T> adoptablePets) {
		this.adoptablePets = adoptablePets;
	}

	public List<T> getUnadoptablePets() {
		return unadoptablePets;
	}

	public void setUnadoptablePets(List<T> unadoptablePets) {
		this.unadoptablePets = unadoptablePets;
	}
	
	public void addPet(T pet) {
		
	}
	
	public boolean removePet(Integer id) {
		return false;
	}
	
	public void getDetails() { // toString?
		
	}

	public void adoptPet(T pet) {
		
	}
	
	public void importExoticPet(T pet) {
		
	}

}
