package Patterns;

// https://practice.geeksforgeeks.org/problems/triangle-pattern-1661493231/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_8
public class Pattern8 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = n; i >= 1; i--) {
            for(int k = i; k < n; k++) System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

}
