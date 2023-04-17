#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<string>> groupAnagrams(vector<string>& strs) {
    unordered_map<string, vector<string>> mp; // create an unordered map to store anagrams

    // iterate through each string in the input vector
    for (string s : strs) {
        string t = s; // create a copy of the current string
        sort(t.begin(), t.end()); // sort the characters in the copy
        mp[t].push_back(s); // add the original string to the corresponding anagram group
    }

    vector<vector<string>> res; // create a vector to store the anagram groups
    for (auto p : mp) { // iterate through the unordered map
        res.push_back(p.second); // add the anagram group to the result vector
    }

    return res; // return the result vector containing all the anagram groups
}

