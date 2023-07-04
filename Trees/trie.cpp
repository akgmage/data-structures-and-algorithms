/*
    trie for only lowercase English letters.
*/


#include <string>
#include <vector>
#include <iostream>//TODO:

enum{CHARS_IN_ALPHABET = 26};

class TrieNode{
public:
    TrieNode() : vec(CHARS_IN_ALPHABET, nullptr), end_of_str(false) {};

    std::vector<TrieNode*> vec;
    bool end_of_str;
};
/****************************************************************************/
class Trie {
public:
    Trie();
    ~Trie();
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
Trie::Trie()
{
    m_root = new TrieNode();
}
/****************************************************************************/
Trie::~Trie()
{
    Destroy(m_root);
    delete m_root;
}
/****************************************************************************/
void Trie::Insert(std::string word)
{
    const char* string_ptr = word.data();
    TrieNode* node_runner = m_root;

    while(*string_ptr)
    {
        if(!node_runner->vec[*string_ptr - 'a'])
        {
            node_runner = CreatNodes(node_runner, string_ptr);
            break;
        }

        node_runner = node_runner->vec[*string_ptr - 'a'];
        ++string_ptr;
    }
    node_runner->end_of_str = true;
}
/****************************************************************************/
bool Trie::Delete(std::string word)
{
    if(RecDelete(m_root, word.data()) != NOT_FOUND)
    {
        return true;
    }
    return false;
}
/****************************************************************************/
bool Trie::Search(std::string word) 
{
    TrieNode* node = FindLastChar(word.data());    
    
    if(node == nullptr || node->end_of_str == false){
        return false;
    }
    return true;   
}
/****************************************************************************/
bool Trie::startWith(std::string prefix) 
{
    TrieNode* node = FindLastChar(prefix.data());    
    
    if(node == nullptr){
        return false;
    }
    return true;
}
/****************************************************************************/
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

/////////////////////////////////////////////

void search();
void deleteaa();
void startw();

int main(){

    search();
    deleteaa();
    startw();

    return 0;
}
void startw()
{
    Trie trie;
    
    if(trie.startWith("abc") != false){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("z") != false){
        std::cout << "faile" << std::endl;
    }    
    trie.Insert("abcd");
    if(trie.startWith("a") != true){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("ab") != true){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("abc") != true){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("abcd") != true){
        std::cout << "faile" << std::endl;
    }    
    
    if(trie.startWith("as") != false){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("abs") != false){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("abcs") != false){
        std::cout << "faile" << std::endl;
    }    
    if(trie.startWith("abcds") != false){
        std::cout << "faile" << std::endl;
    }    
}
void deleteaa()
{
    Trie trie;

    if(trie.Delete("abc") != false){
        std::cout << "faile" << std::endl;
    }      

    trie.Insert("abcd");

    if(trie.Delete("abcd") != true){
        std::cout << "faile" << std::endl;
    }    
    if(trie.Search("abcd") != false){
        std::cout << "faile" << std::endl;
    }

    trie.Insert("abcd");

    if(trie.Delete("abc") != false){
        std::cout << "faile" << std::endl;
    }    

    trie.Insert("abc");
    if(trie.Search("abcd") != true){
        std::cout << "faile" << std::endl;
    }

    if(trie.Delete("abc") != true){
        std::cout << "faile" << std::endl;
    }    
    if(trie.Search("abc") != false){
        std::cout << "faile" << std::endl;
    }

    trie.Insert("abcd");

    if(trie.Delete("abcd") != true){
        std::cout << "faile" << std::endl;
    }    
}
void search()
{
    Trie trie;

    if(trie.Search("abcd") != false){
        std::cout << "faile" << std::endl;
    }
    if(trie.Search("") != false){
        std::cout << "faile" << std::endl;
    }
    if(trie.Search("c") != false){
        std::cout << "faile" << std::endl;
    }


    trie.Insert("abcd");

    if(trie.Search("abc") != false){
        std::cout << "faile" << std::endl;
    }

    if(trie.Search("abcde") != false){
        std::cout << "faile" << std::endl;
    }

    if(trie.Search("vdds") != false){
        std::cout << "faile" << std::endl;
    }

    if(trie.Search("abcd") != true){
        std::cout << "faile" << std::endl;
    }
}