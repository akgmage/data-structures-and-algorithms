// Leetcode 1822 : Sign of the Product of an Array
/*
QUESTION
There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).
Example 1:

Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1
Example 2:

Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0
Example 3:

Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

Constraints:
1 <= nums.length <= 1000
-100 <= nums[i] <= 100

CODE EXPLANATION WITH DRY RUN

Suppose we have the following input vector:
{-1, -2, -3, -4, 3, 2, 1}
We want to find the sign of the product of all elements in the vector.

Here's how the code will execute:

1-We define the input vector nums in the main function.
2-We call the arraySign function with nums as the argument.
3-The arraySign function initializes the sign variable to 1.
4-The function iterates over each element of the nums vector using a range-based for loop.
5-On the first iteration, num is -1. The element is negative, so the sign variable is multiplied by -1, changing its value to -1.
6-On the second iteration, num is -2. The element is negative, so the sign variable is multiplied by -1 again, changing its value to 1.
7-On the third iteration, num is -3. The element is negative, so the sign variable is multiplied by -1, changing its value to -1.
8-On the fourth iteration, num is -4. The element is negative, so the sign variable is multiplied by -1 again, changing its value to 1.
9-On the fifth iteration, num is 3. The element is positive, so the sign variable is not changed and remains 1.
10-On the sixth iteration, num is 2. The element is positive, so the sign variable is not changed and remains 1.
11-On the seventh iteration, num is 1. The element is positive, so the sign variable is not changed and remains 1.
12-The arraySign function returns sign, which has a value of 1.
13-In the main function, we check if sign is equal to 1. It is, so we print "Product is Positive" to the console.
Therefore, the output of the program will be:
"Product is Positive"
*/
#include <vector>
#include <iostream>
using namespace std;

// Function to find the sign of the product of all elements in the input vector
int arraySign(vector<int> &nums)
{
    int ans = 1; // Initialize answer to 1
    // Iterate over each element of the vector
    for (int i = 0; i < nums.size(); i++)
    {
        // If element is negative, change answer to -1
        if (nums[i] < 0)
        {
            ans *= -1;
        }
        // If element is zero, answer is 0 and loop is exited
        else if (nums[i] == 0)
        {
            ans = 0;
            break;
        }
    }
    return ans; // Return answer
}

int main()
{
    // Example usage
    vector<int> nums = {-1, -2, -3, -4, 3, 2, 1};
    int ans = arraySign(nums); // Print the sign of the product of the vector
    if (ans == 1)
    {
        cout << "Product is Positive";
    }
    else if (ans == -1)
    {
        cout << "Product is Negative";
    }
    else
    {
        cout << "Product is Zero";
    }
    return 0;
}