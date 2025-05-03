package edu.mu.adopt.utility;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.model.Pet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Class for loading and saving JSON files
 */
public class HandleJSON {
	
	public Set<Pet> loadpets() {
		return loadFromJson("pets.json", new TypeToken <Set<Pet>>() {}.getType());
	}
	
	public Set<ExoticAnimal> loadexoticanimals() {
		return loadFromJson("exotic_animals.json", new TypeToken <Set<ExoticAnimal>>() {}.getType());
	}
	
	private <T> Set<T> loadFromJson(String fileName, Type type) {
		try(InputStream is = HandleJSON.class.getClassLoader().getResourceAsStream(fileName);
				InputStreamReader reader = new InputStreamReader(is)) 
		{
			return new Gson().fromJson(reader, type);
		}
		catch (Exception e) {
			throw new RuntimeException("Error laoding file: " + fileName, e);
		}
	}
	
	private <T> void saveToJson(Set <T> set, String base) {
		Gson gson = new Gson();
		String json = gson.toJson(set);
		String time = DateTimeFormatter.ofPattern("yyyyMMDD_HHMMSS_").format(LocalDateTime.now());
		String filename = time + "_" + base + ".json";
		
		try(FileWriter writer = new FileWriter(filename)) {
			writer.write(json);
			System.out.println("Saved to file: " + filename);
		}
		catch (IOException e) {
			System.err.println("Failed to save to JSON");
		}
	}
	
	public void savePetList(Set <Pet> pets) {
		saveToJson(pets, "pets");
	}
}
