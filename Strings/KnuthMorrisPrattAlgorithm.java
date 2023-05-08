package Strings;

public class KnuthMorrisPrattAlgorithm {
    public static void main(String[] args) {
//        String string = "aefaefaefaedaefaedaefaefa";
        String string = "0101";
//        String substring = "aefaedaefaefa";
        String substring = "0101";

        Boolean ans = solve(string, substring);
        System.out.println(ans);
    }

    public static boolean solve (String string, String substring) {
        // O(N + M) time | O(M) space

        int[] lps = computeLPS(substring);

        int i = 0;
        int j = 0;

        while (i < string.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                i++;
                j++;
            }
            if (j == substring.length()) {
                return true;
            } else if (i < string.length() && string.charAt(i) != substring.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    public static int[] computeLPS(String s) {
        int m = s.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int j = 0, i = 1;
        while (i < m) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

//   public static boolean KMPMatcher(String string, String pattern) {
//        int n = string.length();
//        int m = pattern.length();
//        int[] lps = computePrefixFunction(pattern);
//        int q = 0;
//        for (int i = 1; i < n; i++) {
//            while (q > 0 && pattern.charAt(q + 1) != string.charAt(i)) {
//                q = lps[q];
//            }
//            if (pattern.charAt(q + 1)  == string.charAt(i)) {
//                q = q + 1;
//            }
//            if (q == m) {
//                return true;
//            }
//            q = lps[q];
//        }
//        return false;
//    }
//    public static int[] computePrefixFunction(String pattern) {
//        int m = pattern.length();
//        int[] lps = new int[m];
//        lps[0] = 0;
//        int k = 0;
//        for (int q = 1; q < m; q++) {
//            while (k > 0 && lps[k + 1] != lps[q]) {
//                k = lps[k];
//            }
//            if (lps[k + 1] == lps[q]) {
//                 k = k + 1;
//            }
//            lps[q] = k;
//        }
//        return lps;
//    }