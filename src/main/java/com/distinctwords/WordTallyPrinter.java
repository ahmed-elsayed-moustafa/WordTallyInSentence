package com.distinctwords;

import java.util.Map;

public class WordTallyPrinter {
	
	private final static String DIVIDER =" - ";

	public static void printWordTally(Map<String , Integer> tallyMap) {
		for(String word: tallyMap.keySet()) {
			 System.out.println(word + DIVIDER + tallyMap.get(word));
		}
		
		System.out.println();
	}
}
