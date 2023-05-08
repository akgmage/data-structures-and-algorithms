import java.util.ArrayList;
import java.util.Arrays;

/**
 * A wire connects N light bulbs.
 *
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 *
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 *
 * You can press the same switch multiple times.
 *
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 *
 *
 *
 * Problem Constraints
 * 0 <= N <= 5×105
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer array A, of size N.
 *
 *
 *
 * Output Format
 * Return an integer representing the minimum number of switches required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [0, 1, 0, 1]
 * Input 2:
 *
 *  A = [1, 1, 1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  press switch 0 : [1 0 1 0]
 *  press switch 1 : [1 1 0 1]
 *  press switch 2 : [1 1 1 0]
 *  press switch 3 : [1 1 1 1]
 * Explanation 2:
 *
 *  There is no need to turn any switches as all the bulbs are already on.
 */
public class Bulbs {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(0, 1, 0, 1)
        );
        System.out.println(solve(array));
    }
    public static int solve(ArrayList<Integer> A) {
//        int switchCount = 0;
//        for(int i = 0; i < A.size(); i++){
//            if(switchCount % 2 != 0) {
//                A.set(i, A.get(i) - 1);// to get the real state of i, because only odd number can change the state
//            }
//            if(A.get(i) == 0) switchCount++;
//        }
//        return switchCount;

        // Carry Forward Approach
        int count = 0;
        if(A.size() == 0){
            return 0;
        }
        if(A.get(0) == 0){
            count = 1;
        }
        for(int i = 1; i < A.size(); i++){
            if(A.get(i) != A.get(i-1)){
                count++;
            }
        }
        return count;
    }
    }


