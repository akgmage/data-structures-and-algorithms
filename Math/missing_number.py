# Given an array arr[] of size N with integers in the range of [0, N], the task is to find the missing number
#  from the first N integers.
# Note: There are no duplicates in the list

#ISSUE 1445

# This code  calculates the sum of the given list and the sum of consecutive numbers up to the
#  maximum value. The missing number is obtained by subtracting the list sum from the calculated sum,
#  and it is printed as the output.

# input the list
list1 = list(map(int, input().split()))
# calculate sum of the list
s = sum(list1)
#find the max of the array and calculate sum of n natural numbers
n = max(list1)
ans = (n*(n+1))//2 
print(ans-s)

# Time complexity is O(n)