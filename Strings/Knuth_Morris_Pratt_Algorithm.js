/**The Knuth-Morris-Pratt (KMP) algorithm is a string matching algorithm that efficiently finds occurrences of a pattern within a text. It was developed by Donald Knuth and Vaughan Pratt in 1977.

The key idea behind the KMP algorithm is to take advantage of the information present in the pattern itself to avoid unnecessary character comparisons during the search process. It achieves this by utilizing a preprocessed array called the Longest Proper Prefix which is also Suffix (LPS) array or failure function.

Here's a step-by-step explanation of the KMP algorithm:

1. Preprocessing (Compute LPS Array):
   - Given a pattern of length m, the first step is to compute the LPS array, which holds information about the longest proper prefix that is also a suffix for each position in the pattern.
   - The LPS array is initialized with the first element as 0 and then iteratively calculated for each position of the pattern using the following rules:
     - If the characters at the current position and the previous longest proper prefix suffix match, increment the length of the prefix and store it in the LPS array.
     - If the characters don't match:
       - If the length of the prefix is not zero, move to the previous longest proper prefix suffix and continue the comparison.
       - If the length of the prefix is zero, store 0 in the LPS array for the current position.
   - This preprocessing step is done in O(m) time complexity.

2. Search (Pattern Matching):
   - With the LPS array computed, the search process begins by comparing characters of the text and pattern.
   - Initialize two pointers, i for the text and j for the pattern, both starting from 0.
   - Iterate over the text from left to right until i reaches the end of the text:
     - If the characters at the current positions i and j match, increment both i and j.
     - If j reaches the end of the pattern, a match is found:
       - Store the index (i - j) as an occurrence of the pattern in the text.
       - Move j to the previous longest proper prefix suffix using the LPS array.
     - If the characters at the current positions i and j don't match:
       - If j is not at the beginning of the pattern, move j to the previous longest proper prefix suffix using the LPS array.
       - If j is at the beginning of the pattern, increment i and continue the search.
   - The search process iterates over the text once and performs comparisons using the LPS array, resulting in a time complexity of O(n), where n is the length of the text.

The KMP algorithm provides an efficient way to search for patterns within a text by avoiding redundant comparisons. It achieves this by utilizing the LPS array, which stores information about the pattern's structure. This makes the KMP algorithm more efficient than naive approaches such as the brute-force method, especially when the pattern has repeated characters or subsequences. */

/**
 * Computes the Longest Proper Prefix which is also Suffix (LPS) array for the given pattern.
 * The LPS array is used to determine the longest prefix of the pattern that is also a suffix.
 *
 * @param {string} pattern - The pattern string.
 * @returns {number[]} - The LPS array.
 */
 function computeLPSArray(pattern) {
    const lps = [0]; // Initialize LPS array with the first element as 0.
    let len = 0; // Length of the previous longest prefix suffix.
    let i = 1; // Current index in the pattern string.
  
    while (i < pattern.length) {
      if (pattern[i] === pattern[len]) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len !== 0) {
          // Move len to the previous longest prefix suffix value.
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
  
    return lps;
  }
  
  /**
   * Performs the Knuth-Morris-Pratt (KMP) algorithm to find all occurrences of a pattern within a text.
   *
   * @param {string} text - The text string.
   * @param {string} pattern - The pattern string.
   * @returns {number[]} - An array of indices where the pattern is found within the text.
   */
  function KMP(text, pattern) {
    const m = pattern.length; // Length of the pattern.
    const n = text.length; // Length of the text.
    const lps = computeLPSArray(pattern); // Compute the LPS array for the pattern.
    const indices = []; // Array to store the indices where the pattern is found.
  
    let i = 0; // Current index in the text string.
    let j = 0; // Current index in the pattern string.
  
    while (i < n) {
      if (pattern[j] === text[i]) {
        i++;
        j++;
      }
  
      if (j === m) {
        // Pattern found at index i - j.
        indices.push(i - j);
        j = lps[j - 1]; // Move j to the previous longest prefix suffix value.
      } else if (i < n && pattern[j] !== text[i]) {
        if (j !== 0) {
          j = lps[j - 1]; // Move j to the previous longest prefix suffix value.
        } else {
          i++;
        }
      }
    }
  
    return indices;
  }
  
  // Example usage:
  const text = "ABABDABACDABABCABAB";
  const pattern = "ABABCABAB";
  
  const indices = KMP(text, pattern);
  console.log("Pattern found at indices:", indices);
  
  // Pattern found at indices: [10]

  /**
   
Time Complexity:

The KMP algorithm has a time complexity of O(m + n), where m is the length of the pattern and n is the length of the text. It computes the LPS array in O(m) time and performs a single pass over the text in O(n) time.

Space Complexity:

The space complexity of the KMP algorithm is O(m), where m is the length of the pattern. It is due to the LPS array, which requires O(m) space to store the longest prefix suffix values for each index in the pattern. The additional space used by the algorithm is minimal and does not depend on the input size */