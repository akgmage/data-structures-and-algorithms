/* Valid Palindrome

1 We define a method isPalindrome that takes a String argument s and returns a boolean value indicating whether the string is a palindrome or not.
2 We initialize two variables left and right to point to the beginning and end of the string respectively.
3 We enter a while loop that continues until left is less than right.
4 If the character at s[left] is not a letter or digit, we increment left.
5 If the character at s[right] is not a letter or digit, we decrement right.
6 If the characters at s[left] and s[right] are not equal, we return false as the string is not a palindrome.
7 If the characters are equal, we increment left and decrement right.
8 If the while loop completes without finding a mismatched pair of characters, we return true as the string is a palindrome.

*/
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
