package Strings;
public class SplitBinaryString {
    public static void main(String[] args) {
        String A = "00011011";

        System.out.println(solve(A));
    }
    public static int solve(String str) {
        int result = 0;
        int numOfZeros = 0;
        int numOfOnes = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') numOfZeros++;
            else numOfOnes++;

            if(numOfZeros == numOfOnes) result++;
        }
        return result;
    }
}