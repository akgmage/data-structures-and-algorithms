package CarryForward;

public class SpecialSubsequence {
    public static void main(String[] args) {
        String str = "ABCGAG";
        System.out.println(solve(str));
    }

    public static int solve(String str) {
        int ans = 0;
        int countOfA = 0;
        int modulo= (int) Math.pow(10,9) + 7;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == 'A') countOfA++;

            if (currentChar == 'G') ans = (ans + countOfA) % modulo;

        }

        return ans;
    }
    }

