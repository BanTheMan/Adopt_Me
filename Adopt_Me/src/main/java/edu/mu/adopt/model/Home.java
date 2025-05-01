package edu.mu.adopt.model;

import java.util.ArrayList;
import java.util.List;

public class Home<T extends Pet> {

	private List<T> unadoptablePets;
	
	public Home() {
		this.unadoptablePets = new ArrayList<>();
	}

	public List<T> getUnadoptablePets() {
		return unadoptablePets;
	}

	public void setUnadoptablePets(List<T> unadoptablePets) {
		this.unadoptablePets = unadoptablePets;
	}	
	
}
