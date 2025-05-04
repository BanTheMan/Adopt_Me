package edu.mu.adopt.utility;

import java.util.Comparator;

import edu.mu.adopt.model.Pet;

/**
 * Author: Ivan Rhodes
 * Class for sorting by age.
 * @param <T>
 */
public class SortByAge<T extends Pet> implements Comparator<T>{

	/**
	 * @param o1 Pet being compared/sorted by age.
	 * @param o2 Pet being compared to
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
