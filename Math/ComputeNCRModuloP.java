public class ComputeNCRModuloP {
    public static void main(String[] args) {
        int a = 5, b = 2, c = 13;
        int ans = solve(a, b, c);
        System.out.println(ans);
    }
    public static int solve(int n, int r, int p) {
        long nFactorial = findFactorial(n, p);
        long nrFactorial = findFactorial(n-r, p);
        long rFactorial = findFactorial(r, p);
        long nrPow = power(nrFactorial, p-2, p);
        long rPow = power(rFactorial, p-2, p);

        long ans = (((nFactorial%p) * (nrPow%p))%p * (rPow%p))%p;
        return (int) ans;
    }
    public static int findFactorial(long a, long p) {
        long product = 1;
        for (int i = 2; i <= a; i++) {
            product = (product*i%p)%p;
        }
        return (int) product;
    }
    public static int power(long a, long n, long p) {
        if (n==0) return 1;
        long temp1 = power(a, n/2, p)%p;
        long temp2 = (temp1*temp1)%p;
        if (n%2 != 0) //odd
            return (int) ((a * temp2)%p);
        return (int) ((a * temp1)%p);
    }
}
