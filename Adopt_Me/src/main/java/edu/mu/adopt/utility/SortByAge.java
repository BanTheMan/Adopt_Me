package edu.mu.adopt.utility;

import java.util.Comparator;

import edu.mu.adopt.model.Pet;

public class SortByAge<T extends Pet> implements Comparator<T>{

	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
