package com.distinct_words.distinct_words_in_list;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class DistinctWordInSentence {

	private static Pattern invalidSentencePattern = Pattern.compile("(\\s*[\\W\\d]*\\s*)*");
	private static Pattern numberOrNonletterPattern = Pattern.compile("[\\W\\d]+");

	public static LinkedHashMap<String, Integer> listOfWordsWithTally(final String sentence) {
		return listOfWordsWithTally(new LinkedHashMap<String, Integer>(), sentence);
	}

	private static LinkedHashMap<String, Integer> listOfWordsWithTally(LinkedHashMap<String, Integer> tallyMap,
			String sentence) {

		if (sentence == null || sentence.isEmpty()) {
			return tallyMap;
		}

		if (invalidSentencePattern.matcher(sentence).matches()) {
			return tallyMap;
		}

		String[] words = sentence.toLowerCase().split("\\s+");

		for (String word : words) {

			if (numberOrNonletterPattern.matcher(word).matches()) {
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
		return word.replaceAll("[\\W]$", "");
	}
}
