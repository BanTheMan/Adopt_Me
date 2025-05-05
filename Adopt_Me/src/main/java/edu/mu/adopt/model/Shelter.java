package edu.mu.adopt.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * MVC Container Model.
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
	 * Set pets in stock to adoptable
	 * @param adoptablePets
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
	 * Sets Importable pets with unadoptable pets
	 * @param unadoptablePets
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
	 * Adds passed in pet to stock
	 * @param pet
	 */
	public void addPetToStock(T pet) {
		this.inStock.add(pet);
	}
	
	/**
	 * Removes pet from stock
	 * @param badPet
	 */
	public void removePetFromStock(T badPet) {
		// This was a pain
		Iterator<T> iterator = inStock.iterator();
	    while (iterator.hasNext()) {
	        T pet = iterator.next();
	        if (pet.equals(badPet)) {
	            iterator.remove();  
	            return;  
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
	 * adds passed in pet to import set
	 * @param pet
	 */
	public void addImportablePet(T pet) {
		this.importable.add(pet);
	}
	
	/**
	 * Removes pet from importable set
	 * @param pet
	 */
	public void removeImportablePet(T pet) {
		// This was a pain 
		Iterator<T> iterator = importable.iterator();
	    while (iterator.hasNext()) {
	        T terriblePet = iterator.next();
	        if (terriblePet.equals(pet)) {
	            iterator.remove(); 
	            return;
	        }
	    }
	}
	
	/**
	 * Checks if pet is in stock or not
	 * @param pet
	 * @return true or false 
	 */
	public boolean isInStock(T pet) {
		if (inStock.contains(pet)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the pet is importable or not
	 * @param pet object being checked
	 * @return true or false
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
	 * removes pet from stock, adds them to the importable set
	 * @param badPet
	 * @return true or false
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
