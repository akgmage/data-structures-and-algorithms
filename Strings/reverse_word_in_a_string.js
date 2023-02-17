/// Problem Statement:
/// You are given a string of length N. You need to reverse the string word by word. There can be multiple spaces between two words and there can be leading or trailing spaces but, in the output, reversed string you need to put a single space between two words, and your reversed string should not contain leading or trailing spaces.

/// Sample Input:   You need to     reverse the  string       word    by  word
/// Expected Output: word by word string the reverse to need You

/// Decalaration of function which will receive string to reverese
function reverseString(inputString) {
    /// Trim function removes all the leading and trailing spaces, Split method store them in the array inputStringArray
    var trimmedString = inputString.trim();
    var inputStringArray = trimmedString.split(" ");

    /// Variable declaration to store the output result
    var outputString = "";

    /// Loop through the array in reverse order to reverse the string, subtracting -1 from length because length starts from 1 but index strats from 0
    for (i = inputStringArray.length - 1; i >= 0; i--) {
        /// If its a first iteration then store the word in variable otherwise concatenate it with the current string
        if (inputStringArray[i] == "") {
            continue;
        } else {
            outputString += inputStringArray[i] + " ";
        }
    }
    return outputString.trim();
}

// console.log("You are given a string of length N");
// console.log(reverseString("You are given a string of length N"));

console.log("  You need to     reverse the  string       word    by  word  ");
console.log(
    reverseString(
        "  You need to     reverse the  string       word    by  word  "
    )
);
