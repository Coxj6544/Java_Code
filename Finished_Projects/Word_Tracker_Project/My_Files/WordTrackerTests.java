package My_Files;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

public class WordTrackerTests {


    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

        /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testAddWord() {
        WordTracker tracker = new WordTracker();
        tracker.addWord("test");
        assertEquals(1, tracker.getCount("test"));
    }

    @Test
    public void testGetCount() {
        WordTracker tracker = new WordTracker();
        tracker.addWord("test");
        tracker.addWord("test");
        assertEquals(2, tracker.getCount("test"));
    }

    @Test
    public void testWordPair() {
        WordTracker tracker = new WordTracker();
        tracker.addWord("first");
        tracker.addWord("second");
        assertTrue(tracker.wordPair("first", "second"));
    }

    @Test
    public void testGetSubstringCount() {
        WordTracker tracker = new WordTracker();
        tracker.addWord("testing");
        assertEquals(1, tracker.getSubstringCount("est"));
    }
}
