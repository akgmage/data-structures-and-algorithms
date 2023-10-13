'''
   Given two strings str1 and str2 and following three operations that can performed on str1.
   1) Insert
   2) Remove
   3) Replace
   Find minimum number of operations required to convert ‘str1’ into ‘str2’.
   For example if input strings are CAT AND CAR the edit distance is 1.

   Input  :  s1 : saturday  s2 : sunday
   Output :  3
*/
// Dynamic Programming Solution : TC O(n^2)
'''
# Function to find the minimum edit distance between two strings
def find_edit_distance(s1, s2):
    l1, l2 = len(s1), len(s2)

    # Create a 2D list dp to store the edit distances
    dp = [[0] * (l2 + 1) for _ in range(l1 + 1)]

    # Initialize the base cases for empty strings
    for i in range(l1 + 1):
        dp[i][0] = i  # Minimum edit distance for transforming s1[0...i] to an empty string
    for i in range(l2 + 1):
        dp[0][i] = i  # Minimum edit distance for transforming an empty string to s2[0...i]

    # Calculate the edit distance for the rest of the strings
    for i in range(1, l1 + 1):
        for j in range(1, l2 + 1):
            if s1[i - 1] == s2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]  # No edit required if characters match
            else:
                del_op = dp[i][j - 1]  # Deletion (from s2)
                replace_op = dp[i - 1][j - 1]  # Replacement (of s1[i] with s2[j])
                insert_op = dp[i - 1][j]  # Insertion (into s1)
                dp[i][j] = min(del_op, min(replace_op, insert_op)) + 1  # Choose the minimum of the three operations

    # Print the edit distance matrix (optional)
    for i in range(l1 + 1):
        print(" ".join(map(lambda value: f"{value:5}", dp[i])))

    return dp[l1][l2]  # Return the minimum edit distance

# Example usage
s1 = "abhisek"
s2 = "tsunade"

result = find_edit_distance(s1, s2)
print("Minimum Edit Distance:", result)
