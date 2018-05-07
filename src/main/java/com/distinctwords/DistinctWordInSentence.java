package com.distinctwords;

import java.util.LinkedHashMap;

/**
 * 
 * The main class to solve the problem provided.
 * 
 * I initially do some validation, to check if null is used as a argument or an
 * empty string. I also check if an argument of non word character or numbers
 * are used, this is also considered invalid as per my assumption my focus is on
 * words.
 * 
 * If any of the cases above are true i would return an empty map.
 * 
 * The use of linkedHashMap provided many benefits such as
 * 
 * 1) As with any map, containsKey/get is 0(1) constant time time complexity 2)
 * LinkedHashMap provides the benefits maintaining the order
 * 
 * I split the sentence.
 * 
 * Ensure its not a number or a non letter and remove any possible commas at the
 * end of words for example 'statement,' or 'this.'
 * 
 * Then i proceed to insert them in my map and increase the tally on duplicates
 * 
 * @author Ahmed
 */
public class DistinctWordInSentence {

	/**
	 * If the string passed is not null and is valid then process tally.
	 * 
	 * @param sentence
	 * @return
	 */
	public static LinkedHashMap<String, Integer> validateSentanceAndTally(final String sentence) {

		if (sentence == null || sentence.isEmpty()
				|| UtilityPattern.checkStringIsValid(sentence)) {
			return new LinkedHashMap<String, Integer>();
		}
		
		return createTally(sentence);
	}

	/**
	 * if sentence is valid, process tally by initially splitting the sentence and
	 * using the map datastructure to collect the tally
	 * 
	 * @param sentence
	 * @return
	 */
	private static LinkedHashMap<String, Integer> createTally(final String sentence) {
		
		String[] words = UtilityPattern.splitWordsWithPattern(sentence.toLowerCase());
	
		return createTallyMap(words);
	}
	
	/**
	 * Process tally , words array is used to tally the words.
	 * Increase tally on duplicates.
	 * 
	 * @param words
	 * @return
	 */
	private static LinkedHashMap<String, Integer> createTallyMap(String[] words) {
		
		LinkedHashMap<String, Integer> tallyMap = new LinkedHashMap<String, Integer>();
		
		for (String word : words) {

			if (UtilityPattern.checkIfNumberOrNonLetter(word)) {
				continue;
			}

			String removedPunctuation = filterPunctuationAtEndOfWord(word);

			if (tallyMap.containsKey(removedPunctuation)) {
				Integer currentTally = tallyMap.get(removedPunctuation);
				tallyMap.put(removedPunctuation, ++currentTally);
			} else {
				tallyMap.put(removedPunctuation, 1);
			}
		}
		
		return tallyMap;
	}

	/**
     * Ensure at the end of the word is not a non letter for example 'statement,' or 'this.'
	 * 
	 * @param word
	 * @return
	 */
	private static String filterPunctuationAtEndOfWord(String word) {
		return UtilityPattern.removePunctuationAtTheEnd(word);
	}
}
