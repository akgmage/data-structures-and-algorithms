// https://practice.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
public class PrintAllDivisors {
    public static void main(String[] args) {
        int n = 4;
        solve(n);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) System.out.print(i + " ");
        }
        System.out.println();
    }
}
