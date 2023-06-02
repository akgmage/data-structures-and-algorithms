/*
Question:-Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

          According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
          the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
          
          Example 1:
          Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
          Output: 6
          Explanation: The LCA of nodes 2 and 8 is 6.
          
          Example 2:
          Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
          Output: 2
          Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition. 
          */
          
          class Solution {
public:
    
     TreeNode* lca = NULL;
    pair<bool, bool> computeState(TreeNode* root, TreeNode* a, TreeNode* b){
        if(root==NULL) return {false, false};
        pair<bool, bool> ltKaAns = computeState(root->left, a, b);
        pair<bool, bool> rtKaAns = computeState(root->right, a, b);
        pair<bool, bool> meriState = {
            ltKaAns.first | rtKaAns.first | root==a,
            ltKaAns.second | rtKaAns.second | root==b
        };
        if(meriState==make_pair(true, true) and lca==NULL){
            lca = root;
        }
        return meriState;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
         computeState(root, p, q);
        return lca;
    }
};
