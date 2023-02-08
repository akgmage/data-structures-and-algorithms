# Implement pow(x, n), which calculates x raised to the power n (i.e., xn). in Go

# --- Recursion Approach ---

# Example 1:
# Input: x = 2, n = 10
# Output: 1024

# Example 2:
# Input: x = 2.10000, n = 3
# Output: 9.26100

# Example 3:
# Input: x = 2.00000, n = -2
# Output: 0.25000
# Explanation: 2^(-2) = 1/(2^2) = 1/4 = 0.25

def power(x, n):
    if n == 0: return 1
    elif n<0: return power(1/x, -n)
    else: return (x*power(x, n-1))


if __name__ == '__main__':
    x = 2
    n = 3
    print(power(x, n))