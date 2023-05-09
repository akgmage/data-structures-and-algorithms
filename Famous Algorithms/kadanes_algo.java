/* Name : Aneesh
Github username : 007aneesh
Repository name : data-structures-and-algorithms
Problem : Kadane's algorithm in Java
Issue Number : #1180
Problem statement : Given an integer array nums, find the subarray with the largest sum, and return its sum.

Sample testcases: 

Testcase 1 --> 

Input: number of elements in array = 9
nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Testcase 2 -->
Input: number of elements in array
nums = [5,4,-1,7,8]
Output: 23

Time Complexity = O(n)
Space Complexity = O(1)


Explanation:
This code asks the user to enter the number of elements in an array,
and then prompts them to enter each element of the array one at a time.
Once the array is complete, the code applies the Kadane's algorithm to
find the maximum sum of any subarray within the array, and then prints 
the result to the console.

Kadane's algorithm is a way of finding the maximum sum of a contiguous subarray within an array,
and it does so by keeping track of the maximum sum seen so far as it iterates through the array.
At each step, it adds the current element to a running sum, and if that sum becomes negative,
it resets the running sum to zero. If the running sum is ever greater than the maximum seen so far,
it updates the maximum. Finally, it returns the maximum sum.
*/

// ----------------------------------------------------------------------------- code begins now!
import java.util.Scanner;

public class kadanes_algo {
	public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max = 0;
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max += arr[i];

            if (max < arr[i]) {
                max = arr[i];
            }

            if (sum < max) {
                sum = max;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = maxSubArraySum(arr);
        System.out.println("The maximum subarray sum is " + maxSum);
    }

}
