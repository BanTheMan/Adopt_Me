package edu.mu.adopt.model;

import java.util.HashSet;
import java.util.Set;


/**
 * MVC Container Model
 * Author: Unsure, put ye name
 */
public class Shelter<T extends Pet> {
	
	private Set<T> inStock;
	private Set<T> importable;
	
	/**
	 * Creates shelter instance
	 */
	public Shelter() {
		this.inStock = new HashSet<T>();
		this.importable = new HashSet<T>();
	}
	
	/**
	 * @return pets in stock
	 */
	public Set<T> getPetsInStock() {
		return inStock;
	}

	/**
	 * @param adoptablePets
	 * Set pets in stock to adoptable
	 */
	public void setPetsInStock(Set<T> adoptablePets) {
		this.inStock = adoptablePets;
	}

	/**
	 * @return importable pets
	 */
	public Set<T> getImportablePets() {
		return importable;
	}

	/**
	 * @param unadoptablePets
	 * Sets Importable pets with unadoptable pets
	 */
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
	
	/**
	 * @param pet
	 * Adds passed in pet to stock
	 */
	public void addPetToStock(T pet) {
		this.inStock.add(pet);
	}
	
	/**
	 * @param badPet
	 * Removes pet from stock
	 */
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
	
	/**
	 * @param pet
	 * adds passed in pet to import set
	 */
	public void addImportablePet(T pet) {
		this.importable.add(pet);
	}
	
	/**
	 * @param pet
	 * Removes pet from importable set
	 */
	public void removeImportablePet(T pet) {
		for (T terriblePet : importable) {
			if (terriblePet.equals(pet)) {
				importable.remove(terriblePet);
			}
		}
	}
	
	/**
	 * @param pet
	 * @return true or false 
	 * Checks if pet is in stock or not
	 */
	public boolean isInStock(T pet) {
		if (inStock.contains(pet)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param pet
	 * @return true or false
	 * Checks if the pet is importable or not
	 */
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
	public boolean addPet(T redeemedPet) {
		// If pet is importable, add to stock
		if (isImportable(redeemedPet)) {
			removeImportablePet(redeemedPet);
			addPetToStock(redeemedPet);
			return true;
		}
		return false;
		// TODO: add fail message: Pet is not importable
	}
	
	/**
	 * @param badPet
	 * @return true or false
	 * removes pet from stock, adds them to the importable set
	 */
	public boolean removePet(T badPet) {
		if (isInStock(badPet)) {
			removePetFromStock(badPet);
			addImportablePet(badPet);
			return true;
		}
		// TODO: add fail message: Pet not in stock or not in shelter
		return false;
	}

}
