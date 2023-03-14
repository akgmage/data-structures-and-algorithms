/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/
// Approach:
// 1. Go through the list of words
// 2. Sort each word. All annograms of the word would look the same being sorted.
// 3. Find matching bucket in map and put the word to it
// 4. When finished, convert the map to vector of vectors and return it

package Strings;

import java.util.*;

public class groupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) { 

        HashMap<String , List<String>> map = new HashMap<>();
    
        for(int i = 0 ; i < strs.length ; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String string = new String(charArr);
    
            if(!map.containsKey(string)){
                map.put(string, new ArrayList<>());
            }
            map.get(string).add(strs[i]);
        }
    
        List<List<String>> result = new ArrayList<>();
    
        for(String st : map.keySet()) {
            List<String> list = map.get(st);
            result.add(list);
        }
        return result;
    }
}
