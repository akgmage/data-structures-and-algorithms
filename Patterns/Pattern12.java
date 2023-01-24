package Patterns;

public class Pattern12 {
    //https://practice.geeksforgeeks.org/problems/double-triangle-pattern-1662664259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_12
    public static void main(String[] args) {
        int n = 4;
        solve(n);
    }
    public static void solve(int n) {

       for(int i = 1; i <= n; i++) {
           for(int j = 1; j <= i; j++) System.out.print(j);
           for(int k = 2 * (n - i); k > 0; k--) System.out.print(" ");
           for(int l = i; l >= 1; l--) System.out.print(l);
           System.out.println();
       }
    }
}
