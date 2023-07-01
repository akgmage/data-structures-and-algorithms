'''
Approach:
1. We implement the TrieNode class with a dictionary of children nodes and a flag to indicate the end of a word.
2. The Trie class is implemented with a root TrieNode as its member variable.
3. The insert function traverses through each character of the input word and creates new TrieNode objects if necessary.
4. The search function traverses through each character of the input word and returns True only if the last node is marked as the end of a word.
5. The startsWith function is similar to the search function but returns True as long as the prefix exists in the Trie.

Time Complexity:
- Insertion: O(m), where m is the length of the word being inserted.
- Search: O(m), where m is the length of the word being searched.
- Starts With: O(m), where m is the length of the prefix being checked.

Space Complexity:
- O(n*m), where n is the number of words inserted and m is the average length of the words.

Sample input and output:

trie = Trie()
trie.insert("apple")
print(trie.search("apple"))  # Output: True
print(trie.search("app"))  # Output: False
print(trie.startsWith("app"))  # Output: True
trie.insert("app")
print(trie.search("app"))  # Output: True

Here's an implementation of the Trie data structure, also known as the Prefix Tree, in Python:
'''

# Trie node class
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False


# Trie class
class Trie:
    def __init__(self):
        self.root = TrieNode()

    # Function to insert a word into the Trie
    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            # If the current character doesn't exist in the Trie, create a new node
            if char not in node.children:
                node.children[char] = TrieNode()
            # Move to next node
            node = node.children[char]
        # Mark the end of a word
        node.is_end_of_word = True

    # Function to search for a word in the Trie
    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            # If the current character doesn't exist, the word doesn't exist
            if char not in node.children:
                return False
            # Move to next node
            node = node.children[char]
        # Return True only if the last node is marked as the end of a word
        return node.is_end_of_word

    # Function to check if a word is a prefix of any existing word in the Trie
    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            # If the current character doesn't exist, the prefix doesn't exist
            if char not in node.children:
                return False
            # Move to next node
            node = node.children[char]
        # The prefix exists if we reach this point
        return True

