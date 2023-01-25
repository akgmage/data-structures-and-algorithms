package Patterns;
// https://practice.geeksforgeeks.org/problems/triangle-pattern-1661718455/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_11
public class Pattern11 {
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print( (i + j) % 2 + " ");
            }
            System.out.println();
        }
    }
}
