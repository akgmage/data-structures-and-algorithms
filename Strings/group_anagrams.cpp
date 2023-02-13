/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

Approach:
1. Go through the list of words
2. Sort each word. All annograms of the word would look the same being sorted.
3. Find matching bucket in map and put the word to it
4. When finished, convert the map to vector of vectors and return it

*/

#include <unordered_map>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::unordered_map<string, vector<string>> hashed_annograms;

        for (const string str: strs) {
            string sorted_letters = sort_letters(str);
            if (hashed_annograms.find(sorted_letters) == hashed_annograms.end()) {
                hashed_annograms[sorted_letters] = vector<string>();
            }
            hashed_annograms[sorted_letters].emplace_back(str);
        }

        vector<vector<string>> result;
        result.reserve(hashed_annograms.size());
        for (const auto kv: hashed_annograms) {
            result.emplace_back(kv.second);
        }
        
        return result;
    }
private:
    string sort_letters(string input) {
        vector<char> chars;
        chars.reserve(input.size());
        for (auto c: input) {
            chars.emplace_back(c);
        }
        sort(chars.begin(), chars.end());
        string result(chars.begin(), chars.end());

        return result;
    }
};
