'''Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :  Find Number of Good Pairs in Go
Issue Number : #648
Problem statement : Check whether a given string is a Valid Palindrome in Python

Explanation of the below cpp code :

The is_valid_palindrome() function is the same as the one in the previous example, which checks whether a given string is a valid palindrome or not.

The input() function is used to take input from the user.
It displays a prompt message "Enter a string:" and waits for the user to enter a value followed by pressing the Enter key. The entered value is stored in the variable s.

The if statement checks if the input string s is a valid palindrome or not using the is_valid_palindrome() function.
If it is, it prints the message "The string is a valid palindrome", otherwise it prints "The string is not a valid palindrome".

The time complexity of the given code is O(n)

'''
------------------------------------------------------------------------------------------------------//Python code begins here----------------------------------------------------------------------------------------------------------------------------------

def is_valid_palindrome(s):
    s = ''.join(filter(str.isalnum, s)).lower()
    return s == s[::-1]

s = input("Enter a string: ") #Taking input from user

if is_valid_palindrome(s):
    print("The string is a valid palindrome") #True case
else:
    print("The string is not a valid palindrome")  #False case
