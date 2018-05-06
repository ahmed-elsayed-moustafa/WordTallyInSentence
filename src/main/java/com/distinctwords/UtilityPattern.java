package com.distinctwords;

import java.util.regex.Pattern;

/**
 * 
 * Precompiled patterns, to ensure the compilation occurs only once.
 * @author Ahmed
 */
public class UtilityPattern {

	private final static Pattern invalidSentencePattern = Pattern.compile("(\\s*[\\W\\d]*\\s*)*");
	
	private final static Pattern numberOrNonletterPattern = Pattern.compile("[\\W\\d]+");
	
	private final static Pattern splitSentence = Pattern.compile("\\s+");
	
	private final static Pattern punctuationAtTheEndOfString = Pattern.compile("[\\W]$");
	
	public static String[] splitWordsWithPattern(String sentence) {
		return splitSentence.split(sentence);
	}
	
	public static boolean checkStringIsValid(String sentence) {
		return invalidSentencePattern.matcher(sentence).matches();
	}
	
	public static String removePunctuationAtTheEnd(String word) {
		return punctuationAtTheEndOfString.matcher(word).replaceAll("");
	}
	
	public static boolean checkIfNumberOrNonLetter(String word) {
		return numberOrNonletterPattern.matcher(word).matches();
	}
}
