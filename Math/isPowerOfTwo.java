//check if a given number is a power of 2
public class isPowerOfTwo {
    public static void main(String[] args) {
        int num = 11;
        boolean res = solve(num);
        System.out.println(res);
    }
    public static boolean solve(int num) {
        // O(log(N)) time | O(1) space
        if (num == 0) return false;

        while (num % 2 == 0) num /= 2;
        return num == 1;
    }
}
