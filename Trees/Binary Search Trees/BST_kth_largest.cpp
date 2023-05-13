/*TASK
 Binary Search Tree : Get kth largest element in a BST
 A BST is a tree structure that is sorted by the nodes' data. 
 Following rules are true for every picked node in a BST:
 -> all nodes to the left have data that is less than the data of the picked node
 -> all nodes to the right have data that is greater than the the data of the picked node
 -> all nodes have 2 children (left and right), but they can be empty (null) too.
*/

/*SAMPLE DATA
 Take a look on the following BST
             3
        2         7
    1           5   9
              4

 For k = 3, we should get 5 as an output, because 5 is the 3. largest element in the BST
*/

/*APPROACH
 an recursive algorithm that is going to get to the nodes in descending order.
 the visited nodes get appended to an array and if the kth node is visited the recursion will be left
 1. start with the root node of a BST
 2. for each node that is reached, do the first that is possible from the following:
    "if possible" means that the node has a valid child in that direction that is not already visited
    1. go to the right if possible to get to the far right node which also has the largest data
    2. go to the left if possible to get larger data than going back 
        (If the algorithm goes back from the current node, all right nodes will be already visted, that means that we will land on a lower data node)
    3. go back
    
    If we cannot do 1. we save this node as visited.
    The kth visited node is also the kth largest.
    if this node is reached it is getting saved in a class member variable.
    In each recursion call this variable gets checked. If the node is set (we already found the kth largest node), 
        the recursion step returns before doing anything.
    that is how the programm will get out of the recursion fast after finding the target node.
3. if the member variable is set, that is the kth largest node, if its empty there is no kth largest node (out of range)

SAMPLE
    1. first we start with the root 3
    2. we can go right, so we will do so (node 7)
    3. we can go right (node 9)
    4. we cannot go right, we save this in a visited node list (node 9, list 9)
    5. we cannot go left, we go back (node 7)
    6. we cannot go right, because 9 is already visited, we save this in visited nodes (node 7, list 9,7)
    7. we can go left (node 5)
    8. we cannot go right, we save this in visited nodes (node 5, list 9,7,5)
    9. the list's size is equal to k, we will set the member variable to the last saved node 5 (node 5, list 9,7,5, member 5)
    10. we have a member set, we go back (node 7)
    11. we have a member set, we go back (node 3)
    12. we have a member set, we go back (leaving recursion)
    13. member variable holds 5, which is the 3. largest number in the BST
*/

/*COMPLEXITY
    the algorithm has to go to the far right in h steps, where h is the height of the tree 
    and additionally k steps to get to the kth largest value. to break out the programm needs additionally h steps
    Time complexity is O(2*h+k). The complexity class is O(n), because h is linear in a worst case (skewed to one side) and k is also linear.
    Space complexity is O(h), because the algorithm needs to store a maximum of h recursion calls. 
    The complexity class is O(n), because h is linear in a worst case (skewed to one side).
    But in a balanced tree it is only O(log(n)), because h is log(n), where n is the number of nodes in the balanced tree.
*/
#include <iostream>
#include <algorithm>
#include <vector>
class Node{
    //Node class holds one node of the tree
    //every node holds some data (int) and has two children
    //an empty children gets represented with nullptr
public:
    int data;
    Node* left;
    Node* right;

public:
    Node(int item){
        //init the node with no children
        data = item;
        left = nullptr;
        right = nullptr;
    }
    virtual ~Node(){
        /*
        IMPORTANT to avoid memory leaks 
        a virtual constructor is required to correctly delete all children (and children of children)
        checking if the child is not empty than calling the children's destructor
        */
        if(left != nullptr){delete left;}
        if(right != nullptr){delete right;}
    };
};

class BinaryTree{
    //holds the full tree (and tree functionalities)
private:
    Node* kth_largest;  //that is the member variable that our algorithm uses to save the target node
    std::vector<Node*> visited_nodes;   //the list of visited nodes
public:
    Node* root;     //pointer to the root node of the BST

private:
    void traverseRL(Node* node, int k){
        //this method is traversing the BST from the largest to the smallest element
        //this algorithm is taking the root node and the k
        if(this->kth_largest != nullptr){   //are we ready?
            return;
        }
        if(node->right != nullptr){         //can we go to the right?
            traverseRL(node->right, k);     //go to the right
        }
        this->visited_nodes.push_back(node);    //cannot go more right, add to visited nodes
        if(this->visited_nodes.size() == k){    //if the visited nodes list is long enough to hold the target node 
            this->kth_largest = node;           //save this node in the member variable
            return;                         //start to break down the recursion
        }
        if(node->left != nullptr){          //can we go to the left?
            traverseRL(node->left, k);      //go to the left
        }
        return;                            //this node is already dealt with
    }

public:
    BinaryTree(int root_data){
        //creates a binary tree with one node (root) that gets some given data
        kth_largest = nullptr;
        root = new Node(root_data);
    }
    Node* insertNode(Node* node, int data){ //insert a new node on the right position (remember the BST rules)
        if(node == nullptr){        //if we reach an empty spot we set the new node there
            return new Node(data);
        }
        if(data <= node->data){ //data is smaller than the data of the current node
            node->left = insertNode(node->left, data);  //we have to got to the left
        }
        else{                   //data is greater than the data of the current node
            node->right = insertNode(node->right, data);    //we have to got to the right
        }
        return node;    //get the node back to the previous recursion layer
    }
    
    Node* getKthLargest(int k){     //get the kth largest data node
        this->kth_largest = nullptr;    //init the member variables that are needed for the algorithm
        this->visited_nodes.clear();
        this->traverseRL(this->root, k);    //perform the search
        if(this->kth_largest == nullptr){   //kth largest element cannot be found (out of range)
            std::cout << "There is no " << k << ". largest element in this tree" << std::endl;
            std::cout << "Valid k's for a tree are numbers between 1 and the number of nodes inclusive";
            return nullptr;
        }else{
            return this->kth_largest;   //returrn the kth largest node
        }
    }
};

int main() {
    //sample
    int k = 3;
    BinaryTree tree = BinaryTree(3);        //building up the sample BST
    tree.insertNode(tree.root, 7);
    tree.insertNode(tree.root, 2);
    tree.insertNode(tree.root, 5);
    tree.insertNode(tree.root, 9);
    tree.insertNode(tree.root, 1);
    tree.insertNode(tree.root, 4);
    std::cout << tree.getKthLargest(k)->data << std::endl;  //print the result
    return 0;
}