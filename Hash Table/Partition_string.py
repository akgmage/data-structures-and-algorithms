def is_palindrome(s):
    return s == s[::-1]

def min_partition(s):
    n = len(s)
    
    # Create a hash table to store the results of subproblems
    # dp[i] represents the minimum number of partitions in s[0:i]
    dp = [float('inf')] * (n + 1)
    dp[0] = 0
    
    # Iterate through the string
    for i in range(1, n + 1):
        # Check all possible substrings s[j:i]
        for j in range(i):
            # If s[j:i] is a palindrome, update the minimum number of partitions
            if is_palindrome(s[j:i]):
                dp[i] = min(dp[i], dp[j] + 1)
    
    # Return the minimum number of partitions for the entire string
    return dp[n] - 1

# Example usage
string = "aabba"
optimal_partitions = min_partition(string)
print("Optimal number of partitions:", optimal_partitions)


'''
The min_partition function utilizes dynamic programming to find the minimum number of partitions in the given string s. It iterates through each character in the string and checks all possible substrings. If a substring is a palindrome, it updates the minimum number of partitions accordingly.

Note that the dp list is initialized with float('inf') values, except for the first element dp[0], which is set to 0. The final result subtracts 1 from dp[n] to account for the fact that the last character does not require a partition.



The time complexity of the given solution is O(n^3), where n is the length of the input string s. This is because there are two nested loops, and for each combination of i and j, the is_palindrome function is called, which has a time complexity of O(n). Hence, the overall time complexity is O(n^3).

The space complexity of the solution is O(n), where n is the length of the input string s. This is because the dp list, used to store the minimum number of partitions for each substring, has a length of n + 1. Therefore, the space required is linearly proportional to the length of the input string.
'''
