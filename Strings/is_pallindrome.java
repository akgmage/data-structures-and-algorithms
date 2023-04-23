/*
    Write a function that takes in a non-empty string and that returns a boolean
    representing whether the string is a palindrome.
    Sample Input: abba
    Output: True
    Sample Input: aberba
    Output: False
    
    Explanation:
    This function takes in a non-empty string and returns a boolean representing whether the string 
    is a palindrome. It first removes all non-alphanumeric characters from the string and converts 
    it to lowercase using the replaceAll() and toLowerCase() string methods, respectively.

    It then initializes two pointers, one at the beginning and one at the end of the cleaned string. 
    It iterates through the string from both ends, comparing characters at each step. 
    If the characters do not match, it returns false.

    If the loop completes without returning false, the string is a palindrome and the function 
    returns true.
*/
/**
 * This function takes in a non-empty string and returns a boolean representing
 * whether the string is a palindrome.
 * 
 * @param str the string to check for palindrome
 * @return true if str is a palindrome, false otherwise
 */
public static boolean isPalindrome(String str) {
    // Remove all non-alphanumeric characters from the string and convert to lowercase
    String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    // Initialize two pointers, one at the beginning and one at the end of the string
    int left = 0;
    int right = cleanStr.length() - 1;

    // Iterate through the string from both ends, comparing characters
    while (left < right) {
        if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    // If the loop completes without returning false, the string is a palindrome
    return true;
}
