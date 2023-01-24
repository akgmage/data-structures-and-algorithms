package Patterns;
// https://practice.geeksforgeeks.org/problems/triangle-pattern-1661492263/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_7
public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int l = i; l < n; l++)
                System.out.print(" ");
                for(int j = 1; j <= (2 * i) - 1; j++)
                    System.out.print("*");
            System.out.println();
        }
    }
}
