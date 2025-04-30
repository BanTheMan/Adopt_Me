package edu.mu.adopt.model;

/**
 * MVC Model
 */
public abstract class Pet implements Comparable<Pet> {
	
    private Integer id;
    private String name;
    private String type;
    private String species;
    private Integer age;
    private boolean adopted;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	@Override
	public int compareTo(Pet o) {
		// Compare name
		return 0;
	}
}
