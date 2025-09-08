package My_Files;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Keep track of word counts and word pairs.
 * 
 * DO NOT CHANGE ANY OF THE METHOD NAMES, PARAMETERS
 * OR RETURN TYPES IN THIS FILE. IF YOU DO, IT WILL
 * NOT BE POSSIBLE TO MARK YOUR WORK.
 *
 * @author James Cox
 * @version 
 */
public class WordTracker
{    
    private ArrayList<String> sentenceTracker;
    /**
     * Constructor for objects of class WordTracker
     */
    public WordTracker()
    {
        sentenceTracker = new ArrayList<>();
    }
    
    /**
     * Add a word to the analyser.
     * @param word the word to be added.
     */
    public void addWord(String word)
    {
        sentenceTracker.add(word); // adds words in order to the array list
    }
    
    /**
     * Get the number of times the given word has been seen.
     * @param word The word to be looked up.
     * @return The number of times the word has been seen.
     */
    public int getCount(String word)
    {
        int count = 0; // count of words
        for(String words : sentenceTracker){ // checks all words in array
            if(words == word){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Return true if firstWord is immediately followed
     * by secondWord in the original text; false otherwise.
     * In other words, return true if, after a call to addWord(firstWord),
     * the next call to addWord was addWord(secondWord).
     * 
     * @param firstWord A possible word added immediately before secondWord.
     * @param secondWord A possible word added immediately after firstWord.
     */
    public boolean wordPair(String firstWord, String secondWord)
    {
        boolean inOrder = false;
        int index = 0;
        while(index < sentenceTracker.size()){
          if(sentenceTracker.get(index) == firstWord){
              index ++; // adds index to see if next word is second word
              if(sentenceTracker.get(index) == secondWord){
                  inOrder = true; //true = its found, if not then back to if 
              }
          }
          else{
              index ++;
          }
        }
        return inOrder;
    }
    
    /**
     * Get the number of times the given string occurs
     * within one of the words in the analyser.
     * Note: the match must be *case insensitive*.
     * @param str The substring to be looked up.
     * @return The number of times the substring occurs.
     */
    public int getSubstringCount(String str)
    {
        int count = 0;  // adds a count for the words that contain str
        ArrayList<String> deletedWords = new ArrayList<>(); // new array for looked at words
        Iterator<String> it = sentenceTracker.iterator(); // iterator for array of words
        while(it.hasNext()){
             String words = it.next();
             if(words.contains(str) && deletedWords.contains(words) == false){
                 count++;      //^ checks if wor contains str and hasnt already been checked
                 deletedWords.add(words); //adds word to array so it doesnt et checked again
             }
        }
        return count;
    }
}
