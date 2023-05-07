// Group Anagrams
/*
    The function groupAnagrams takes an array of strings strs as input, and returns an array of arrays of anagrams. 
    The approach taken is to sort the characters of each string alphabetically, and group strings with the same sorted form together. 
    The resulting groups are stored in an object anagramGroups whose keys are the sorted strings and whose values are arrays of the original strings. 
    Finally, the values of the anagramGroups object are returned as an array.

    To accomplish the sorting and grouping, the split, sort, and join methods are used. First, each string is split into an array of its characters 
    using the split method. Then, the sort method is used to sort the characters alphabetically. Finally, the join method is used to combine the 
    sorted characters back into a string. This sorted string is used as the key for grouping the anagrams in the anagramGroups object.

    The for...of loop is used to iterate over each string in the input array. Inside the loop, the sorted form of the string is computed, 
    and a check is made to see if a group for the sorted form already exists in the anagramGroups object. If it doesn't, a new group is 
    created as an empty array. Then, the original string is added to the appropriate group in the anagramGroups object using the push method.

    Finally, the Object.values method is used to extract the arrays of anagrams from the anagramGroups object, and these arrays are 
    returned as the final result.

	The time complexity of this implementation is O(n * k log k), where n is the length of the input array and k is the length of the longest string in the array. This is due to the time complexity of sorting each string in the array.

	The space complexity of this implementation is O(n * k), as we need to store each string in the map along with its corresponding group of anagrams.

*/
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

const words = ["eat", "tea", "tan", "ate", "nat", "bat"];
console.log(groupAnagrams(words));
