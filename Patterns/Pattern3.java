package Patterns;

// https://practice.geeksforgeeks.org/problems/triangle-number
public class Pattern3 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == i)
                    System.out.print(j);
                else
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
