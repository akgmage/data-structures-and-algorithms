/*
	Group Anagrams

	Sample Input:  = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
	Output: [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]

	Explanation:

	The code snippet is a function that groups anagrams together. An anagram is a word or phrase formed by rearranging
	the letters of another word or phrase.

	The function first defines two functions: GroupAnagrams and sortWord. The GroupAnagrams function takes a list of words
	as input and returns a list of lists, where each inner list contains all the anagrams of a word in the original list.
	The sortWord function takes a word as input and returns a string that contains the word's letters in sorted order.

	The GroupAnagrams function works by first creating a map where the keys are sorted strings of words and the values are
	lists of words that have the same sorted string. Then, the function iterates through the list of words, calling the
	sortWord function to get the sorted string for each word. The function then adds the word to the list of words associated with the sorted string in the map. Finally, the function iterates through the map, adding each list of words to a list of lists.

	The sortWord function works by converting the word to a byte array and then calling the sort.Slice function to sort
	the byte array. The function then returns a string that contains the sorted byte array.

	O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
        // Create a map where the keys are sorted strings of words and the values are lists of words
        // that have the same sorted string.
        Map<String, List<String>> anagrams = new HashMap<>();

        // Iterate through the words
        for (String word : words) {
            // Get the sorted string for the word
            String sortedWord = sortWord(word);

            // Add the word to the list of words associated with the sorted string in the map
            if (!anagrams.containsKey(sortedWord)) {
                anagrams.put(sortedWord, new ArrayList<>());
            }
            anagrams.get(sortedWord).add(word);
        }

        // Create a list of lists, where each inner list contains all the anagrams of a word in the original array
        List<List<String>> result = new ArrayList<>(anagrams.values());

        // Return the list of lists
        return result;
    }

    // Helper method to sort the characters in a word and return the sorted string
    private String sortWord(String word) {
        // Convert the word to a character array
        char[] wordChars = word.toCharArray();

        // Sort the character array
        Arrays.sort(wordChars);

        // Return the sorted string
        return new String(wordChars);
    }

    public static void main(String[] args) {
        // Example usage
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> groupedAnagrams = groupAnagrams.groupAnagrams(words);

        // Print the grouped anagrams
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
