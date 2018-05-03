package com.distinctwords;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Unit test for simple DistinctWordsInList.
 * 
 *   Test 1 - normal sentence
	 Test 2 - empty string
	 Test 3 - null
	 Test 4 - no words but just commas and other punctuation
	 Test 5 - numbers
	 Test 6 - same words mixed with capitals
 * 
 * 
 * 
 */
public class DistinctWordInSentenceTest 
    extends TestCase
{
	
	@Test
	public void testingNormalSentence() {
		String testString =  "This is a statement, and so is this.";
		Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
		WordTallyPrinter.printWordTally(tallyMap);
		
		assertEquals(6, tallyMap.size());
		
		assertEquals(2, tallyMap.get("this"));
		assertEquals(2, tallyMap.get("is"));
		assertEquals(1, tallyMap.get("a"));
		assertEquals(1, tallyMap.get("statement"));
		assertEquals(1, tallyMap.get("and"));
		assertEquals(1, tallyMap.get("so"));
		
		//to ensure the words are in the correct order
		List<String> keys = (List<String>) tallyMap.keySet().stream().collect(Collectors.toList());
		
		assertEquals(keys.get(0), "this");
		assertEquals(keys.get(1), "is");
		assertEquals(keys.get(2), "a");
		assertEquals(keys.get(3), "statement");
		assertEquals(keys.get(4), "and");
		assertEquals(keys.get(5), "so");
	}
	
	
	@Test
	public void testingEmptyString() {
		String testString =  "";
		Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
		WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(0, tallyMap.size());
	}
	
	@Test
	public void testingNullString() {
		String testString =  null;
        Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
        WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(0, tallyMap.size());
	}
	
	@Test
	public void testingPunctuationString() {
		String testString =  ", . , @ & ^ * .";
        Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
        WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(0, tallyMap.size());
	}
	
	@Test
	public void testingNumbersString() {
		String testString =  "333 6 7 2 9 3 1 1";
        Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
        WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(0, tallyMap.size());
	}
	
	@Test
	public void testingNumbersAndWordsInString() {
		String testString =  "i'm  100 years Old";
        Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
		
        WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(3, tallyMap.size());
		
		assertEquals(1, tallyMap.get("i'm"));
		assertEquals(1, tallyMap.get("years"));
		assertEquals(1, tallyMap.get("old"));
		
		//to ensure the words are in the correct order
		List<String> keys = (List<String>) tallyMap.keySet().stream().collect(Collectors.toList());
		
		assertEquals(keys.get(0), "i'm");
		assertEquals(keys.get(1), "years");
		assertEquals(keys.get(2), "old");
	}
	
	@Test
	public void testingWordsMixedWithCapitalString() {
		String testString =  "TeSt AbNoRmAl test String As InPut, To Prove The Logic";
		Map tallyMap = DistinctWordInSentence.listOfWordsWithTally(testString);
			
		WordTallyPrinter.printWordTally(tallyMap);
		assertEquals(9, tallyMap.size());
		
		assertEquals(2, tallyMap.get("test"));
		assertEquals(1, tallyMap.get("abnormal"));
		assertEquals(1, tallyMap.get("string"));
		assertEquals(1, tallyMap.get("as"));
		assertEquals(1, tallyMap.get("input"));
		assertEquals(1, tallyMap.get("to"));
		assertEquals(1, tallyMap.get("prove"));
		assertEquals(1, tallyMap.get("the"));
		assertEquals(1, tallyMap.get("logic"));
		
		
		//to ensure the words are in the correct order
		List<String> keys = (List<String>) tallyMap.keySet().stream().collect(Collectors.toList());
		
		assertEquals(keys.get(0), "test");
		assertEquals(keys.get(1), "abnormal");
		assertEquals(keys.get(2), "string");
		assertEquals(keys.get(3), "as");
		assertEquals(keys.get(4), "input");
		assertEquals(keys.get(5), "to");
		assertEquals(keys.get(6), "prove");
		assertEquals(keys.get(7), "the");
		assertEquals(keys.get(8), "logic");
		
	}
		
}
