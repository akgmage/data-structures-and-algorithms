package Patterns;

public class Pattern15 {
    // https://practice.geeksforgeeks.org/problems/triangle-pattern-1662285196/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_15
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = num; i > -1; i--) {
            for(int j = 65; j < 65 + i; j++) {
                System.out.print( (char) j + " ");
            }
            System.out.println();
        }
    }
}
