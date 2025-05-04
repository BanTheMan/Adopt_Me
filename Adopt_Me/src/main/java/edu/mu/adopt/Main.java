package edu.mu.adopt;

import edu.mu.adopt.controller.AdoptionController;
import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.view.AdoptionView;
import edu.mu.adopt.model.ExoticAnimalAdapter;
import edu.mu.adopt.model.Pet;
import edu.mu.adopt.model.Shelter;
import edu.mu.adopt.utility.HandleJSON;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * Author: Ivan Rhodes
 * Launch program
 */
public class Main {

	/**
	 * Creates instance of the shelter for pets.
	 * Creates new controller
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new AdoptionController<>();
		});
		
	}

}
