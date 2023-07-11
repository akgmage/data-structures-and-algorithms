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

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

// Function to sort a word and return the sorted string
std::string sortWord(const std::string& word) {
    std::string sortedWord = word;
    std::sort(sortedWord.begin(), sortedWord.end());
    return sortedWord;
}

// Function to group anagrams together
std::vector<std::vector<std::string>> GroupAnagrams(const std::vector<std::string>& words) {
    // Create a map where the keys are sorted strings of words and the values are lists of words
    // that have the same sorted string.
    std::unordered_map<std::string, std::vector<std::string>> anagrams;

    // Iterate through the words
    for (const std::string& word : words) {
        // Get the sorted string for the word
        std::string sortedWord = sortWord(word);

        // Add the word to the list of words associated with the sorted string in the map
        anagrams[sortedWord].push_back(word);
    }

    // Create a vector of vectors, where each inner vector contains all the anagrams of a word in the original list
    std::vector<std::vector<std::string>> result;
    for (const auto& pair : anagrams) {
        result.push_back(pair.second);
    }

    // Return the vector of vectors
    return result;
}

int main() {
    // Example usage
    std::vector<std::string> words = { "eat", "tea", "tan", "ate", "nat", "bat" };
    std::vector<std::vector<std::string>> groupedAnagrams = GroupAnagrams(words);

    // Print the grouped anagrams
    for (const std::vector<std::string>& group : groupedAnagrams) {
        for (const std::string& word : group) {
            std::cout << word << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}
