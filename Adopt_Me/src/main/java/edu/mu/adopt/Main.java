package edu.mu.adopt;

import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.view.AdoptionView;
import edu.mu.adopt.model.ExoticAnimalAdapter;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.utility.HandleJSON;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		AdoptionView.launch();
		
		List<Pet> pets = HandleJSON.loadpet();
		List<ExoticAnimal> epets = HandleJSON.loadexoticanimal();
		
		List<Pet> allpets = new ArrayList<>(pets);
		
		for(ExoticAnimal exotic: epets) 
		{
			allpets.add(new ExoticAnimalAdapter(exotic));
		}
		
		Shelter<Pet> shelter = new Shelter<>();
		for(Pet pet: allpets) 
		{
			shelter.addPet(pet);
		}
		
		
	}

}
