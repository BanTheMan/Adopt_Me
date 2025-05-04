package edu.mu.adopt.model;

/**
 * Adapter to wrap the ExoticAnimal class for compatibility with Pet in Controller
 */
public class ExoticAnimalAdapter<T extends Pet> extends Pet {
	
	private ExoticAnimal exoticAnimal;

	/**
	 * @param exoticAnimal
	 * Adapt exotic animal to pet 
	 */
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getUniqueId(),
				exoticAnimal.getAnimalName(),
				exoticAnimal.getCategory(),
				exoticAnimal.getSubSpecies(),
				exoticAnimal.getYearsOld(),
				false);
		this.exoticAnimal = exoticAnimal;
	}
	
	/**
	 *set pet and exotic animal ID
	 */
	@Override
		public void setId(String id) {
			super.setId(id);
			this.exoticAnimal.setUniqueId(id);
		}
	
	/**
	 * Get and return animal ID
	 */
	@Override
	public String getId() {
		return this.exoticAnimal.getUniqueId();
	}
	
	/**
	 *Set pet and exotic animal name
	 */
	@Override
		public void setName(String name) {
			super.setName(name);
			this.exoticAnimal.setAnimalName(name);
		}
	
	/**
	 *get animal name
	 */
	@Override
	public String getName() {
		return this.exoticAnimal.getAnimalName();
	}
	
	/**
	 *Set pet and exotic animal type
	 */
	@Override
		public void setType(String type) {
			super.setType(type);
			this.exoticAnimal.setCategory(type);
		}
	
	/**
	 * gets animal type/category
	 */
	@Override
	public String getType() {
		return this.exoticAnimal.getCategory();
	}
	
	/**
	 *Set pet and exotic animal species
	 */
	@Override
		public void setSpecies(String species) {
			super.setSpecies(species);
			this.exoticAnimal.setSubSpecies(species);
		}
	
	/**
	 *returns animal species
	 */
	@Override
	public String getSpecies() {
		return this.exoticAnimal.getSubSpecies();
	}
	
	/**
	 * sets the pet and exotic animal age
	 */
	@Override
		public void setAge(Integer age) {
			super.setAge(age);
			this.exoticAnimal.setYearsOld(age);
		}
	
	/**
	 * returns the age of the animal
	 */
	@Override
	public Integer getAge() {
		return this.exoticAnimal.getYearsOld();
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
