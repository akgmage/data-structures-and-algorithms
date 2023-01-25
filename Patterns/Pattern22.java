package Patterns;

public class Pattern22 {
    //https://practice.geeksforgeeks.org/problems/square-pattern-1662666141/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_22
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i < 2 * num; i++) {
            for(int j = 1; j < 2 * num; j++) {
                System.out.print(
                        Math.max(Math.abs(num - i) + 1, Math.abs(num - j) + 1) + " "
                );
            }
            System.out.println();
        }
    }
}
