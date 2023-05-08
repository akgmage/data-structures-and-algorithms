public class FindSquareRoot {
    public static void main(String[] args) {
        int n = 2987712;
        System.out.println(solve(n));
    }
    public static int solve(int n) {
        int i = 1;
        while (i * i <= n) i++;
        return i - 1;
    }
}
