#include <iostream>
#include <vector>

using namespace std;

bool isPalindrome(string s, int start, int end) {
    while (start < end) {
        if (s[start] != s[end]) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}

vector<vector<string>> partitionPalindrome(string s) {
    vector<vector<string>> result;
    vector<string> current;

    backtrack(s, 0, current, result);

    return result;
}

void backtrack(string s, int start, vector<string>& current, vector<vector<string>>& result) {
    if (start == s.length()) {
        result.push_back(current);
        return;
    }

    for (int end = start; end < s.length(); end++) {
        if (isPalindrome(s, start, end)) {
            current.push_back(s.substr(start, end - start + 1));
            backtrack(s, end + 1, current, result);
            current.pop_back();
        }
    }
}

int main() {
    string s = "aab";
    vector<vector<string>> partitions = partitionPalindrome(s);

    for (auto partition : partitions) {
        for (string palindrome : partition) {
            cout << palindrome << " ";
        }
        cout << endl;
    }

    return 0;
}
