package edu.mu.adopt.utility;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.model.Pet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;


/**
 * Class for loading and saving JSON files
 */
/**
 * @param <T>
 */
public class HandleJSON<T extends Pet> {
	
	private static final String PET_FILE = "src/main/resources/pets.json";
	private static final String EXOTIC_FILE = "src/main/resources/exotic_animals.json";

	/**
	 * @return Pets in file.
	 */
	public Set<Pet> loadpets() {
		return loadFromJson(PET_FILE, new TypeToken <Set<Pet>>() {}.getType());
	}
	
	/**
	 * @return Exotic pets in file.
	 */
	public Set<ExoticAnimal> loadexoticanimals() {
		return loadFromJson(EXOTIC_FILE, new TypeToken <Set<ExoticAnimal>>() {}.getType());
	}
	
	/**
	 * @param <T>
	 * @param filePath
	 * @param type
	 * @return Pets from Json files, which depends on the file path passed in.
	 */
	private <T> Set<T> loadFromJson(String filePath, Type type) {
		try(FileReader reader = new FileReader(filePath))
		{
			return new Gson().fromJson(reader, type);
		}
		catch (Exception e) {
			throw new RuntimeException("Error loading file: " + filePath, e);
		}
	}
	
	/**
	 * @param set 
	 * Pet list passed in, saved to a time-stamped Json file.
	 */
	public void saveToJson(Set <T> set) {
		Gson gson = new Gson();
		String json = gson.toJson(set);
		String time = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_").format(LocalDateTime.now());
		String filename = "saved_" + time + "pets.json";
		
		try(FileWriter writer = new FileWriter(filename)) {
			new Gson().toJson(set, writer);
			System.out.println("Saved to file: " + filename);
		}
		catch (IOException e) {
			System.err.println("Failed to save to JSON: " + e.getMessage());
		}
	}
	
	/**
	 * @param pets
	 * Calls save method to save the set of passed in pets.
	 */
	public void savePetList(Set <T> pets) {
		saveToJson(pets);
	}
}
