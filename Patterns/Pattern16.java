package Patterns;

public class Pattern16 {
    //https://practice.geeksforgeeks.org/problems/triangle-pattern-1662285334/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_16
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            int ascii = 64 + i;
            for(int j = 1; j <= i; j++) {
                System.out.print( (char) ascii + " ");
            }
            System.out.println();
        }

    }
}
