package Patterns;
//https://practice.geeksforgeeks.org/problems/triangle-number-1661428795/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_4
public class Pattern4 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == i)
                    System.out.print(i);
                else
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
