/*
    You're given two strings stringone and stringtwo. Write a function that determines if these
	two strings can be made equal using only one edit.


    There are 3 possible edits:
    Replace: One character in one string is swapped for a different character.
    Add:: One character is added at any index in one string.
    Remove: One character is removed at any index in one string.

	Sample Input: StringOne: alaska StringTwo: aloska
	Output: True


	Explanation:
	The code snippet is implementing the "One Edit Away" algorithm, which determines whether two given
	strings are one edit away from each other. An edit is defined as either inserting a character, removing a character, or replacing a character.

	The `OneEdit` function takes two strings as input and returns a boolean indicating whether
	they are one edit away. Here's the breakdown of the algorithm:

	1. Calculate the lengths of the two strings.
	2. Check if the difference in lengths is greater than 1. If so, return `false` because it's
	   not possible to make one edit to make the strings equal.
	3. Traverse both strings until the shorter one is fully traversed or an unequal character is
	found.
	4. If an unequal character is found, check the remaining portion of the strings to determine
	   if they are still one edit away.
	5. Check the remaining characters in the longer string compared to the remaining characters
	   in the shorter string.
	6. Return `true` if the remaining portions match, indicating they are one edit away.
	7. If the loop completes without finding any unequal characters, the strings are either
	   identical or differ only in length by 1, which means they are one edit away.
	8. The `abs` and `min` functions are utility functions used to calculate the absolute value
	   and minimum of two integers, respectively.

	The algorithm efficiently checks for the possibility of one edit by comparing the characters at corresponding indices and handling cases where the lengths of the strings are different.

	O(n) time | O(1) space - where n is the length of the shorter string


*/
function isOneEdit(stringOne, stringTwo) {
  const lengthOne = stringOne.length;
  const lengthTwo = stringTwo.length;

  // Check the difference in lengths between the two strings.
  // If the difference is greater than 1, it is not possible to make one edit to make them equal.
  if (Math.abs(lengthOne - lengthTwo) > 1) {
    return false;
  }

  // Traverse the strings until the shorter one is fully traversed or an unequal character is found.
  for (let i = 0; i < Math.min(lengthOne, lengthTwo); i++) {
    // If an unequal character is found, check the remaining portion of the strings to determine if they are still one edit away.
    if (stringOne[i] !== stringTwo[i]) {
      // Check the remaining characters in the longer string compared to the remaining characters in the shorter string.
      // Return true if they match, indicating they are one edit away.
      if (lengthOne > lengthTwo) {
        return stringOne.slice(i + 1) === stringTwo.slice(i);
      } else if (lengthTwo > lengthOne) {
        return stringTwo.slice(i + 1) === stringOne.slice(i);
      } else {
        return stringOne.slice(i + 1) === stringTwo.slice(i + 1);
      }
    }
  }

  // If the loop completes without finding any unequal characters, the strings are either identical or differ only in length by 1.
  return true;
}

const stringOne = "pale";
const stringTwo = "ple";

// Check if the strings are one edit away
const isOneEdit = isOneEdit(stringOne, stringTwo);

// Print the result
console.log(`The strings are${isOneEdit ? "" : " not"} one edit away.`);
