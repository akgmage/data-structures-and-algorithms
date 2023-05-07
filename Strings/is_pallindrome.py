'''
    Write a function that takes in a non-empty string and that returns a boolean
    representing whether the string is a palindrome.
    Sample Input: abba
    Output: True
    Sample Input: aberba
    Output: False

    Explanation:

    In this implementation, we use Python's filter() function to remove all non-alphanumeric characters 
    from the string and lower() method to convert the string to lowercase. Then we check if the reversed 
    string is equal to the original string using the slice notation [::-1]. If the two strings are equal, 
    we return True, indicating that the input string is a palindrome; otherwise, we return False.
'''

def is_palindrome(s: str) -> bool:
    """
    This function takes in a non-empty string and returns a boolean indicating
    whether the string is a palindrome or not.
    
    Parameters:
    s (str): The input string
    
    Returns:
    bool: True if s is a palindrome, False otherwise
    """
    # Remove all non-alphanumeric characters and convert to lowercase
    s = ''.join(filter(str.isalnum, s)).lower()
    
    # Check if the reversed string is equal to the original string
    return s == s[::-1]
