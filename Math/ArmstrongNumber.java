public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 153;
        System.out.println(isArmstrong(n));
    }
    public static Boolean isArmstrong(int n) {
        int sum = 0;
        int tmp = n;
        int length = Integer.toString(n).length();
        while (tmp > 0) {
            sum += power(tmp % 10, length);
            tmp /= 10;
        }
        return sum == n;
    }
    public static int power(int a, int b) {
        int res = 1;
        for(int i = 0; i < b; i++) {
            res *= a;
        }
        return  res;
    }
}
