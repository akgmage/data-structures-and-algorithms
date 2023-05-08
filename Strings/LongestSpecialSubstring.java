package Strings;

public class LongestSpecialSubstring {
    public static void main(String[] args) {
        String str = "rishabhkejariwal";
        int[] b = {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0};
        int c = 2;

        String ans = solve(str, b, c);

        System.out.println(ans);
    }

    public static String solve(String str, int[] b, int c) {

        int ans = 0;
        int count = c;
        int i = 0, j = 0;
        int left = -1, right = -1;

        while (j < str.length()) {
            char currChar = str.charAt(j);
            int num = currChar - 97;
            System.out.println(currChar);
            if (b[num] == 1) {
                count--;
            }

            while (count < 0) {
                char curr = str.charAt(i);
                int k = curr - 97;
                if (b[k] == 1) {
                    count++;
                }
                i++;
            }

            if (j - i + 1 > ans) {
                ans = j - i + 1;
                left = i;
                right = j;
            }
            j++;
        }
//        System.out.println(right - left + 1);
        return str.substring(left, right + 1);
    }
}


