/* Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :  Find Number of Good Pairs in Go
Issue Number : #529
Problem statement : Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

Explanation of the below cpp code:

This C++ program takes an integer n as input and then reads n integers from the standard input.
It then creates a vector v to store the input integers and a map m to count the frequency of each input integer.
Finally, the program computes the number of pairs of input integers that are equal and outputs this count to the standard output.

The algorithm used to compute the count of pairs is based on the following observation:
for each integer x that appears k times in the input vector, there are k*(k-1)/2 pairs of integers that are equal to x.
This can be seen by choosing any two of the k occurrences of x, which can be done in k*(k-1)/2 ways.

The program uses the map data structure to count the frequency of each integer in the input vector.
It then iterates over the pairs (x,k) in the map and adds k*(k-1)/2 to a variable count. Finally, it outputs the value of count.

Overall, this program has a time complexity of O(n log n) due to the use of the map data structure, which has a logarithmic time complexity for insertion and lookup operations.
However, since the input size is limited to 10^5 integers, the program should run efficiently for typical input sizes.
*/
-------------------------------------------------------------------------//C++ code begins here---------------------------------------------------------------------------------
//Array: Find Number of Good Pairs in Go

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> v;
    map<int,int> m;
    for(int i=0;i<n;i++)
    {
        int x;
        cin>>x;
        v.push_back(x);
        m[x]++;
    }
    int count = 0;
    for(auto it:m)
    {
        count = count + (it.second-1)*(it.second)/2;
    }
    cout<<count<<endl;
    return 0;
}
