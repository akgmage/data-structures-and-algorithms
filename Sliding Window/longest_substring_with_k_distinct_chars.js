/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

 */
function longestSubstringWithKDistinctChars(s, k) {
  // Check for edge cases where s is empty, or k is 0.
  if (!s || k === 0) {
    return 0;
  }

  let startWindow = 0; // Initialize the start of the sliding window.
  let maxLen = 0; // Initialize the maximum length of the substring.
  const charCount = {}; // Create an object to store character frequencies.

  for (let endWindow = 0; endWindow < s.length; endWindow++) {
    const right = s[endWindow]; // Get the character at the end of the window.
    charCount[right] = (charCount[right] || 0) + 1; // Update the character count in the object.

    // While there are more than k distinct characters in the window.
    while (Object.keys(charCount).length > k) {
      const left = s[startWindow]; // Get the character at the start of the window.
      charCount[left]--; // Decrease the count of the character.
      if (charCount[left] === 0) {
        delete charCount[left]; // If the count becomes 0, remove the character from the object.
      }
      startWindow++; // Move the start of the window to the right.
    }

    maxLen = Math.max(maxLen, endWindow - startWindow + 1); // Update the maximum length.
  }

  return maxLen;
}

function max(a, b) {
  return a > b ? a : b;
}

console.log(longestSubstringWithKDistinctChars("araaci", 2));
console.log(longestSubstringWithKDistinctChars("araaci", 1));
console.log(longestSubstringWithKDistinctChars("cbbebi", 3));
