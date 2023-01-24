package Patterns;

//TODO https://practice.geeksforgeeks.org/problems/square-pattern
public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 0; i < n; i++) {
            String pattern = "";
            for(int j = 0; j < n; j++) {
                if(j != n) pattern += "* ";
                else pattern += "*";
            }
            System.out.println(pattern);
        }
    }
}
