/*
    Write a function that takes in a non-empty string and that returns a boolean
    representing whether the string is a palindrome.
    Sample Input: abba
    Output: True
    Sample Input: aberba
    Output: False
    
    Explanation:
    we define a function isPalindrome that takes in a string and returns true if the string is a palindrome, 
    and false otherwise. The function uses two indices, left and right, initialized to the beginning and 
    end of the string respectively. It then iterates through the string by moving the left index to the 
    right and the right index to the left, checking whether the characters at these indices match. 
    If the characters do not match, the function returns false, indicating that the string is not a 
    palindrome. If the entire string is iterated through and all characters match,
    the function returns true, indicating that the string is a palindrome.

    In the main function, we call the isPalindrome function on the string "racecar" and print the result. 
    The output will be "racecar is a palindrome".
*/
#include <iostream>
#include <string>

using namespace std;

/**
 * @brief Function to check whether a string is a palindrome or not
 * 
 * @param str String to check
 * @return true if the string is a palindrome, false otherwise
 */
bool isPalindrome(string str) {
    int left = 0; // initialize left index to 0
    int right = str.length() - 1; // initialize right index to last character

    while (left < right) { // while left index is less than right index
        if (str[left] != str[right]) { // if characters at left and right indices do not match
            return false; // the string is not a palindrome
        }
        left++; // move left index to the right
        right--; // move right index to the left
    }
    return true; // the string is a palindrome
}

int main() {
    string str = "racecar";
    bool isPal = isPalindrome(str);
    if (isPal) {
        cout << str << " is a palindrome" << endl;
    } else {
        cout << str << " is not a palindrome" << endl;
    }
    return 0;
}
