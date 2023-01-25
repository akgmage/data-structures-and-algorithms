package Patterns;

public class Pattern20 {
//    https://practice.geeksforgeeks.org/problems/double-triangle-pattern-1662287416/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_20
    public static void main(String[] args) {

        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int k = (num - i) * 2; k >= 1; k--) {
                System.out.print(" ");
            }
            for(int l = 1; l <= i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = num - 1; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int k = 2 * (num - i); k >= 1; k--) {
                System.out.print(" ");
            }
            for(int l = i; l >=1; l--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
