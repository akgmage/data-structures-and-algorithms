import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an integer array A of size N.
 *
 * You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4, and array A contains 10 elements, then
 *
 * You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= B <= N
 *
 * -103 <= A[i] <= 103
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible sum of elements you picked.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 2]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 *
 *  Pick element 2 from end as this is the maximum we can get
 */
public class PickFromBothSides {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(5, -2, 3, 1, 2)
        );
        System.out.println(solve(array, 3));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        /**
         * Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes sum of elements from index [0,i]
         * and suffix[i] denotes sum of elements from index [i,N-1].
         *
         * Now iterate from left and one by one pick elements from left for
         * example: if you pick ‘a’ elements from left and remaining ‘k-a’ elements from right.
         * So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]
         *
         * Maintain the maximum among all and return it.
         */
        int size = A.size();
        int maxSum = 0;
        for(int i=0; i<B; i++) {
            maxSum += A.get(i);
        }
        if(B == size) {
            return maxSum;
        }

        int localSum = maxSum;
        int startPointer = B - 1;
        int endPointer = size - 1;

        for(int i = startPointer; i > -1; i--) {
            localSum -= A.get(i);
            localSum += A.get(endPointer);

            maxSum = Math.max(localSum, maxSum);
            endPointer--;
        }

        return maxSum;
    }
}
