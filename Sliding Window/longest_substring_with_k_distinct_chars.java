
/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

 */
public class LongestSubstringWithKDistinctChars {
    public int longestSubstringWithKDistinctChars(String s, int k) {
        if (s.length() == 0 || s == null || k ==0) {
            return 0;
        }
        int startWindow = 0;
        int maxlen = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            mp.put(right, mp.getOrDefault(right, 0) + 1);
            while (mp.size() > k) {
                char left = s.charAt(startWindow);
                mp.put(left, mp.get(left) - 1);
                startWindow++;
                if(mp.get(left) == 0) {
                    mp.remove(left);
                }
            }
            maxlen = Math.max(maxlen, endWindow - startWindow + 1);
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
