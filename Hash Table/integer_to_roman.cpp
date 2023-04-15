#include <iostream>
#include <unordered_map>
using namespace std;

string intToRoman(int num) {
    // Initialize the mapping between integers and Roman numerals
    unordered_map<int, string> map = {
        {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"},
        {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"},
        {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
    };
    
    // Initialize an empty string to store the result
    string result = "";
    
    // Loop through the map from the largest number to the smallest
    for (auto it = map.rbegin(); it != map.rend(); ++it) {
        // Check if the current number can be divided by the key of the map
        while (num >= it->first) {
            // Append the corresponding Roman numeral to the result string
            result += it->second;
            // Subtract the key from the number
            num -= it->first;
        }
    }
    
    return result;
}

int main() {
    int num = 1994;
    cout << intToRoman(num) << endl; // Output: "MCMXCIV"
    return 0;
}
