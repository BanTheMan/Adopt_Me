package edu.mu.adopt.model;

/**
 * Adapter to wrap the ExoticAnimal class for compatibility with Pet in Controller
 */
public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getUniqueId(),
				exoticAnimal.getAnimalName(),
				exoticAnimal.getCategory(),
				exoticAnimal.getSubSpecies(),
				exoticAnimal.getYearsOld(),
				false);
		this.exoticAnimal = exoticAnimal;
	}
	
	@Override
		public void setId(String id) {
			super.setId(id);
			this.exoticAnimal.setUniqueId(id);
		}
	
	@Override
	public String getId() {
		return this.exoticAnimal.getUniqueId();
	}
	
	@Override
		public void setName(String name) {
			super.setName(name);
			this.exoticAnimal.setAnimalName(name);
		}
	
	@Override
	public String getName() {
		return this.exoticAnimal.getAnimalName();
	}
	
	@Override
		public void setType(String type) {
			super.setType(type);
			this.exoticAnimal.setCategory(type);
		}
	
	@Override
	public String getType() {
		return this.exoticAnimal.getCategory();
	}
	
	@Override
		public void setSpecies(String species) {
			super.setSpecies(species);
			this.exoticAnimal.setSubSpecies(species);
		}
	
	@Override
	public String getSpecies() {
		return this.exoticAnimal.getSubSpecies();
	}
	
	@Override
		public void setAge(Integer age) {
			super.setAge(age);
			this.exoticAnimal.setYearsOld(age);
		}
	
	@Override
	public Integer getAge() {
		return this.exoticAnimal.getYearsOld();
	}
	
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
	}
	
	@Override
	public boolean isAdopted() {
		return super.isAdopted();
	}
	

	
}
