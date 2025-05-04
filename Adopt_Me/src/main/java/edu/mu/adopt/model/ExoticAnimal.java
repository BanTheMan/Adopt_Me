package edu.mu.adopt.model;

/**
 * MVC Model
 * Author: Brandon Gomes
 */
/**
 * Class for exotic animals
 */
public class ExoticAnimal {
	
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private Integer yearsOld;
    
    /**
     * @param uniqueId
     * @param animalName
     * @param category
     * @param subSpecies
     * @param yearsOld
     * Initialize a animal
     */
    public ExoticAnimal(String uniqueId,
    				String animalName,
    				String category,
    				String subSpecies,
    				Integer yearsOld) {
		setUniqueId(uniqueId);
		setAnimalName(animalName);
		setCategory(category);
		setSubSpecies(subSpecies);
		setYearsOld(yearsOld);
	}

	/**
	 * @return animal ID
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId
	 * Set ID for exotic animal
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return animals name
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * @param animalName
	 * Set animals name
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * @return animal category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 * Set animals category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return animals sub-species
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * @param subSpecies
	 * Sets sub-species
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * @return age of animal
	 */
	public Integer getYearsOld() {
		return yearsOld;
	}

	/**
	 * @param yearsOld
	 * Sets the age of the animal.
	 */
	public void setYearsOld(Integer yearsOld) {
		this.yearsOld = yearsOld;
	}

}
