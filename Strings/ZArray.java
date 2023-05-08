package Strings;

import java.util.Arrays;

public class ZArray {
    public static void main(String[] args) {
        String string = "xxyzxxyzwxxyzxxyzx";

        int[] ans = solve(string);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String string) {

        char[] input = string.toCharArray();
        int[] z = new int[string.length()];
        int n = string.length();

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
