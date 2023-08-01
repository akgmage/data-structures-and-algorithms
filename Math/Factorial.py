'''
Approach:
We will take the number as input from the user and calculate its factorial.
To calculate the factorial, we will start from 1 and multiply it with all the numbers from 1 to n.
Finally, we will return the factorial.

Time Complexity: O(n)
Space Complexity: O(1)

Sample Input: 5
Sample Output: Factorial of 5 is 120
'''

# Initializing the factorial to 1
fact = 1
def factorial(num):
  # If the number is 0 or 1, then the factorial is 1.
  if num == 0 or num == 1:
  return 1
  # Calculating factorial by multiplying every number from 1 to num
  for i in range(1, num+1):
    fact *= i
  return fact

#Taking input from user
num = int(input("Enter a number: "))
#Calculating and printing the factorial of the number
print("Factorial of", num, "is", factorial(num))


