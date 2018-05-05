package com.distinctwords;

import java.util.LinkedHashMap;

/**
 *  
 * The main class to solve the problem provided.
 * 
 * I initially do some validation,  to check if null is used as a argument or an empty string.
 * I also check if an argument of non word character or numbers are used, this is also considered invalid 
 * as per my assumption my focus is on words.
 * 
 * If any of the cases above are true i would return an empty map.
 * 
 * The use of linkedHashMap provided many benefits such as
 * 
 * 1) As with any map, containsKey/get is 0(1) constant time time complexity
 * 2) LinkedHashMap provides the benefits maintaining the order
 * 
 * I split the sentence.
 * 
 * Ensure its not a number or a non letter and remove any possible commas at the end of words
 * for example 'statement,' or  'this.'
 * 
 * Then i proceed to insert them in my map and increase the tally on duplicates
  
 * @author Ahmed
 */
public class DistinctWordInSentence {

	public static LinkedHashMap<String, Integer> listOfWordsWithTally(final String sentence) {

		LinkedHashMap<String, Integer> tallyMap = new LinkedHashMap<String, Integer>();

		if (sentence == null || sentence.isEmpty()
				|| UtilityPattern.invalidSentencePattern.matcher(sentence).matches()) {
			return tallyMap;
		}

		String[] words = UtilityPattern.splitSentence.split(sentence.toLowerCase());

		for (String word : words) {

			if (UtilityPattern.numberOrNonletterPattern.matcher(word).matches()) {
				continue;
			}

			String removedPunctuation = filterPunctuationAtEndOfWord(word);

			if (tallyMap.containsKey(removedPunctuation)) {
				Integer currentTally = tallyMap.get(removedPunctuation);
				tallyMap.put(removedPunctuation, currentTally += 1);
			} else {
				tallyMap.put(removedPunctuation, 1);
			}
		}

		return tallyMap;
	}

	private static String filterPunctuationAtEndOfWord(String word) {
		return UtilityPattern.punctuationAtTheEndOfString.matcher(word).replaceAll("");
	}
}
