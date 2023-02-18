// Check whether a given string is a Valid Palindrome in Javascript
function isPalindrome(inputString) {
    var stringArray = inputString.trim().toLowerCase().split("");

    var reverseString = "";

    for (i = stringArray.length - 1; i >= 0; i--) {
        reverseString += stringArray[i];
    }

    if (
        inputString.trim().toLowerCase() == reverseString.trim().toLowerCase()
    ) {
        return true;
    } else {
        return false;
    }
}

// Driver code
console.log(isPalindrome("Kayak"));
