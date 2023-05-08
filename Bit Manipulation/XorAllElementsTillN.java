package BitManipulation;

// https://www.youtube.com/watch?v=5rtVTYAk9KQ
public class XorAllElementsTillN {

    public static void main(String[] args) {
        // O(1) time | O(1) space
        int n = 4;  // ans should be 1 ^ 2 ^ 3 ^ 4
        int ans = Integer.MIN_VALUE;

        if (n % 4 == 0) ans = n;
        else if (n % 4 == 1) ans = 1;
        else if (n % 4 == 2) ans = n + 1;
        else if (n % 4 == 3) ans = 0;

        System.out.println(ans);



     }
}
