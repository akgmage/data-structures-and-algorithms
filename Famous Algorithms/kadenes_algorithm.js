/* What is Kadane's Algorithm?
Kadane's Algorithm is a way to find the maximum subarray sum in an array with a runtime of O(n).
It is a dynamic programming algorithm that uses the fact that the maximum subarray sum ending at index i is either the value at index i or the maximum subarray sum ending at index i-1 plus the value at index i.

Note: The subarray must be contiguous, all the values in the subarray must be next to each other in the original array.

How does it work?
In this algorithim we maintain two variables, one will hold the maximum sum of contagious subarray and the other variable will hold sum of next element + current sum from previous iteration.
If at any point the current sum + next element sum is less then 0 then we will reset the current sum to 0 and current sum + next element sum will start again from the next element.
If the current sum + next element sum is greater then 0 and it is also greater then the maximum sum of contagious subarray then the variable of maximum sum of contagious subarray will be updated with current sum + next element sum


Lets take the example: {-2, -3, 4, -1, -2, 1, 5, -3}
    In this example maxLargestSumTillNow holds the maximum sum of contagious subarray and newLargestSum hold the value of current sum + next element
    On initalizing max so far will be the max -ve number
    maxLargestSumTillNow = INT_MIN
    newLargestSum = 0

    for i=0,  a[0] =  -2
    newLargestSum = newLargestSum + (-2)
    Set newLargestSum = 0 because newLargestSum < 0
    and set maxLargestSumTillNow = -2

    for i=1,  a[1] =  -3
    newLargestSum = newLargestSum + (-3)
    Since newLargestSum = -3 and maxLargestSumTillNow = -2, maxLargestSumTillNow will remain -2
    Set newLargestSum = 0 because newLargestSum < 0

    for i=2,  a[2] =  4
    newLargestSum = newLargestSum + (4)
    newLargestSum = 4
    maxLargestSumTillNow is updated to 4 because newLargestSum greater 
    than maxLargestSumTillNow which was -2 till now

    for i=3,  a[3] =  -1
    newLargestSum = newLargestSum + (-1)
    newLargestSum = 3

    for i=4,  a[4] =  -2
    newLargestSum = newLargestSum + (-2)
    newLargestSum = 1

    for i=5,  a[5] =  1
    newLargestSum = newLargestSum + (1)
    newLargestSum = 2

    for i=6,  a[6] =  5
    newLargestSum = newLargestSum + (5)
    newLargestSum = 7
    maxLargestSumTillNow is updated to 7 because newLargestSum is 
    greater than maxLargestSumTillNow

    for i=7,  a[7] =  -3
    newLargestSum = newLargestSum + (-3)
    newLargestSum = 4
    
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

function largestSumOfSubArray(arr) {
    if (arr.lenth == 1) {
        return arr[0];
    }

    // Variable for maintaining Maximum sum of the subarray
    var maxint = Math.pow(2, 53);
    var maxLargestSumTillNow = -maxint - 1;

    // Variable to calclate the sum of subarray after each iteration
    var newLargestSum = 0;

    // Looping through the entire array
    for (i = 0; i < arr.length - 1; i++) {
        // Calculating the largest sum on each iteration
        newLargestSum += arr[i];

        // If the largest sum value is greater then the maximum largest subarray value we have maintained then we will assign new value to maintained maximum largest subarray
        if (maxLargestSumTillNow < newLargestSum) {
            maxLargestSumTillNow = newLargestSum;
        }

        // If the largest sum is negative then we will reset the value of largest sum to 0 and start the calculation again of largest sum from next element
        if (newLargestSum < 0) {
            newLargestSum = 0;
        }
    }

    // After the completion of iteration we will return the max largest sub array value
    return maxLargestSumTillNow;
}

// Driver code
var arr = [-2, -3, 4, -1, -2, 1, 5, -3];
console.log(largestSumOfSubArray(arr));

// Input: arr = [-2, -3, 4, -1, -2, 1, 5, -3];
//Output: 7
