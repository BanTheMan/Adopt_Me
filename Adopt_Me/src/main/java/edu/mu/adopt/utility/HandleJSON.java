package edu.mu.adopt.utility;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;
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
	
	public static List<Pet> loadpet() {
		return loadFromJson("pets.json", new TypeToken <List<Pet>>() {}.getType());
	}
	
	public static List<ExoticAnimal> loadexoticanimal() {
		return loadFromJson("exotic_animals.json", new TypeToken <List<ExoticAnimal>>() {}.getType());
	}
	
	private static <T> List<T> loadFromJson(String fileName, Type type) {
		try(InputStream is = HandleJSON.class.getClassLoader().getResourceAsStream(fileName);
				InputStreamReader reader = new InputStreamReader(is)) 
		{
			return new Gson().fromJson(reader, type);
		}
		catch (Exception e) {
			throw new RuntimeException("Error laoding file: " + fileName, e);
		}
	}
	
	private static <T> void saveToJson(List <T> list, String base) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		String time = DateTimeFormatter.ofPattern("YYYYMMDD_HHMMSS_").format(LocalDateTime.now());
		String filename = time + " " + base + ".json";
		
		try(FileWriter writer = new FileWriter(filename)) {
			writer.write(json);
			System.out.println("Saved to file: " + filename);
		}
		catch (IOException e) {
			System.err.println("Failed to save to JSON");
		}
	}
	
	private static void savePetList(List <Pet> pets) {
		saveToJson(pets, "pets");
	}
}
