/*
Implement the function SearchWord for the Trie class.
For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.
Note : main function is given for your reference which we are using internally to test the code.

Explaination :
    The given code implements a Trie data structure and focuses on implementing the search functionality. The TrieNode class represents a single node in the Trie, and the Trie class serves as the main data structure.

    The insertWord function is used to insert a word into the Trie. It takes a root parameter representing the current node and a word parameter representing the word to be inserted. The function recursively traverses the Trie, creating new nodes as needed and marking the last node as terminal.

    The search function is used to search for a word in the Trie. It takes a root parameter and a word parameter. The function recursively checks if each character in the word exists as a child node starting from the given root. It returns true if the word is found and the last node is marked as terminal, otherwise it returns false.

    In the main function, an instance of the Trie class is created. The program then enters a loop where the user can input commands. The user is prompted to enter a choice: 1 for inserting a word or 2 for searching a word. If the choice is 1, the user can enter a word to be inserted into the Trie. If the choice is 2, the user can enter a word to search for in the Trie. The result of the search operation is printed as "true" or "false" accordingly.
*/
#include <iostream>
#include <string>
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
    Trie()
    {
        root = new TrieNode('\0');
    }

    void insertWord(TrieNode *root, string word)
    {
        // Base case
        if (word.size() == 0)
        {
            root->isTerminal = true;
            return;
        }

        // Small Calculation
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
        insertWord(child, word.substr(1));
    }

    void insertWord(string word)
    {
        insertWord(root, word);
    }

    bool search(TrieNode *root, string word)
    {
        if (word.length() == 0)
        {
            return root->isTerminal && true;
        }
        int index = word[0] - 'a';
        TrieNode *child;
        if (root->children[index] != NULL)
        {
            child = root->children[index];
        }
        else
        {
            return root->isTerminal && false;
        }
        bool ans = search(child, word.substr(1));
        return ans;
    }

    bool search(string word)
    {
        return search(root, word);
    }
};

int main()
{
    int choice;
    cin >> choice;
    Trie t;

    while (choice != -1)
    {
        string word;
        bool ans;
        switch (choice)
        {
        case 1: // insert
            cin >> word;
            t.insertWord(word);
            break;
        case 2: // search
            cin >> word;
            cout << (t.search(word) ? "true\n" : "false\n");
            break;
        default:
            return 0;
        }
        cin >> choice;
    }

    return 0;
}