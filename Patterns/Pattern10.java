package Patterns;

public class Pattern10 {
    //https://practice.geeksforgeeks.org/problems/triangle-pattern-1661718013/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_10
    public static void main(String[] args) {
        int i = 10;
        solve(i);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == i)
                    System.out.print("*");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n - 1; i > -1; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

