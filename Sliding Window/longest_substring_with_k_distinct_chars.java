
/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

 */
public class LongestSubstringWithKDistinctChars {
    public int longestSubstringWithKDistinctChars(String s, int k) {
        // Check for edge cases where s is empty, null, or k is 0.
        if (s.length() == 0 || s == null || k == 0) {
            return 0;
        }
        
        int startWindow = 0; // Initialize the start of the sliding window.
        int maxlen = 0; // Initialize the maximum length of the substring.
        HashMap<Character, Integer> mp = new HashMap(); // Create a HashMap to store character frequencies.

        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow); // Get the character at the end of the window.
            mp.put(right, mp.getOrDefault(right, 0) + 1); // Update the character count in the HashMap.

            // While there are more than k distinct characters in the window.
            while (mp.size() > k) {
                char left = s.charAt(startWindow); // Get the character at the start of the window.
                mp.put(left, mp.get(left) - 1); // Decrease the count of the character.
                startWindow++; // Move the start of the window to the right.

                if (mp.get(left) == 0) {
                    mp.remove(left); // If the count becomes 0, remove the character from the HashMap.
                }
            }

            maxlen = Math.max(maxlen, endWindow - startWindow + 1); // Update the maximum length.
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDistinctChars l = new LongestSubstringWithKDistinctChars();
        System.out.println(l.longestSubstringWithKDistinctChars("araaci", 2));
        System.out.println(l.longestSubstringWithKDistinctChars("araaci", 1));
        System.out.println(l.longestSubstringWithKDistinctChars("cbbebi", 3));
    }
}
