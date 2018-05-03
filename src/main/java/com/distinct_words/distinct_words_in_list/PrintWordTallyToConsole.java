package com.distinct_words.distinct_words_in_list;

import java.util.Map;

public class PrintWordTallyToConsole {
	
	public static String DIVIDER =" - ";

	public static void printWordTally(Map<String , Integer> tallyMap) {
		for(String word: tallyMap.keySet()) {
			 System.out.println(word + DIVIDER + tallyMap.get(word));
		}
		
		System.out.println();
	}
}
