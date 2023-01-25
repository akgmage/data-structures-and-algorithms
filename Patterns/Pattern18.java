package Patterns;

public class Pattern18 {
    //https://practice.geeksforgeeks.org/problems/triangle-pattern-1662286302/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_18
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }

    public static void solve(int num) {

        for(int i = 1; i <= num; i++) {
            int ascii = 69;
            ascii -= i;
            for(int j = 1; j <= i; j++) {
                ascii += 1;
                System.out.print( (char) ascii + " ");
            }
            System.out.println();
        }
    }
}
