package com.distinctwords;

import java.util.LinkedHashMap;

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
