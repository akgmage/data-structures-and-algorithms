/*
    Write a function that takes in an array of at least three integers and,
    without sorting the input array, returns a sorted array of the three largest
    integers in the input array.

    Explanation:

    This code defines a function called `FindThreeLargestNumbers` that takes an array of integers as input and
    returns an array of the three largest integers in the input array.

    The `triplets` array is initialized with three smallest possible values. Then, the function iterates through
    the input array using a `for` loop and calls the `updateLargest` function to update the `triplets` array with
    the current number if it is larger than one of the values in the array.

    The `updateLargest` function takes two arguments: `triplets` and `num`. It first checks if `num` is greater
    than the third value in the `triplets` array. If so, it calls the `shiftAndUpdate` function to update the
    `triplets` array with the current number at the third index.

    If `num` is not greater than the third value in the `triplets` array, it checks if `num` is greater than the second value in the `triplets` array.

    If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
    the second index. Finally, if `num` is not greater than either the third or second value in the `triplets`
    array, it checks if `num` is greater than the first value in the `triplets` array.

    If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
    the first index.

    The `shiftAndUpdate` function takes three arguments: `triplets`, `num`, and `idx`. It iterates through the
    `triplets` array using a `for` loop and shifts each value to the left by one position until it reaches
    the `idx` index. Then it updates the value at the `idx` index with the current number `num`.

    Time and Space complexity : O(n) time | O(1) space - where n is the length of the input array
*/

import java.util.Arrays;

public class Main {
    // Function to find the three largest numbers in the input array
    public static int[] findThreeLargestNumbers(int[] array) {
        // Initialize an array to hold the three largest numbers, starting with negative infinity
        int[] triplets = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        // Iterate through each number in the input array
        for (int num : array) {
            // Call the updateLargest function to determine if the number should be included in the triplet
            updateLargest(triplets, num);
        }

        // Return the array containing the three largest numbers
        return triplets;
    }

    // Function to update the triplet if the input number is larger than any of its elements
    private static void updateLargest(int[] triplets, int num) {
        // If the number is larger than the third-largest element in the triplet
        if (num > triplets[2]) {
            // Shift the other elements to make room and add the number as the new third-largest element
            shiftAndUpdate(triplets, num, 2);
        }
        // Otherwise, if the number is larger than the second-largest element
        else if (num > triplets[1]) {
            // Shift and update the triplet accordingly
            shiftAndUpdate(triplets, num, 1);
        }
        // Otherwise, if the number is larger than the first-largest element
        else if (num > triplets[0]) {
            // Shift and update the triplet accordingly
            shiftAndUpdate(triplets, num, 0);
        }
    }

    // Function to shift the elements of the triplet and add the new number to the specified index
    private static void shiftAndUpdate(int[] triplets, int num, int idx) {
        // Iterate through the elements of the triplet
        for (int i = 0; i < idx + 1; i++) {
            // If the loop reaches the specified index, add the new number to the triplet
            if (i == idx) {
                triplets[i] = num;
            }
            // Otherwise, shift the elements to the right
            else {
                triplets[i] = triplets[i + 1];
            }
        }
    }

    // Main function to test the findThreeLargestNumbers function
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, 10, 3};
        int[] result = findThreeLargestNumbers(array);
        System.out.println(Arrays.toString(result));
    }
}
