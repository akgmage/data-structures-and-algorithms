/*
	Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
	whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from
	the first array in the first position.

	Note that the absolute difference of two integers is the distance between them on the real number line.
	For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

  	You can assume that there will only be one pair of numbers with the smallest difference.

	Sample Input Array1 = [-1, 5, 10, 20, 28, 3]
	Sample Input Array2 = [26, 134, 135, 15, 17]

	Sample Output = [28, 26]


	This code implements the Smallest Difference problem which takes two arrays of integers as input and returns a pair of integers,
	one from each array, with the smallest absolute difference between them.

	The function first initializes two variables current and smallest to the maximum integer value. It then sorts both input arrays
	in ascending order using the sort.Ints function from the sort package.

	The function then iterates through both arrays using two pointers, idx1 and idx2, initialized to 0. Inside the loop, it compares
	the elements at the current indices of the two arrays, first and second, and calculates the absolute difference between
	them in the current variable.

	If current is smaller than the smallest variable, it updates smallest to current and assigns the current pair of integers
	to the result variable.

	The function returns the result variable, which contains the pair of integers with the smallest absolute difference.

	If there are identical integers in the two input arrays, the function will return them immediately, without any further comparisons.

	O(nlog(n) + mlog(m)) time | O(1) space - where n is the length of the first input array and m is the length of the second input array
*/
import java.util.Arrays;

public class Main {

    public static int[] smallestDifference(int[] array1, int[] array2) {
        // Initialize variables for the smallest difference and the current difference being calculated
        int current = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        // Sort the input arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Initialize variables for the indices for the two arrays
        int idx1 = 0;
        int idx2 = 0;

        // Initialize an empty array for the result
        int[] result = new int[2];

        // Loop through the two arrays until we reach the end of one of the arrays
        while (idx1 < array1.length && idx2 < array2.length) {
            // Get the values at the current indices for the two arrays
            int first = array1[idx1];
            int second = array2[idx2];

            // Calculate the current difference between the two values
            if (first < second) {
                current = second - first;
                idx1++;
            } else if (second < first) {
                current = first - second;
                idx2++;
            } else {
                // If the two values are equal, we can return the pair
                return new int[]{first, second};
            }

            // Update the smallest difference and result array if the current difference is smaller
            if (smallest > current) {
                smallest = current;
                result[0] = first;
                result[1] = second;
            }
        }

        // Return the pair with the smallest absolute difference
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 23, 11, 2};
        int[] array2 = {8, 19, 3, 15, 9};

        int[] result = smallestDifference(array1, array2);
        System.out.println(Arrays.toString(result));  // Output: [3, 3]
    }
}
