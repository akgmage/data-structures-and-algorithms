import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray {
    /**
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     *
     * An element is a leader if it is strictly greater than all the elements to its right side.
     *
     * NOTE:The rightmost element is always a leader.
     *  input: A = [16, 17, 4, 3, 5, 2]
     * output:   [17, 2, 5]
     *
     *   public ArrayList<Integer> solve(ArrayList<Integer> A) {
     */

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(16, 17, 4, 3, 5, 2)
        );
        System.out.println(solve(array));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(array.get(array.size() - 1));

        int currentMax = result.get(0);
        for (int i = array.size() - 2; i > -1; i--) {
            int currentNum = array.get(i);
            if (currentNum > currentMax) {
                currentMax = currentNum;
                result.add(currentMax);
            }
        }
        return result;
    }
}
