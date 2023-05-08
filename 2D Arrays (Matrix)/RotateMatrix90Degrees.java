package Matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a n x n 2D matrix A representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note: If you end up using an additional array, you will only receive partial score.
 *
 *
 *
 * Problem Constraints
 * 1 <= n <= 1000
 *
 *
 *
 * Input Format
 * First argument is a 2D matrix A of integers
 *
 *
 *
 * Output Format
 * Return the 2D rotated matrix.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  [
 *     [1, 2],
 *     [3, 4]
 *  ]
 * Input 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [3, 1],
 *     [4, 2]
 *  ]
 * Output 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  After rotating the matrix by 90 degree:
 *  1 goes to 2, 2 goes to 4
 *  4 goes to 3, 3 goes to 1
 * Explanation 2:
 *
 *  2D array remains the ssame as there is only element.
 */
public class RotateMatrix90Degrees {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 2));
        array.add(Arrays.asList(2, 9, 6, -1));
        array.add(Arrays.asList(-3, 12, 8, 7));
        array.add(Arrays.asList(10, -2, 0, -9));

        System.out.println(array);
        solve(array);
        System.out.println(array);
    }

    public static void solve(List<List<Integer>> array) {
        // O(N *M) time | O(1) space
        int rows = array.size();
        int cols = array.get(0).size();
        Integer temp = 0;

        // transpose
        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = array.get(i);
            for (int j = i + 1; j < cols; j++) {
                temp = array.get(i).get(j);
                array.get(i).set(j, array.get(j).get(i));
                array.get(j).set(i, temp);
            }
        }

        // reverse
        for (int i = 0; i < array.size(); i++) {
            List<Integer> currentRow = array.get(i);
            int start = 0;
            int end = array.get(i).size() - 1;
            int midIdx = (int) end / 2;
            while (start <= midIdx) swap(start++, end--, currentRow);
        }
    }
        public static void swap(int i, int j, List<Integer> array) {
            int temp = (int) array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
