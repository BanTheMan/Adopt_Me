package edu.mu.adopt.model;

/**
 * MVC Model
 */
public class ExoticAnimal {
	
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private Integer yearsOld;
    
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

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public Integer getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(Integer yearsOld) {
		this.yearsOld = yearsOld;
	}

}
