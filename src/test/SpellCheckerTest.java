package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class SpellCheckerTest {
	

	@Test
	void test() {
		//1. Create the object to be tested
	   SpellChecker checker = new SpellChecker();

	   //2. Call the method being tested
	   int words = checker.getNumberOfWords();

	   //3. Use assertions to validate
	   assertEquals(0, words);

	}
     //Word Count increases when a new word is added
	 @Test
	public void testAddWordIncreasesCount() {
		checker.addWord("example");
		assertEquals(6, checker.getWordCount()); // Assuming initial count was 5
	}	


    // Adding duplicate word does not change count
	@Test
	public void testAddDuplicateWordDoesNotIncreaseCount() {
		checker.addWord("Shook");
		checker.addWord("Shook"); // Adding the same word again
		assertEquals(5, checker.getWordCount()); // Count should still be 5
	}
// Properly spelled word
	@Test 
	 public void testCorrectlySpelledWord() {
        assertTrue(checker.isCorrectlySpelled("dog"));
    }
// Improperly spelled word should returns false
	@Test
	public void testIncorrectlySpelledWord() {
		assertFalse(checker.isCorrectlySpelled("dgo"));
	}
	// Spell checker should be case insensitive
	@Test2
	public void testCaseInsensitiveSpellCheck() {
		assertTrue(checker.isCorrectlySpelled("CaT"));
	}

// suggest the closest word to whatever was mispelled 
   @Test
	public void testSuggestClosestWord() {
		String suggestion = checker.suggestClosestWord("bamk");
		assertEquals("bank", suggestion);
	}

	//return original word if already correct
	@Test
	public void testSuggestClosestWordForCorrectWord() {
		String suggestion = checker.suggestClosestWord("bank");
		assertEquals("bank", suggestion);
	}

	//suggest multiple closest words
	@Test
	public void testSuggestMultipleClosestWords() {
		String[] suggestions = checker.suggestClosestWords("bnak");
		assertArrayEquals(new String[]{"bank", "back"}, suggestions);
	}

	//add a new word to dictionary and check if it is recognized
	@Test
	public void testAddNewWordAndCheck() {
		checker.addWord("newword");
		assertTrue(checker.isCorrectlySpelled("newword"));
	}

	//empty string should not be considered a valid word
	@Test 
	public void testEmptyStringNotValidWord() {
		assertFalse(checker.isCorrectlySpelled(""));
	}
      
	// test the input handling 
    @Test
	public void testInputHandling() {
		assertFalse(checker.isCorrectlySpelled(null)); //Null input should return false
		assertFalse(checker.isCorrectlySpelled("   ")); // Only whitespace should return false
	}

}

