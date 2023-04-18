/**
 * Given an array of strings, group anagrams together and return them as an array of arrays.
 *
 * @param {string[]} strs - The input array of strings.
 * @returns {string[][]} - An array of arrays of anagrams.
 */
function groupAnagrams(strs) {
  // Create an empty object to store groups of anagrams.
  const anagramGroups = {};

  // Loop through each string in the input array.
  for (const str of strs) {
    // Sort the characters of the string alphabetically and use the sorted string as a key.
    const sortedStr = str.split("").sort().join("");

    // If a group for the sorted string doesn't exist yet, create it as an empty array.
    if (!anagramGroups[sortedStr]) {
      anagramGroups[sortedStr] = [];
    }

    // Add the original string to the group of anagrams.
    anagramGroups[sortedStr].push(str);
  }

  // Return the values of the anagram groups object as an array.
  return Object.values(anagramGroups);
}
