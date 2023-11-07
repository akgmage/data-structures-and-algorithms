class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int startWindow = 0, maxCount = 0, max = 0;
        for(int endWindow = 0; endWindow < s.length(); endWindow++) {
            int val = s.charAt(endWindow) - 'A';
            count[val]++;
            maxCount = Math.max(maxCount, count[val]);
            while(endWindow - startWindow + 1 - maxCount > k) {
                val = s.charAt(startWindow) - 'A';
                count[val]--;
                startWindow++;
            }
            max = Math.max(max, endWindow - startWindow + 1);
        }
        return max;
    }
}