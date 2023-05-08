import java.util.ArrayList;

public class PrimeNumbers {

    public static void main(String[] args) {
        int num = 100;

        System.out.println(solve(num));
    }
    public static ArrayList<Integer> solve(int num) {
        // Time O(N√N) | space O(1)
        ArrayList<Integer> result = new ArrayList<>();
        for(int val = 2; val <= num; val++) {
            if(isPrime(val)) result.add(val);
        }
        return result;
    }
    public static boolean isPrime(int num) {
        // time O(√N)
        for(int idx = 2; idx <= Math.sqrt(num); idx++){
            if(num % idx == 0) return false;
        }
        return true;
    }
}
