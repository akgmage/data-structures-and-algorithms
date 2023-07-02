/*
Description
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

Time Complexity for each operation is O(n)
Space Complexity O(n*m) where n is the number of words inserted and m is the average length of the words.

Explanation:
insert() -> traverse through each character of the input word and initializes it if necessary. If the end of the word is reached set isEnd to true.
search() -> Search In each child node until the end of the word is reached, then if end of the node is also reached return true else false.
startsWith() -> Similar to search method but we only check if end of the prefix is reached and we don't need to check if it is the end of the node.

*/

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        // Function to insert the word in the tree
        private void insert(String word, int idx) {
            if (idx >= word.length()) return; // handle edge case
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node(); // initialize the node[i] if the letter was not found before
            }

            if (idx == word.length()-1) nodes[i].isEnd = true; // signifies that this is the end of the word
            nodes[i].insert(word, idx+1); // recursive call to populate the child node
        }

        // Function to search the word in the tree
        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null) return false; // if the node is null it means that it was not initialised hence the character was never found.
            if (idx == word.length() - 1 && node.isEnd) return true; //if it is the last character and the end of the node then return true

            return node.search(word, idx+1); // recursive call search in the child node

        }

        //Function to search the prefix in tree
        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == prefix.length() - 1) return true; // Very similar to above method but here we don't need to check if it is the end of the node.

            return node.startsWith(prefix, idx+1);
        }
    }
}