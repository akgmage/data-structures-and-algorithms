
public class FindPerfectNumber {
    /**
     * Scaler Homework 04 jan 2023
     */
    public static void main(String[] args) {
        System.out.println(solve(2));
    }

    public static int solve(int num) {
        int sum = 0;
        int i = 1;
        while( i < num ) {
            if( num % i == 0) {
                sum += i;
            }
            i++;
        }
        if(sum == num) return 1;
        return 0;
    }
}
