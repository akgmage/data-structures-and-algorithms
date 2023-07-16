/*
    https://leetcode.com/problems/implement-trie-prefix-tree/
    
    Implement Trie (also called 'prefix tree') which supports lowercase letters only,
    a search tree with multiple childrens (26 in this case).
    methods:    Insert - push new string into the tree.
                Delete - remove string from the tree.
                search - check if a string is already pushed into the tree.
                StartWith - check if sum prefix is appear in the tree.

    Example:

    int main(){
        Trie trie;

        trie.Insert("abcd");        
        trie.Search("abcd")          // return true;
        trie.Search("ab")            // return false;
        trie.startWith("ab")         // return true;

        trie.Insert("ab");        
        trie.Search("ab")            // return true;

        trie.Delete("ab")
        trie.Search("ab")            // return false;
        trie.Search("abcd")          // return true;
    
        return 0;
    }

    Time Complexity:
        Insert() / Search() / startWith()  |  Average & Worst-case == O(m)  |  m == number of chars in string.

    Space Complexity:
        Space complexity for a trie: O(k * N)   |   k == size of the node, N == number of the different nodes.   

*/


#include <string>
#include <vector>

enum{CHARS_IN_ALPHABET = 26};

class TrieNode{
public:
    TrieNode() : vec(CHARS_IN_ALPHABET, nullptr), end_of_str(false) {};

// every node has a vector for his childrens and a flag to mark - end of word.
    std::vector<TrieNode*> vec;
    bool end_of_str;
};
/****************************************************************************/
class Trie {
public:
    Trie();
    ~Trie();
    // non-copyable class
    Trie(const Trie& other) = delete;
    Trie& operator= (const Trie& other) = delete;

    void Insert(std::string word);
    bool Delete(std::string word);
    bool Search(std::string word);
    bool startWith(std::string prefix);
    void Destroy(TrieNode* root);

private:
    enum RecDeleteStatus{NOT_FOUND = -1, DELETE = 0 , COMPLITE = 1};

    RecDeleteStatus RecDelete(TrieNode* curr_node, const char* string_ptr);
    bool IsLeaf(TrieNode* node);
    TrieNode* CreatNodes(TrieNode* node_runner, const char* rest_letters);
    TrieNode* FindLastChar(const char* first_char_string);

    TrieNode* m_root;
};
/****************************************************************************/
Trie::Trie() // Ctor
{
    m_root = new TrieNode();
}
/****************************************************************************/
Trie::~Trie() // Dtor
{
    Destroy(m_root);
    delete m_root;
}
/****************************************************************************/
// function for push a word(string) inside the trie 
void Trie::Insert(std::string word)
{
    const char* string_ptr = word.data();
    TrieNode* node_runner = m_root;

    while(*string_ptr)
    {
        // if this node does not have this latter as a child yet.
        if(!node_runner->vec[*string_ptr - 'a'])
        {
            node_runner = CreatNodes(node_runner, string_ptr);
            break;
        }
        
        node_runner = node_runner->vec[*string_ptr - 'a'];
        ++string_ptr;
    }
    // mark node as end of word.
    node_runner->end_of_str = true;
}
/****************************************************************************/
// function for remove a word from the trie, if the word or part of her suffix
// stand alone, the whole node will be removed.
bool Trie::Delete(std::string word)
{
    if(RecDelete(m_root, word.data()) != NOT_FOUND)
    {
        return true;
    }
    return false;
}
/****************************************************************************/
// function for check if a string is already pushed into the tree.
bool Trie::Search(std::string word) 
{
    TrieNode* node = FindLastChar(word.data());    
    // if FindLastChar return nullptr the word isnt in the trie,
    // if the word is found but it just a prefix of another word, return false
    if(node == nullptr || node->end_of_str == false){
        return false;
    }
    return true;   
}
/****************************************************************************/
// function for check if sum prefix is appear in the tree.
bool Trie::startWith(std::string prefix) 
{
    TrieNode* node = FindLastChar(prefix.data());    
    // if FindLastChar return nullptr the word isnt in the trie,
    if(node == nullptr){
        return false;
    }
    return true;
}
/****************************************************************************/
// Recursive function for delete a word and the whole node if the word or part 
// of her suffix stand alone. if the word is prefix of another word, no nodes
// will be removed
Trie::RecDeleteStatus Trie::RecDelete(TrieNode* curr_node, const char* string_ptr)
{
    if(curr_node == nullptr)
    {
        return NOT_FOUND;
    }
    if(*string_ptr == '\0')
    {
        return DELETE;
    }

    int char_idx = *string_ptr - 'a';
    RecDeleteStatus status = RecDelete(curr_node->vec[char_idx], string_ptr + 1);

    if(status == DELETE)
    {
        if(IsLeaf(curr_node->vec[char_idx]))
        {
            delete curr_node->vec[char_idx];
            curr_node->vec[char_idx] = nullptr;
            return DELETE;
        }
        else if(*(string_ptr + 1) == '\0')
        {
            if(curr_node->vec[char_idx]->end_of_str)
            {
                curr_node->vec[char_idx]->end_of_str = false;
                return DELETE;
            }
            else
            {
                return NOT_FOUND;
            }
        }
    }
    if(status == NOT_FOUND)
    {
        return NOT_FOUND;
    }
    return COMPLITE;
}
/****************************************************************************/
// function to check if node does not have childrens
bool Trie::IsLeaf(TrieNode* curr_node)
{
    for(auto it : curr_node->vec)
    {
        if(it != nullptr)
        {
            return false;
        }
    }
    return true;
}
/****************************************************************************/
// function for create and push new nodes ,from the input node(node_runner)
// according to the string(string_ptr) that must have a null termination sign.
TrieNode* Trie::CreatNodes(TrieNode* node_runner, const char* string_ptr) 
{
    while(*string_ptr)
    {
        TrieNode* new_node = new TrieNode();
        
        node_runner->vec[*string_ptr - 'a'] = new_node;
        node_runner = new_node;
        ++string_ptr;
    }

    return node_runner;
}
/****************************************************************************/
// function for search and return the node of the last character in a string
// return nullptr if the word is not found.
TrieNode* Trie::FindLastChar(const char* string_ptr)
{
    TrieNode* node_runner = m_root;

    while(*string_ptr)
    {
        TrieNode* next_node = node_runner->vec[*string_ptr - 'a'];
        if(nullptr == next_node)
        {
            return nullptr;
        }
        
        node_runner = next_node;
        ++string_ptr;
    }
    return node_runner;
}
/****************************************************************************/
// destroy all nodes inside the trie except the root
void Trie::Destroy(TrieNode* node)
{
    if(node == nullptr)
    {
        return;
    }   
    for(auto it : node->vec)
    {
        Destroy(it);
        delete it;
    }
}
