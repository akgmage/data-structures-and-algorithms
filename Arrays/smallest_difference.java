import java.util.Arrays;

/**
 *

 Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from the first array in the first position.

 Note that the absolute difference of two integers is the distance between them on the real number line. For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

 You can assume that there will only be one pair of numbers with the smallest difference.
 Sample Input

 arrayOne = [-1, 5, 10, 20, 28, 3]
 arrayTwo = [26, 134, 135, 15, 17]

 Sample Output

 [28, 26]


 */
public class SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        int[] result = solve(arrayOne, arrayTwo);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solve(int[] arrayOne, int[] arrayTwo) {
        // O(n(log(n) + m(log(m)) time | O(1) space
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0;
        int idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int current;
        int[] smallestPair = new int[2];
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int firstNum = arrayOne[idxOne];
            int secondNum = arrayTwo[idxTwo];
            if (firstNum < secondNum) {
                current = secondNum - firstNum;
                idxOne++;
            } else if (secondNum < firstNum) {
                current = firstNum - secondNum;
                idxTwo++;
            } else return new int[]{firstNum, secondNum};
            if (current < smallest) {
                smallest = current;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;
    }
}
