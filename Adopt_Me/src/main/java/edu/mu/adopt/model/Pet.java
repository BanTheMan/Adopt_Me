package edu.mu.adopt.model;

import java.util.Objects;

/**
 * MVC Model
 * Author: Brandon Gomes
 */
public abstract class Pet implements Comparable<Pet> {
	
    private String id;
    private String name;
    private String type;
    private String species;
    private Integer age;
    private boolean adopted;
    
    /**
     * @param id
     * @param name
     * @param type
     * @param species
     * @param age
     * @param adopted
     * Initialize pet 
     */
    public Pet(String id,
    		String name,
    		String type,
    		String species,
    		Integer age,
    		boolean adopted) {
    	setId(id);
    	setName(name);
    	setType(type);
    	setSpecies(species);
    	setAge(age);
    	setAdopted(adopted);
	}
    
    /**
     * @return pet ID
     */
    public String getId() {
		return id;
	}

	/**
	 * @param id
	 * Set pet ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return pet name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * Set pet name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return pet type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * Set pet type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return pet species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species
	 * Set pet species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return pet age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 * Set pet age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return adopted
	 * returns adopted status
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * @param adopted
	 * Sets pet to adopted
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	/**
	 * @return Pet details
	 * Returns a string containing all the details of the pet
	 */
	public String viewDetails() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}
	
	/**
	 *Compare name of pet
	 */
	@Override
	public int compareTo(Pet pet) {
		// Compare name
		return this.getName().compareTo(pet.getName());
	}

	/**
	 *Returns a string contain the name, age, and type of the pet
	 */
	@Override
	public String toString() {
		return getName() + ": " + getAge().toString() + " year old " + getType();
	}
	
	/**
	 *Checks if pet ID matches another ID.
	 */
	@Override
	public boolean equals(Object obj) {
		Pet pet = (Pet) obj;
		if (this.id.equals(pet.getId())) {
			return true;
		}
		return false;
	}
	
	/**
	 *Generates a hash code based on ID
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
}
