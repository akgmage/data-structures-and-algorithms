/*
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
Input Format :

The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains a string, that denotes the value of the pattern p.

Output Format :

The first and only line of output contains true if the pattern is present and false otherwise.

Constraints:

Time Limit: 1 sec

Sample Input 1 :

4
abc def ghi cba
de

Sample Output 2 :

true

Sample Input 2 :

4
abc def ghi hg
hi

Sample Output 2 :

true

Sample Input 3 :

4
abc def ghi hg
hif

Sample Output 3 :

false

Explaination :
    The TrieNode class represents a single node in the Trie. Each node contains a character data, an array of pointers to its child nodes children, and a boolean flag isTerminal to indicate if a word ends at that node.

    The Trie class serves as the main data structure and contains a pointer to the root node of the Trie, along with a count variable to keep track of the number of words inserted.

    The insertWord function is used to insert a word into the Trie. It takes a root parameter representing the current node and a word parameter representing the word to be inserted. The function recursively traverses the Trie, creating new nodes as needed and marking the last node as terminal if the word does not already exist.

    The search function is used to search for a word in the Trie. It takes a root parameter and a word parameter. The function recursively checks if each character in the word exists as a child node starting from the given root.

    The patternMatching function takes a vector of strings vect and a pattern string. It iterates over each word in the vector and inserts all possible substrings of that word into the Trie. Finally, it performs a search operation on the pattern string in the Trie and returns the result.
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class TrieNode
{
public:
    char data;
    TrieNode **children;
    bool isTerminal;

    TrieNode(char data)
    {
        this->data = data;
        children = new TrieNode *[26];
        for (int i = 0; i < 26; i++)
        {
            children[i] = NULL;
        }
        isTerminal = false;
    }
};

class Trie
{
    TrieNode *root;

public:
    int count;

    Trie()
    {
        this->count = 0;
        root = new TrieNode('\0');
    }

    bool insertWord(TrieNode *root, string word)
    {
        // Base case
        if (word.size() == 0)
        {
            if (!root->isTerminal)
            {
                root->isTerminal = true;
                return true;
            }
            else
            {
                return false;
            }
        }

        // Small calculation
        int index = word[0] - 'a';
        TrieNode *child;
        if (root->children[index] != NULL)
        {
            child = root->children[index];
        }
        else
        {
            child = new TrieNode(word[0]);
            root->children[index] = child;
        }

        // Recursive call
        return insertWord(child, word.substr(1));
    }

    void insertWord(string word)
    {
        if (insertWord(root, word))
        {
            this->count++;
        }
    }

    bool search(TrieNode *root, string word)
    {
        if (word.length() == 0)
        {
            return true;
        }
        if (root->children[word[0] - 'a'] == NULL)
        {
            return false;
        }
        bool ans = search(root->children[word[0] - 'a'], word.substr(1));
        return ans;
    }

    bool search(string word)
    {
        return search(root, word);
    }

    bool patternMatching(vector<string> vect, string pattern)
    {
        for (int i = 0; i < vect.size(); i++)
        {
            string word = vect[i];
            for (int j = 0; j < word.size(); j++)
            {
                insertWord(word.substr(j));
            }
        }
        return search(pattern);
    }
};

int main()
{
    Trie t;
    int n;
    cin >> n;
    string pattern;
    vector<string> vect;

    for (int i = 0; i < n; ++i)
    {
        string word;
        cin >> word;
        vect.push_back(word);
    }
    cin >> pattern;

    cout << (t.patternMatching(vect, pattern) ? "true" : "false");
}