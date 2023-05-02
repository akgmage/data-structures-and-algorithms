'''
In the code I implemented a solution using Floyd's Tortoise and Hare algorithm 
for finding the first integer that appears more than once in an array of integers. 

The first solution has a time complexity of O(n) and a space complexity of O(1). 
It uses the fact that the integers in the array are between 1 and n, inclusive, where n is the length of the array. 
The solution works by using the array itself as a hash table, 
by marking an integer as negative if it is encountered for the first time, 
and returning it if it is already marked negative. 

'''

def find_duplicate(nums):
    slow = fast = nums[0]
    while True:
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast:
            break
    
    slow = nums[0]
    while slow != fast:
        slow = nums[slow]
        fast = nums[fast]
    
    return slow
