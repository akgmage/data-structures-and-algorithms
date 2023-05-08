package Matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ColSum {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 2, 3, 4));
        array.add(Arrays.asList(5, 6, 7, 8));
        array.add(Arrays.asList(9, 2, 3, 4));

        System.out.println((solve(3, 4, array)));
    }
    public static ArrayList<Integer> solve (int row, int col, List<List<Integer>> array) {
        // O(row*col) time | O(col) space
        ArrayList<Integer> result = new ArrayList<>();

        for (int colIdx = 0; colIdx < col; colIdx++) {
            int currentSum = 0;
            for (int rowIdx = 0; rowIdx < row; rowIdx++) {
                int currentNum = array.get(rowIdx).get(colIdx);
                currentSum += currentNum;
            }
            result.add(currentSum);
        }
        return result;
    }

}
