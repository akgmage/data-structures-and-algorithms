/* 

Introduction:

    This documentation provides a detailed explanation of the problem statement, algorithm, and implementation of 
    calculating the sum of Hamming distances between all pairs of integers in an integer array. 
    Hamming distance measures the number of positions at which corresponding bits are different between two numbers. 
    The algorithm aims to find the sum of Hamming distances for all possible pairs of integers in the given array.

Problem Statement:

    Given an integer array nums, the task is to calculate the sum of Hamming distances between all the pairs of integers in nums. 
    The goal is to determine the total count of differing bits at each position for all possible pairs of integers in the array.
    
Hamming Distance : 

    Hamming distance is a metric for comparing two binary data strings. 
    While comparing two binary strings of equal length, Hamming distance is the number of bit positions in which the two bits are different.

Sample Input    : [4,14,2]
expected Output :  6

Explaination    :   In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just showing the four bits relevant in this case).
Total Hamming distance = HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Method 1 : 

    (Brute Force Method) We can iterate over the whole array and find all pairs calculate Hamming distance and add all the distances.
    Time complexity  :  O(n^2) 
    Space Complexity :  O(1)

Method 2 :

    1. Initialize a variable `totalDistance` to store the sum of Hamming distances.
    2. Iterate over each bit position from 0 to 31 (assuming integers are 32-bit).
    3. For each bit position `i`, initialize two variables: `countZeros` and `countOnes` to keep track of the count of zeros and ones at that position.
    4. Iterate over each element `num` in `nums`.
       a. Right shift `num` by `i` positions and perform a bitwise AND with 1 to check the value at bit position `i`.
       b. If the result is 0, increment `countZeros` by 1; otherwise, increment `countOnes` by 1.
    5. Add `countZeros * countOnes` to `totalDistance`. This calculates the Hamming distance for the current bit position and adds it to the running total.
    6. Repeat steps 3-5 for all bit positions.
    7. Return `totalDistance` as the sum of Hamming distances between all pairs of integers in `nums`.

    Time Complexity  : O(k*n) where ,
    k = maximum number of bits required to represent a number in the array
    n = size of array

    Space Complexity : O(1)


Explaination :

    Number  ==>   Binary Representation
     4              0 1 0 0
     14             1 1 1 0
     2              0 0 1 0

    The idea is to count differences at individual bit positions. We traverse from 0 to 31 and count numbers with i’th bit set. 
    Let this count be ‘c'. There would be “n-c” numbers with i’th bit not set. 
    So count of differences at i’th bit would be “count * (n-count)”, the reason for this formula is as every pair having one element 
    which has set bit at i’th position and second element having unset bit at i’th position contributes exactly 1 to sum.

    1st bit = 2*1 = 2 
    2nd bit = 2*1 = 2
    3rd bit = 2*1 = 2
    4th bit = 3*0 = 0
--------------------------
    Total =         6


*/

//  CODE : 

// #include<bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;

int totalHammingDistance(vector<int>& nums) {
        int totalDistance=0;
        int n=nums.size();
        // Here we are assuing that the 32 bits are sufficient to represent all the numbers in the array
        for(int i=0;i<32;i++){
            int c=0;// c represents number of set bits of a particular position in the whole array.
            for(int j=0;j<n;j++){
					if((nums[j]&(1<<i)))
                    c++;     //Checking if i'th bit is set ot not.
            }
            totalDistance+=(c*(n-c));      //Adding count of differences
        }
        return totalDistance;
    }


int main()
{
    int n ;
    cin >> n;
    vector<int> nums(n);
    for(int i=0;i<n;i++)
    {
        cin >> nums[i];
    }
    int total_hamming_distance = totalHammingDistance(nums);
    cout << total_hamming_distance << endl;
    return 0;
}