/*

Problem Statement :

Write a function that takes in an array of at least three integers and, without sorting the input array, returns a sorted array of the three largest integers in the input array.

Explanation:

Here's how the function works:

1. We create a new array result with three elements to store the three largest integers.
2. We loop through the input array, and for each integer, we compare it to the largest integer in result.
3. If the integer is larger than the largest integer in result, we shift the elements in result down one position and add the integer to the end.
4. If the integer is larger than the second largest integer in result, we shift the elements in result down one position starting from the second position and add the integer to the second position.
5. If the integer is larger than the third largest integer in result, we add the integer to the third position.
6. At the end of the loop, result will contain the three largest integers in the input array, sorted in descending order. 

*/

public static int[] findThreeLargest(int[] array) {
    int[] result = new int[3];
    for (int num : array) {
        if (num > result[2]) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = num;
        } else if (num > result[1]) {
            result[0] = result[1];
            result[1] = num;
        } else if (num > result[0]) {
            result[0] = num;
        }
    }
    return result;
}

