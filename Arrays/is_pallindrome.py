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
