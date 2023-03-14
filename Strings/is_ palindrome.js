// Check whether a given string is a Valid Palindrome in Javascript

// Two pointer approach
function isPalindromeTwoPointer(inputString) {
  var string = inputString.trim().toLowerCase();

  if (string == "") {
    return false;
  }

  var leftIndex = 0;
  var rightIndex = string.length - 1;
  // compare start and end position
  // if mismatch occurs then return false
  // if mismatch doesnot occur then increment start pointer and decrement end pointer till they meet
  while (leftIndex < rightIndex) {
    if (string[leftIndex] !== string[rightIndex]) {
      return false;
    }
    leftIndex++;
    rightIndex--;
  }
  return true;
}

// Reverse String approach
function isPalindrome(inputString) {
  var stringArray = inputString.trim().toLowerCase().split("");

  var reverseString = "";

  for (i = stringArray.length - 1; i >= 0; i--) {
    reverseString += stringArray[i];
  }

  if (inputString.trim().toLowerCase() == reverseString.trim().toLowerCase()) {
    return true;
  } else {
    return false;
  }
}

// Driver code
console.log(isPalindrome("Kaayak"));
console.log(isPalindromeTwoPointer("Kayak"));
