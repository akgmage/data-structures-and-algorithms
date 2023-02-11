# Given an integer n, return the number of prime numbers that are strictly less than n.
# Program Author: https://github.com/abhis1n

# Solution- We will be using Sieve of Eratosthenes to solve the given problem

class Solution:
    def countPrimes(self, n: int) -> int:
        # First we declare an array of
        # size n and initialize all of
        # its values with False
        nums = [False] * n

        # Storing primes in ans variable
        ans = 0

        for num in range(2, n):
            # if the num index in nums list
            # is True, if block runs and loop
            # is continued to next iteration
            if nums[num]:
                continue

            # else if the num index in nums list
            # is False, ans variable is incremented
            # by 1 and the indexes of all values
            # greater than num and divisible by num
            # are updated with True value, since they
            # can not be prime
            else:
                ans += 1
                nums[num*num:n:num] = [True] * ((n - 1) // num - num + 1)

        return ans

if __name__=='__main__':
        n = int(input())
        solution = Solution()
        answer = solution.countPrimes(n)
        print(answer)