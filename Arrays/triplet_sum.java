/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
*/

import java.util.*;
class FindTriplet {
    boolean findTriplet(int arr[], int n, int sum)
    {
        int l, r;

        /* Sort the elements */
        Arrays.sort(arr);

        /* Now fix the first element one by one and find the
        other two elements */
        for (int i = 0; i < n - 2; i++) {

            l = i + 1; // index of the first element
            r = n - 1; // index of the last element
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    return true;
                }
                else if (arr[i] + arr[l] + arr[r] < sum)
                    l++;

                else
                // arr[i] + arr[l] + arr[r] is greater than sum
                    r--;
            }
        }

        // If no triplet was found
        return false;
    }
	
	public static void main(String[] args)
	{
	    
        FindTriplet triplet = new FindTriplet();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int sum = 9;
		int n = arr.length;

		System.out.println(triplet.findTriplet(arr, n, sum));
	}
}

