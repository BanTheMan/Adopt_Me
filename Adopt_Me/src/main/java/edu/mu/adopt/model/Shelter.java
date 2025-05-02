package edu.mu.adopt.model;

import java.util.HashSet;
import java.util.Set;


/**
 * MVC Container Model
 */
public class Shelter<T extends Pet> {
	
	private Set<T> inStock;
	private Set<T> importable;
	
	public Shelter() {
		this.inStock = new HashSet<T>();
		this.importable = new HashSet<T>();
	}
	
	public Set<T> getPetsInStock() {
		return inStock;
	}

	public void setPetsInStock(Set<T> adoptablePets) {
		this.inStock = adoptablePets;
	}

	public Set<T> getImportablePets() {
		return importable;
	}

	public void setImportablePets(Set<T> unadoptablePets) {
		this.importable = unadoptablePets;
	}
	
//	public T getPetInStock(T pet) {
//		for (T petInStock : inStock) {
//			if (petInStock.equals(pet)) {
//				return petInStock;
//			}
//		}
//		return null;
//	}
	
	public void addPetToStock(T pet) {
		this.inStock.add(pet);
	}
	
	public void removePetFromStock(T badPet) {
		for (T pet : inStock) {
			if (pet.equals(badPet)) {
				inStock.remove(badPet);
			}
		}
	}
	
//	public T getImportablePet(T pet) {
//		for (T importable : importable) {
//			if (importable.equals(pet)) {
//				return importable;
//			}
//		}
//		return null;
//	}
	
	public void addImportablePet(T pet) {
		this.importable.add(pet);
	}
	
	public void removeImportablePet(T pet) {
		for (T terriblePet : importable) {
			if (terriblePet.equals(pet)) {
				importable.remove(terriblePet);
			}
		}
	}
	
	public boolean isInStock(T pet) {
		if (inStock.contains(pet)) {
			return true;
		}
		return false;
	}
	
	public boolean isImportable(T pet) {
		if (importable.contains(pet)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Add pet into stock from importable set
	 * @param redeemedPet
	 */
	public void addPet(T redeemedPet) {
		// If pet is importable, add to stock
		if (isImportable(redeemedPet)) {
			removeImportablePet(redeemedPet);
			addPetToStock(redeemedPet);
		}
		// TODO: add fail message: Pet is not importable
	}
	
	public boolean removePet(T badPet) {
		if (isInStock(badPet)) {
			removePetFromStock(badPet);
			addImportablePet(badPet);
		}
		// TODO: add fail message: Pet not in stock or not in shelter
		return false;
	}

}
