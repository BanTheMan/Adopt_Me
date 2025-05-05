package edu.mu.adopt.model;

/**
 * Adapter to wrap the ExoticAnimal class for compatibility with Pet in Controller
 */
public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	/**
	 * @param exoticAnimal
	 * Adapt exotic animal to pet 
	 */
	public ExoticAnimalAdapter(ExoticAnimal exoAni) {
		super(exoAni.getUniqueId(),
				exoAni.getAnimalName(),
				exoAni.getCategory(),
				exoAni.getSubSpecies(),
				exoAni.getYearsOld(),
				false);
		this.exoticAnimal = exoAni;
	}
	
	/**
	 *set pet and exotic animal ID
	 */
	@Override
		public void setId(String id) {
			super.setId(id);
			if (this.exoticAnimal != null) {
				this.exoticAnimal.setUniqueId(id);
			}

		}
	
	/**
	 * Get and return animal ID
	 */
	@Override
	public String getId() {
		return this.exoticAnimal != null ? this.exoticAnimal.getUniqueId() : super.getId();
	}
	
	/**
	 *Set pet and exotic animal name
	 */
	@Override
		public void setName(String name) {
			super.setName(name);
			if (this.exoticAnimal != null) {
				this.exoticAnimal.setAnimalName(name);
			}
		}
	
	/**
	 *get animal name
	 */
	@Override
	public String getName() {
		return this.exoticAnimal != null ? this.exoticAnimal.getAnimalName() : super.getName();
	}
	
	/**
	 *Set pet and exotic animal type
	 */
	@Override
		public void setType(String type) {
			super.setType(type);
			if (this.exoticAnimal != null) {
				this.exoticAnimal.setCategory(type);
			}
		}
	
	/**
	 * gets animal type/category
	 */
	@Override
	public String getType() {
		return this.exoticAnimal != null ? this.exoticAnimal.getCategory() : super.getType();
	}
	
	/**
	 *Set pet and exotic animal species
	 */
	@Override
		public void setSpecies(String species) {
			super.setSpecies(species);
			if (this.exoticAnimal != null) {
				this.exoticAnimal.setSubSpecies(species);
			}
		}
	
	/**
	 *returns animal species
	 */
	@Override
	public String getSpecies() {
		return this.exoticAnimal != null ? this.exoticAnimal.getSubSpecies() : super.getSpecies();
	}
	
	/**
	 * sets the pet and exotic animal age
	 */
	@Override
		public void setAge(Integer age) {
			super.setAge(age);
			if (this.exoticAnimal != null) {
				this.exoticAnimal.setYearsOld(age);
			}
		}
	
	/**
	 * returns the age of the animal
	 */
	@Override
	public Integer getAge() {
		return this.exoticAnimal != null ? this.exoticAnimal.getYearsOld() : super.getAge();
	}
	
	/**
	 *Sets animal to adopted
	 */
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
	}
	
	/**
	 * returns true or false based on adoption status
	 */
	@Override
	public boolean isAdopted() {
		return super.isAdopted();
	}
	

	
}
