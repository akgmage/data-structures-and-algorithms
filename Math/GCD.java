public class GCD {
    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        System.out.println(gcd(x, y));
    }
    public static int gcd(int x, int y) {
        return x == 0 ? y: gcd(y % x, x);
    }
}
