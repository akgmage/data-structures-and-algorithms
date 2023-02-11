/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
-104 <= xn <= 104

if it we solve it though simply by recursion it will give time complexity of O(n)
 so we will use divide and conquer approach that leads to O(logn) time complexity
  eg. 3^7 dive seven by two 333 * 333 3 than in 333 divide by two 3 * 3 3 
  on conquering 93 * 93 than again conquer 27 * 27 * 3 final output is 218
*/ 

class Solution {
public:
    double pow(double x, int n)
    {
        if(x==0)return 0;
        if(n==0)return 1;
         double res=pow(x,n/2);
         res=res*res;
        if(n%2)res=x*res;
        return res;
    }
    double myPow(double x, int n) {
        if(n<0)return pow(1/x,n);
        return pow(x,n);
    }
};