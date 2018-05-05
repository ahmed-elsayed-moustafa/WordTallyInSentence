package com.distinctwords;

import java.util.regex.Pattern;

/**
 * 
 * Precompiled patterns, to ensure the compilation occurs only once.
 * @author Ahmed
 */
public class UtilityPattern {

	public static final Pattern invalidSentencePattern = Pattern.compile("(\\s*[\\W\\d]*\\s*)*");
	
	public static final Pattern numberOrNonletterPattern = Pattern.compile("[\\W\\d]+");
	
	public static final Pattern splitSentence = Pattern.compile("\\s+");
	
	public static final Pattern punctuationAtTheEndOfString = Pattern.compile("[\\W]$");

}
