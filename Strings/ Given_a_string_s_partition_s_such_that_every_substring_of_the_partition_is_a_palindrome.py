"""Name : Veena
# GitHub username : Veena4512
# Repository name : data-structures-and-algorithms
# Problem :  Given a string s, partition s such that every substring of the partition is a palindrome in Python
# Issue Number : #1374
"""

"""The minimum_partitions function is a dynamic programming solution that calculates the minimum number of partitions 
needed for a given string a, where each partition is a palindrome. It uses two arrays, dp and palindrome, 
to store the intermediate results. The function iterates over each position in the string, checking if the substring 
is a palindrome and updating the minimum cuts accordingly. Finally, it returns the minimum number of partitions 
needed for the entire string. The solution leverages the concept of overlapping problems to efficiently compute 
the minimum partitions using dynamic programming. """


# using DP:
def minimum_partitions(a):
    # Check if the input list is empty
    if len(a) == 0:
        return 0

    # Initialize an array to store the minimum number of partitions
    dp = [0 for i in range(len(a))]

    # Initialize a 2D array to store whether a substring is a palindrome or not
    palindrome = [[False for i in range(len(a))] for j in range(len(a))]

    # Iterate over the input list
    for i in range(len(a)):
        cut = i  # Initialize the minimum number of partitions to the current index

        # Iterate over the substring from 0 to the current index
        for j in range(i + 1):
            # Check if the characters at indices i and j are equal
            # and the substring between i and j is a palindrome
            if a[i] == a[j] and (i - j < 2 or palindrome[j + 1][i - 1]):
                palindrome[j][i] = True  # Mark the substring as a palindrome
                cut = min(cut, 0 if j == 0 else (dp[j - 1] + 1))  # Update the minimum number of partitions
        dp[i] = cut  # Store the minimum number of partitions for the current index

    return dp[len(a) - 1]

s = input()
print('Minimum cuts needed for Palindrome Partitioning is', minimum_partitions(s))

# Time complexity:O(n^2)
# Space complexity:The space complexity of the code is O(n^2) due to the usage of the 2D array 
#                 palindrome, which dominates the space requirement, while the array dp contributes 
#                 O(n) to the overall space complexity.

