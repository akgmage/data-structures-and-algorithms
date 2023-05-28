// Group Anagrams
/*
    Explanation:

    The groupAnagrams method takes an array of strings and groups them into a list of anagram groups. To accomplish this, 
    the method first creates a HashMap called anagramGroups to store the groups of anagrams.

    For each string in the input array, the method converts the string to a character array, sorts the array, 
    and converts it back to a string. This sorted string serves as the key for the anagramGroups map. If the sorted 
    string is not already in the map, the method adds it with an empty list as its value. Then, the original string 
    is added to the list of its corresponding anagram group.

    Finally, the method returns a list of the values in the anagramGroups map, which is a list of the anagram groups.

    In the main method, we create an instance of the GroupAnagrams class and call the groupAnagrams method on an example input array.
    We then print out the resulting list of anagram groups.

	The time complexity of this implementation is O(n * k log k), where n is the length of the input array and k is the length of the longest string in the array. This is due to the time complexity of sorting each string in the array.

	The space complexity of this implementation is O(n * k), as we need to store each string in the map along with its corresponding group of anagrams.

*/
import java.util.*;

public class group_anagrams{
    
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
    
    public static void main(String[] args) {
        group_anagrams ga = new group_anagrams();
        
        // Example input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        // Group the anagrams
        List<List<String>> groups = ga.groupAnagrams(strs);
        
        // Print the groups
        for (List<String> group : groups) {
            System.out.println(group);
        }
    }
}
