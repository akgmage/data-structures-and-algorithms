/*
   Given two strings str1 and str2 and following three operations that can performed on str1.
   1) Insert
   2) Remove
   3) Replace
   Find minimum number of operations required to convert ‘str1’ into ‘str2’.
   For example if input strings are CAT AND CAR the edit distance is 1.

   Input  :  s1 : saturday  s2 : sunday
   Output :  3
*/
// Dynamic Programming Solution : TC O(n^2)
// Function to find the minimum edit distance between two strings
function findEditDistance(s1, s2) {
  const l1 = s1.length;
  const l2 = s2.length;

  // Create a 2D array dp to store the edit distances
  const dp = Array.from({ length: l1 + 1 }, () => Array(l2 + 1).fill(0));

  // Initialize the base cases for empty strings
  for (let i = 0; i <= l1; i++) {
    dp[i][0] = i; // Minimum edit distance for transforming s1[0...i] to an empty string
  }
  for (let i = 0; i <= l2; i++) {
    dp[0][i] = i; // Minimum edit distance for transforming an empty string to s2[0...i]
  }

  // Calculate the edit distance for the rest of the strings
  for (let i = 1; i <= l1; i++) {
    for (let j = 1; j <= l2; j++) {
      if (s1[i - 1] === s2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1]; // No edit required if characters match
      } else {
        const del = dp[i][j - 1]; // Deletion (from s2)
        const replace = dp[i - 1][j - 1]; // Replacement (of s1[i] with s2[j])
        const insert = dp[i - 1][j]; // Insertion (into s1)
        dp[i][j] = Math.min(del, Math.min(replace, insert)) + 1; // Choose the minimum of the three operations
      }
    }
  }

  // Print the edit distance matrix (optional)
  for (let i = 0; i <= l1; i++) {
    console.log(
      dp[i].map((value) => value.toString().padStart(5, " ")).join(" ")
    );
  }

  return dp[l1][l2]; // Return the minimum edit distance
}

// Example usage
const s1 = "abhisek";
const s2 = "tsunade";

const result = findEditDistance(s1, s2);
console.log("Minimum Edit Distance:", result);
