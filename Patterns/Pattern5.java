package Patterns;
// https://practice.geeksforgeeks.org/problems/triangle-pattern/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_5
public class Pattern5 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
     for(int i = n; i > -1; i--) {
         for(int j = 0; j < i; j++) {
             System.out.print("*");
         }
         System.out.println();
     }
    }
}
