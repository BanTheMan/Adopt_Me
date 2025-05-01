package edu.mu.adopt.utility;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;

import edu.mu.adopt.model.ExoticAnimal;
import edu.mu.adopt.model.Pet;
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
}
