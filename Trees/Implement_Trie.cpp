/*
Approach:
- We define a Trie node structure that contains an array of child nodes and a flag to indicate the end of a word.
- The Trie class provides methods to insert words into the Trie, search for words, and check if any word starts with a given prefix.
- The insert operation involves traversing the Trie for each character of the word and creating a new node if the path doesn't exist. At the end, we mark the last node as the end of a word.
- The search operation is similar to the insert operation, but it returns true only if the last node is marked as the end of a word.
- The startsWith operation also involves traversing the Trie for each character of the prefix. It returns true regardless of whether the last node is marked as the end of a word or not.

Time Complexity:
- The time complexity of inserting a word into the Trie is O(m), where m is the length of the word.
- The time complexity of searching for a word or checking for a prefix is O(m), where m is the length of the word or prefix.

Space Complexity:
- The space complexity of the Trie is O(N * M), where N is the number of words and M is the average length of the words.

Sample Input / Output:
int main() {
    Trie trie;
    
    trie.insert("apple");
    trie.insert("banana");
    
    cout << trie.search("apple") << endl;   // Output: 1 (true)
    cout << trie.search("banana") << endl;  // Output: 1 (true)
    cout << trie.search("car") << endl;     // Output: 0 (false)
    
    cout << trie.startsWith("app") << endl;     // Output: 1 (true)
    cout << trie.startsWith("ban") << endl;     // Output: 1 (true)
    cout << trie.startsWith("cab") << endl;     // Output: 0 (false)
    
    return 0;
}

*/

//Here's the code for implementing a Trie (Prefix Tree) in C++:

// Trie node structure
struct TrieNode {
    struct TrieNode* children[26];    // Array to store child nodes
    bool isEndOfWord;                 // Flag to indicate end of word
    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = nullptr;
    }
};

// Trie class
class Trie {
private:
    TrieNode* root;   // Pointer to the root node

public:
    Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    void insert(string word) {
        TrieNode* current = root;
        
        for (char ch : word) {
            int index = ch - 'a';
            
            // Create a new node if the path doesn't exist
            if (!current->children[index]) {
                current->children[index] = new TrieNode();
            }
            
            current = current->children[index];
        }
        
        // Mark the end of a word
        current->isEndOfWord = true;
    }

    // Search for a word in the Trie
    bool search(string word) {
        TrieNode* current = root;
        
        for (char ch : word) {
            int index = ch - 'a';
            
            // Return false if the path doesn't exist
            if (!current->children[index]) {
                return false;
            }
            
            current = current->children[index];
        }
        
        // Return true only if the current node is the end of a word
        return current->isEndOfWord;
    }

    // Check if any word in the Trie starts with the given prefix
    bool startsWith(string prefix) {
        TrieNode* current = root;
        
        for (char ch : prefix) {
            int index = ch - 'a';
            
            // Return false if the path doesn't exist
            if (!current->children[index]) {
                return false;
            }
            
            current = current->children[index];
        }
        
        // Return true regardless of whether the current node is the end of a word or not
        return true;
    }
};
