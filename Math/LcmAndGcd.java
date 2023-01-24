import java.util.Arrays;

public class LcmAndGcd {
    public static void main(String[] args) {
        long A = 5;
        long B = 10;
        System.out.println(Arrays.toString(solve(A, B)));
    }
    public static Long[] solve(Long A, Long B) {
        Long ans[] = new Long[2];
        Long t1 = A;
        Long t2 = B;
        while(t1 % t2 != 0) { //GCD
            Long rem = t1 % t2;
            t1 = t2;
            t2 = rem;
        }
        ans[1] = t2; //GCD
        ans[0] = (A * B) / ans[1]; //LCM Formula: (n1 * n2) / gcd
        return ans;
    }
}
