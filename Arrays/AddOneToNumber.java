package Linear.Arrays.OneDimensional;

import java.util.Arrays;

public class AddOneToNumber {
    public static void main(String[] args) {
        int[] digits = {0, 0, 0, 9, 9, 9, 9, 9};

        int[] ans = solve(digits);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] digits) {
        // O(N) time | O(N) space
        int n = digits.length;

        // remove starting zero's
        if (digits[0] == 0) {
            int idx = 0;
            while (idx < n && digits[idx] == 0) {
                idx++;
            }
            digits = Arrays.copyOfRange(digits, idx, n);
        }

        n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx > -1; idx--) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            } else {
                // here we have the rightmost not-nine
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
