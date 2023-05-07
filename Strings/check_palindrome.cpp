#include <iostream>
#include <string>

using namespace std;

// 2 pointer approach to find if a number is palindrome or not
// Time complexity O(n), Space complexity O(1).

int palindrome_checker(string str)          // palindrome checker function
{
    int left = 0;
    int right = str.length() - 1;           // initializing left and right variables
    while(left < right) 
    {
        if(str[left] != str[right])
        {
            return 0;
        }
        left = left + 1;                    // updating left and right variables
        right = right - 1;
    }
    return 1;
}

int main()
{
    string str;
    cin>>str;
    int isPal = palindrome_checker(str);    // calling palindrome checker function
    if(isPal == 1)
    {
        cout<<"String is palindrome";
    }
    else
    {
        cout<<"String is not palindrome";
    }
    return 0;
}