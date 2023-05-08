package Strings;

public class FindPatternCount {
    public static void main(String[] args) {
        String string = "darkisbarking";
        String pattern = "barking";

        int ans = solve(string, pattern);
        System.out.println(ans);
    }
    public static int solve(String string, String pattern) {
        // O(N) time | O(N) space N > M
        // N is length of string, M is length of pattern
        int[] zArray = getZArray(string, pattern);

        int count = 0;
        for (int val : zArray) {
            if (val == pattern.length()) count++;
        }
        return count;
    }
    public static int[] getZArray(String string, String pattern) {
        String inputString = pattern + "$" + string; // concat both strings and apply z-algorithm

        char[] input = inputString.toCharArray();
        int[] z = new int[inputString.length()];
        int n = inputString.length();

        int left = 0, right = 0; // maintain the segment

        for (int i = 1; i < n; i++) {
            int j = i, k = 0;
            if (i > right) { // outside the segment
                while (j < n && input[k] == input[j]) {
                    k++;
                    j++;
                }
                z[i] = k;
                left = i; right = j - 1;  // update the segment
            } else { // element is lying in the segment
                if (z[i - left] < right - j + 1) {
                    // trust and copy the answer
                    z[i] = z[i - left];
                } else {
                    // apply brute force
                    j = right + 1; k = right - i + 1;
                    while (j < n && input[j] == input[k]) {
                        k++;
                        j++;
                    }
                    z[i] = k;
                    left = i; right = j - 1;
                }
            }
        }
        return z;
    }
}
