/*
Explaination :
    The TrieNode class represents a single node in the Trie. Each node contains a character data, an array of pointers to its child nodes children, and a boolean flag isTerminal to indicate if a word ends at that node.

    The Trie class serves as the main data structure and contains a pointer to the root node of the Trie. It provides public functions to insert a word into the Trie, search for a word in the Trie, and remove a word from the Trie.

    The insertWord function is a private member function of the Trie class and is responsible for inserting a word into the Trie. It takes a root parameter representing the current node and a word parameter representing the word to be inserted. The function recursively traverses the Trie, creating new nodes as needed and marking the last node as terminal.

    The search function is also a private member function of the Trie class and is used to search for a word in the Trie. It takes a root parameter and a word parameter. The function recursively checks if each character in the word exists as a child node starting from the given root and returns true if the entire word is found and marked as terminal.

    The removeWord function is another private member function of the Trie class and is used to remove a word from the Trie. It takes a root parameter and a word parameter. The function recursively searches for the word in the Trie, marks the last node of the word as non-terminal, and removes any unnecessary child nodes that are not part of other words.

    In the main function, an instance of the Trie class is created. Words "and", "dot", and "double" are inserted into the Trie using the insertWord function. The search function is then used to check if the word "and" exists in the Trie, and the result is printed. The removeWord function is called to remove the word "and" from the Trie, and again the search function is used to check if the word "and" exists in the Trie after removal, and the result is printed.
*/
#include <iostream>
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
    Trie()
    {
        root = new TrieNode('\0');
    }

private:
    void insertWord(TrieNode *root, string word)
    {
        // Base Case
        if (word.length() == 0)
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
        // Recursive Call
        insertWord(child, word.substr(1));
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
    void removeWord(TrieNode *root, string word)
    {
        if (word.size() == 0)
        {
            root->isTerminal = false;
            return;
        }
        int index = word[0] - 'a';
        TrieNode *child;
        if (root->children[index] != NULL)
        {
            child = root->children[index];
        }
        else
        {
            // Word not found
            return;
        }
        removeWord(child, word.substr(1));

        // Remove Child Node if it is useless
        if (child->isTerminal == false)
        {
            for (int i = 0; i < 26; i++)
            {
                if (child->children[i] != NULL)
                {
                    return;
                }
            }
            delete child;
            root->children[index] = NULL;
        }
    }

public:
    void insertWord(string word)
    {
        insertWord(root, word);
    }

    bool search(string word)
    {
        return search(root, word);
    }

    void removeWord(string word)
    {
        removeWord(root, word);
    }
};

int main()
{
    Trie t;
    t.insertWord("and");
    t.insertWord("dot");
    t.insertWord("double");
    cout << t.search("and") << endl;
    t.removeWord("and");
    cout << t.search("and") << endl;
}