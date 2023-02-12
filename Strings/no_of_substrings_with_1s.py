# ----------------------------------------------------------------
# 1513. Number of Substrings With Only 1s
# ----------------------------------------------------------------

"""
Input -> A binary string
Output -> An integer

The goal of the problem is to find out the number of substrings in the 
given binary string that consists of 1's only. For example :

Sample Input: 

a) Input 1 = "0110111"
   Output 1 = 9
   There are 9 substrings in total with only 1's characters

b) Input 2 = "101"
   Output 2 = 2
   There are 2 substrings in total with only 1's characters

c) Input 3 = "1"
   Output 3 = 1
   There is only one substring in this string that contains 1

d) Input 4 = "111111"
   Output 4 = 21
   There is only 12 substrings in this string that contain only 1's


How to tackle this problem?

Solution 1)
 
This is the brute force solution and is extremely simple. We look at all
the substrings and simply decide which one ha only 1's by iterating
over each individual substring. This however is a tedious solution and
not very optimised. The time complexity for this solution would be 
O(N^3). This is not a good solution. However, it is the first solution that
comes to mind.

Solution 2)

We can take advantage of a built in python function. This function is
str.slpit(), it splits a string into an array depending upon the breakpoint 
that we provide it. What we can do is, split the string by 0's. This results
in an array that consists of all the substrings in the array that 
consist of 1's only. We can now start to notice a pattern with.

If Input = "1" Output = 1
If Input = "11" Output = 2
If Input = "111" Output = 6
If Input = "1111" Output = 10
If Input = "11111" Output = 15

By looking at the above results we can state that the number of 
substrings in a given string can be calculated by using ((n*(n+1) )/ 2)

This leads to another fact, that we dont really need to find all of the 
substrings to find their total. The time complexity for this approach will be
O(N) which is much better than ourbrute force approach. 

**Note : This approach can be used in any other language as well

Coding the second approach

"""


class Solution:
    def numSub(self, s: str) -> int:
        # This will get us all the subtrings that contain 1's only
        substrings = s.split("0")

        sub_sum = 0
        for substring in substrings:
            sub_sum += len(substring) * (len(substring) + 1) // 2
            # Implementing the formula that we derived above
        return sub_sum
        # finally return the sum


"""
Another problem that we face is when we try to run the above code
on leetcode, it will not pass all the test cases.

Short Answer: The numbers get too big and it simply overflows. 
To avoid this overflow, we use the modulo operator.

Long Answer: We use the expression -> num % (10 ** 9 + 7) calculates the remainder of 
num divided by 10 ** 9 + 7. The value 10 ** 9 + 7 is a large constant that 
is used as the modulo. The purpose of taking the modulo is to avoid large numbers that might 
overflow the maximum value that can be stored in an integer data type.
When the result of an operation is larger than the maximum value that can 
be stored in an integer, the result wraps around to a negative value. 
Taking the modulo avoids this issue by reducing the result to a value that 
can be stored in an integer data type.


To fix this issue simply replace the return statement with the below line

return sub_sum % (10 ** 9 + 7)

"""
