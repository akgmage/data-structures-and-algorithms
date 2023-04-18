import java.util.*;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store the groups of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        // Loop through each string in the input array
        for (String str : strs) {
            // Convert the string to a char array, sort it, and convert it back to a string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // If the sorted string is not in the map, add it with an empty list as its value
            if (!anagramGroups.containsKey(sorted)) {
                anagramGroups.put(sorted, new ArrayList<String>());
            }
            
            // Add the original string to the list of its anagram group
            anagramGroups.get(sorted).add(str);
        }
        
        // Return a list of the anagram groups
        return new ArrayList<>(anagramGroups.values());
    }
    
}
