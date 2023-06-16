// Step 1: Create a hash table to store the characters and their last occurrence indices.
// Map<Character, Integer> charIndices = new HashMap<>();

// Step 2: Initialize variables to keep track of the start index of the current partition and the last index of the optimal partition.
// int start = 0;
// int end = 0;

// Step 3: Iterate through the string and update the last occurrence index of each character in the hash table.

// for (int i = 0; i < s.length(); i++) {
//     char c = s.charAt(i);
//     charIndices.put(c, i);
// }
// Step 4: Iterate through the string again and update the end index of the optimal partition if a character's last occurrence index is greater than the current end index.

// for (int i = 0; i < s.length(); i++) {
//     char c = s.charAt(i);
//     int lastIndex = charIndices.get(c);
//     end = Math.max(end, lastIndex);
    
//     if (i == end) {
//         int partitionLength = end - start + 1;
//         System.out.println(s.substring(start, end + 1));
//         start = end + 1;
//     }
// }


import java.util.HashMap;
import java.util.Map;

public class StringPartition {
    public static void main(String[] args) {
        String s = "aabbccddee";
        findOptimalPartitions(s);
    }

    public static void findOptimalPartitions(String s) {
        Map<Character, Integer> charIndices = new HashMap<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charIndices.put(c, i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = charIndices.get(c);
            end = Math.max(end, lastIndex);

            if (i == end) {
                int partitionLength = end - start + 1;
                System.out.println(s.substring(start, end + 1));
                start = end + 1;
            }
        }
    }
}
