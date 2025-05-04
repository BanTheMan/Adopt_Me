package edu.mu.adopt.utility;

import java.util.Comparator;

import edu.mu.adopt.model.Pet;

/**
 * Author: Ivan Rhodes
 * @param <T>
 */
public class SortBySpecies<T extends Pet> implements Comparator<T> {

	/**
	 *Compares passed in pets species
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}

}
