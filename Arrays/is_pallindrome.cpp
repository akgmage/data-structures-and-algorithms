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
