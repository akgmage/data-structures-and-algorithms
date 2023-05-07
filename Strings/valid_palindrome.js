/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :Two Pointers: Check whether a given string is a Valid Palindrome in Javascript
Issue Number : #649
Problem statement : 

Explanation of the below Java code :

we first define the isPalindrome() function, which converts the input string to lowercase and removes all non-alphanumeric characters using a regular expression, and then uses two pointers to loop through the string and check whether it is a valid palindrome.

We then use the prompt() function to display a popup dialog box and prompt the user to enter a string input. The input value is then stored in the str variable.

We then call the isPalindrome() function with the input string as an argument to check whether it is a palindrome. If it is, we use the console.log() function to display a message saying that the input string is a palindrome. If it is not, we display a message saying that the input string is not a palindrome.



*/

-------------------------------------------------------------------------------------------------------//Java code begins here-------------------------------------------------------------------------------------------------------------------------------

function isPalindrome(str) {
  // Convert the input string to lowercase and remove non-alphanumeric characters
  str = str.toLowerCase().replace(/[^a-z0-9]/g, '');

  // Initialize two pointers, one starting from the beginning of the string, and the other from the end
  let left = 0;
  let right = str.length - 1;

  // Loop through the string while the pointers haven't crossed each other
  while (left < right) {
    // If the characters at the left and right pointers don't match, the string is not a palindrome
    if (str[left] !== str[right]) {
      return false;
    }

    // Move the pointers towards each other
    left++;
    right--;
  }

  // If the loop finishes, the string is a palindrome
  return true;
}

// Prompt the user for a string input
let str = prompt("Enter a string:");

// Check whether the input string is a palindrome
if (isPalindrome(str)) {
  console.log(`${str} is a palindrome!`);
} else {
  console.log(`${str} is not a palindrome.`);
}
