/*
	Group Anagrams

	Sample Input:  = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
	Output: [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]

	Explanation:

	The code snippet is a function that groups anagrams together. An anagram is a word or phrase formed by rearranging
	the letters of another word or phrase.

	The function first defines two functions: GroupAnagrams and sortWord. The GroupAnagrams function takes a list of words
	as input and returns a list of lists, where each inner list contains all the anagrams of a word in the original list.
	The sortWord function takes a word as input and returns a string that contains the word's letters in sorted order.

	The GroupAnagrams function works by first creating a map where the keys are sorted strings of words and the values are
	lists of words that have the same sorted string. Then, the function iterates through the list of words, calling the
	sortWord function to get the sorted string for each word. The function then adds the word to the list of words associated with the sorted string in the map. Finally, the function iterates through the map, adding each list of words to a list of lists.

	The sortWord function works by converting the word to a byte array and then calling the sort.Slice function to sort
	the byte array. The function then returns a string that contains the sorted byte array.

	O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word

*/
function sortWord(word) {
  // Sort the characters in the word and return the sorted string
  return word.split("").sort().join("");
}

function groupAnagrams(words) {
  // Create an object where the keys are sorted strings of words and the values are arrays of words
  // that have the same sorted string.
  const anagrams = {};

  // Iterate through the words
  for (const word of words) {
    // Get the sorted string for the word
    const sortedWord = sortWord(word);

    // Add the word to the array associated with the sorted string in the object
    if (!anagrams[sortedWord]) {
      anagrams[sortedWord] = [];
    }
    anagrams[sortedWord].push(word);
  }

  // Create an array of arrays, where each inner array contains all the anagrams of a word in the original array
  const result = Object.values(anagrams);

  // Return the array of arrays
  return result;
}

// Example usage
const words = ["eat", "tea", "tan", "ate", "nat", "bat"];
const groupedAnagrams = groupAnagrams(words);

// Print the grouped anagrams
for (const group of groupedAnagrams) {
  console.log(group);
}
