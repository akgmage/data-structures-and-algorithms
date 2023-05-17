/* Name : Rajeev Kumar
Github username : Tonystark121
Repository name : data-structures-and-algorithms
Problem : Kadane's algorithm in C++
Issue Number : #1179
Problem statement : Given an integer array nums, find the subarray with the largest sum, and return its sum.

Sample testcases: 

Testcase 1 --> 

Input: number of elements in array = 8
nums = [-2,-3,5,-1,-2,1,5,-3]
Output: 8

Testcase 2 -->
Input: number of elements in array = 5
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


#include<bits/stdc++.h>
using namespace std;

int main(){

    // taking input number of array elements.
    int n; 
    cin>>n;

    // taking input array elements.
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    // declare current maximum and maximum so far variable.
    int curr_max=0,max_so_far=INT_MIN;

    for(int i=0;i<n;i++){
        
        curr_max += arr[i];

        if(curr_max<0){
            curr_max=0;
        }

        if(curr_max>max_so_far){
            max_so_far = curr_max;
        }
    }

    // output result.
    cout<<max_so_far<<endl;
    return 0;
}