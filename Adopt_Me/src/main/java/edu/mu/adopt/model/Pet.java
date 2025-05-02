package edu.mu.adopt.model;

import java.util.Objects;

/**
 * MVC Model
 */
public abstract class Pet implements Comparable<Pet> {
	
    private String id;
    private String name;
    private String type;
    private String species;
    private Integer age;
    private boolean adopted;
    
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
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	public String viewDetails() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}
	
	@Override
	public int compareTo(Pet pet) {
		// Compare name
		return this.getName().compareTo(pet.getName());
	}

	@Override
	public String toString() {
		return getName() + ": " + getAge().toString() + " year old " + getType();
	}
	
	@Override
	public boolean equals(Object obj) {
		Pet pet = (Pet) obj;
		if (this.id.equals(pet.getId())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
}
