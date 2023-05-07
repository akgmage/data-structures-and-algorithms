// Group Anagrams
/*
    The function groupAnagrams takes a vector of strings strs as input and returns a vector of vectors of strings res, 
    where each inner vector contains a group of anagrams.

    We create an unordered map mp to store the anagram groups. The keys of the map are the sorted versions of the anagrams, 
    and the values are vectors containing the original strings that belong to that anagram group.

    We iterate through each string in the input vector strs, create a copy of the string t, sort the characters in the copy t, 
    and add the original string s to the corresponding anagram group in the unordered map mp.

    We create a vector res to store the anagram groups and iterate through the unordered map mp. For each anagram group in the map, 
    we add the corresponding vector of original strings to the res vector.

    We return the result vector res containing all the anagram groups.

    In the main function, we create an example input vector strs, call the groupAnagrams function and store the result in the 
    output vector output, and iterate through the output vector to print each anagram group.
    
	The time complexity of this implementation is O(n * k log k), where n is the length of the input array and k is the 
    length of the longest string in the array. This is due to the time complexity of sorting each string in the array.

	The space complexity of this implementation is O(n * k), as we need to store each string in the map along with its corresponding group of anagrams.

*/
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

int main() {
    // create an example input vector
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    // call the groupAnagrams function and store the result in the output vector
    vector<vector<string>> output = groupAnagrams(strs);

    // iterate through the output vector and print each anagram group
    for (vector<string> group : output) {
        for (string s : group) {
            cout << s << " ";
        }
        cout << endl;
    }

    return 0;
}
