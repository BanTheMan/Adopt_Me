package edu.mu.adopt.model;

/**
 * MVC Model.
 * Author: Brandon Gomes.
 * Class for exotic animals
 */
public class ExoticAnimal {
	
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private Integer yearsOld;
    
    /**
     * Initialize an animal
     * @param uniqueId = id
     * @param animalName = name
     * @param category = type of animal
     * @param subSpecies = species of animal
     * @param yearsOld = age
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
	 * retrieve animal ID
	 * @return animal ID
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Set ID for exotic animal
	 * @param uniqueId = id
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Retrieve animal name
	 * @return animals name
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Set animals name
	 * @param animalName = name
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * Retrieve animal's category
	 * @return animal category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set animal's category
	 * @param category = type of animal
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Retrieve animal sub-species
	 * @return animals sub-species
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	@Override
	public String toString() {
		return getAnimalName() + ": " + getYearsOld().toString() + " year old " + getCategory();
	}

	/**
	 * Sets sub-species
	 * @param subSpecies = species of animal
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * Retrieve age of animal
	 * @return age of animal
	 */
	public Integer getYearsOld() {
		return yearsOld;
	}

	/**
	 * Sets the age of the animal.
	 * @param yearsOld = age
	 */
	public void setYearsOld(Integer yearsOld) {
		this.yearsOld = yearsOld;
	}

}
