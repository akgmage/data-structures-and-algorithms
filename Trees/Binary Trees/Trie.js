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
  constructor() {
    this.root = new Node();
  }

  insert(word) {
    this.root.insert(word, 0);
  }

  search(word) {
    return this.root.search(word, 0);
  }

  startsWith(prefix) {
    return this.root.startsWith(prefix, 0);
  }
}

class Node {
  constructor() {
    this.nodes = new Array(26);
    this.isEnd = false;
  }

  // Function to insert the word in the tree
  insert(word, idx) {
    if (idx >= word.length) return; // handle edge case
    const i = word.charCodeAt(idx) - 'a'.charCodeAt(0);
    if (!this.nodes[i]) {
      this.nodes[i] = new Node();   // initialize the node[i] if the letter was not found before
    }

    if (idx === word.length - 1) this.nodes[i].isEnd = true;    // signifies that this is the end of the word
    this.nodes[i].insert(word, idx + 1);    // recursive call to populate the child node
  }

  // Function to search the word in the tree
  search(word, idx) {
    if (idx >= word.length) return false;
    const node = this.nodes[word.charCodeAt(idx) - 'a'.charCodeAt(0)];
    if (!node) return false;    // if the node is null it means that it was not initialised hence the character was never found.
    if (idx === word.length - 1 && node.isEnd) return true; //if it is the last character and the end of the node then return true

    return node.search(word, idx + 1);  // recursive call search in the child node
  }

  //Function to search the prefix in tree
  startsWith(prefix, idx) {
    if (idx >= prefix.length) return false;
    const node = this.nodes[prefix.charCodeAt(idx) - 'a'.charCodeAt(0)];
    if (!node) return false;
    if (idx === prefix.length - 1) return true; // Very similar to above method but here we don't need to check if it is the end of the node.

    return node.startsWith(prefix, idx + 1);
  }
}
