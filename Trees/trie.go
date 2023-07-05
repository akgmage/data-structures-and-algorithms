/*
Approach:
In this implementation, we define two struct types: `TrieNode` and `Trie`. `TrieNode` represents a single node in the Trie. It has two fields: `children` (a map of rune to `TrieNode`) to store the child nodes and `isWord` (a boolean) to indicate the end of a word.

`Trie` represents the Trie data structure and has a single field `root` (a pointer to `TrieNode`), which is initialized with an empty `TrieNode` in the `NewTrie` function.

The Trie supports three operations:
- `Insert` function is used to add a word to the Trie. It starts from the root node and traverses through each character of the word, creating new nodes as needed.
- `Search` function is used to check if a given word exists in the Trie. It follows a similar approach to the `Insert` function but returns `true` if the final node marks the end of a word.
- `StartsWith` function is used to check if there is any word in the Trie that starts with a given prefix. It works similar to the `Search` function but does not require the final node to mark the end of a word.

Sample Input:
In the `main` function demonstrates the usage of the Trie data structure. We insert words "apple", "app", "application", "book", and "dog" into the Trie. Then, we search for words "app", "apple", and "banana". Finally, we check if there are any words in the Trie that start with prefixes "ap", "do", and "cat".

Time complexity of the `Insert`, `Search`, and `StartsWith` operations: O(m), where m is the length of the word or prefix being processed. 

Space complexity: O(n), where n is the total number of characters in all the words inserted in the Trie.
*/

//Here's an implementation of the Trie data structure in Go:

package main

import "fmt"

// TrieNode represents a single node in the Trie
type TrieNode struct {
	children map[rune]*TrieNode
	isWord   bool
}

// Trie represents the Trie data structure
type Trie struct {
	root *TrieNode
}

// NewTrie initializes a new Trie
func NewTrie() *Trie {
	return &Trie{
		root: &TrieNode{
			children: make(map[rune]*TrieNode),
			isWord:   false,
		},
	}
}

// Insert adds a word to the Trie
func (t *Trie) Insert(word string) {
	node := t.root

	// Traverse through each character of the word
	for _, ch := range word {
		if node.children[ch] == nil {
			node.children[ch] = &TrieNode{
				children: make(map[rune]*TrieNode),
				isWord:   false,
			}
		}
		node = node.children[ch]
	}

	// Mark the end of the word
	node.isWord = true
}

// Search returns true if the word exists in the Trie, otherwise false
func (t *Trie) Search(word string) bool {
	node := t.root

	// Traverse through each character of the word
	for _, ch := range word {
		if node.children[ch] == nil {
			return false
		}
		node = node.children[ch]
	}

	// Check if the node marks the end of a word
	return node.isWord
}

// StartsWith returns true if there is any word in the Trie that starts with the given prefix, otherwise false
func (t *Trie) StartsWith(prefix string) bool {
	node := t.root

	// Traverse through each character of the prefix
	for _, ch := range prefix {
		if node.children[ch] == nil {
			return false
		}
		node = node.children[ch]
	}

	return true
}

func main() {
	trie := NewTrie()

	// Inserting words into the Trie
	trie.Insert("apple")
	trie.Insert("app")
	trie.Insert("application")
	trie.Insert("book")
	trie.Insert("dog")

	// Searching words in the Trie
	fmt.Println(trie.Search("app"))    // Output: true
	fmt.Println(trie.Search("apple"))  // Output: true
	fmt.Println(trie.Search("banana")) // Output: false

	// Checking prefixes in the Trie
	fmt.Println(trie.StartsWith("ap"))  // Output: true
	fmt.Println(trie.StartsWith("do"))  // Output: true
	fmt.Println(trie.StartsWith("cat")) // Output: false
}

