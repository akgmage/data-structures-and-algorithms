# Valid Palindrome
'''
    1 The isPalindrome() function takes a string s as input.
    2 The first line of the function converts the string to lowercase and 
      removes all non-alphanumeric characters. This is achieved using a list comprehension, 
      where each character in s is checked if it is alphanumeric. 
      If it is, it is added to a new string, otherwise it is ignored. 
      The resulting string only contains alphanumeric characters in lowercase.
    3 We then loop through the string from the beginning to the middle character 
      (the // operator divides the length of the string by 2 and rounds down to the nearest integer). 
      For each character, we compare it to its corresponding character from the end of the string 
      (i.e., the len(s) - i - 1-th character), to check if they are the same.
    4 If at any point we find two characters that are not the same, we know that the string is not a 
      palindrome and return False.
    5 If we complete the loop without finding any mismatches, we know that the string is a palindrome 
      and return True.
'''
public static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (!Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        } else if (!Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        } else {
            left++;
            right--;
        }
    }
    return true;
}
