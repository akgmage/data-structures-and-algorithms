/* 
Two Pointers: Check whether a given string is a Valid Palindrome in Java 
*/


/* EXPLAINATION: 
The function isPalindrome takes a String input and returns a boolean indicating whether the input string is a palindrome or not.

The function initializes two integer variables, startIdx and endIdx, to the first and last indices in the string, respectively. It then enters a loop that continues while startIdx is less than endIdx.

Inside the loop, the function gets the characters at the start and end indices using the charAt method. It then checks if the lowercase versions of these characters match using the toLowerCase method. If they do not match, the function immediately returns false, indicating that the string is not a palindrome.

If the loop completes without returning false, the function returns true, indicating that the input string is a palindrome.

The time complexity of the function is O(n), where n is the length of the input string. This is because the function loops through half the length of the string in the worst case.

The space complexity of the function is O(1), as it uses a constant amount of additional memory to keep track of the start and end indices.
*/



public static boolean isPalindrome(String str)
{
    // initialize startIdx to 0 and endIdx to the last index in the string
    int startIdx = 0;
    int endIdx = str.length() - 1;		
    
    // loop through the string while the start index is less than the end index
    while(startIdx < endIdx)
    {
        // get the characters at the start and end indices
        char start = str.charAt(startIdx);
        char end = str.charAt(endIdx);
        
        // if the lowercase versions of the characters do not match, return false
        if(Character.toLowerCase(start) != Character.toLowerCase(end))
            return false;
        
        // increment the start index and decrement the end index
        startIdx += 1;
        endIdx -= 1;
    }
    
    // if the loop completes without returning false, the string is a palindrome so return true
    return true;
}
