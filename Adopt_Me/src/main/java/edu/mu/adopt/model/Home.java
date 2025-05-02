package edu.mu.adopt.model;

import java.util.HashSet;
import java.util.Set;

public class Home<T extends Pet> {

	private Set<T> adoptedPets;
	
	public Home() {
		this.adoptedPets = new HashSet<>();
	}

	public Set<T> getAdoptedPets() {
		return adoptedPets;
	}

	public void setAdoptedPets(Set<T> unadoptablePets) {
		this.adoptedPets = unadoptablePets;
	}	
	
	public void addAdoptedPet(T pet) {
		adoptedPets.add(pet);
	}
	
	public boolean isAdopted(T pet) {
		if (adoptedPets.contains(pet)) {
			return true;
		}
		return false;
	}
	
}
