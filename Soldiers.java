package com.hcl;

import java.util.ArrayList;

public class Soldiers {

	public static void main(String[] args) {
		
		findBetterPlace(8);

	}
	
	public static ArrayList<Integer> createGroupOfSoldiers(int number) { //First we create a new group of soldiers
		ArrayList<Integer> groupSoldiers = new ArrayList<Integer>();
		
		for(int i = 0; i < number; i++) {
			groupSoldiers.add(i);
		}
		return groupSoldiers;
	} 
	
	public static void findBetterPlace(int numSoldiers) { 
		
		ArrayList<Integer> soldiers = createGroupOfSoldiers(numSoldiers); //New array with the numbers of soldiers
	
		if(soldiers.size() % 2 == 0) ifAreEven(soldiers, true); //If start with even send true
		else ifAreEven(soldiers, false); //If not are even send false.

		
		System.out.println("Best place is " + soldiers);
		
	}
	
	
	/**
	 * 
	 * @param soldiers
	 * @param isEven
	 * @return
	 */
	public static ArrayList<Integer> ifAreEven(ArrayList<Integer> soldiers, boolean isEven ) {
		
		ArrayList<Integer> newGroupOfSoldiers = new ArrayList<>();	//In this array we will save the survivors
		
		int numIterations = 0;
		
		do {
			if(isEven == true) { //If are even 
				for(int i = 0; i < soldiers.size(); i = i + 2) {
				newGroupOfSoldiers.add(soldiers.get(i));
				}
			}else { //If aren't even
				for(int i = 0; i < soldiers.size() -1; i = i + 2) {
					newGroupOfSoldiers.add(soldiers.get(i+1));
					}
			}
			
			numIterations++;
			if(numIterations > 1) { //Only the second time because this will save the size of the last array of soldiers
				if(soldiers.size() % 2 == 0) isEven = true;
				else isEven = false;
			}
		
		System.out.println(soldiers); //Soldiers that are alive.
		
		soldiers.clear();
		newGroupOfSoldiers.forEach((n) -> soldiers.add(n) ) ;;
		newGroupOfSoldiers.clear();
		
		} while(soldiers.size() >= 2);
		
		return soldiers;
	}

}
