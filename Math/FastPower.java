public class FastPower {

    public static void main(String args[]) {
        int a = 3;
        int n = 20;
        int m = 21;

        int result = solve(a, n, m);
        System.out.println(result);
    }
    public static int solve(int a, int n, int m) {
        if(n == 1) return a;
        if(n % 2 == 0)
            return solve(a * a % m, n / 2, m);
        else return (a * solve(a * a % m, (n - 1) / 2, m)) % m;
    }
}