package Patterns;

public class Pattern13 {
    //https://practice.geeksforgeeks.org/problems/triangle-pattern-1661718712/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_13

    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        int k = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) System.out.print(++k + " ");
            System.out.println();
        }
    }
}
