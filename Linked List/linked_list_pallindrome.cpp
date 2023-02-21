/*
    Given the head of a singly linked list, return true if it is a 
    palindrome
    or false otherwise.

    

    Example 1:


    Input: head = [1,2,2,1]
    Output: true
    Example 2:


    Input: head = [1,2]
    Output: false
    

    Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
    

    Follow up: Could you do it in O(n) time and O(1) space?
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

// Time Complexity : O(n) Space Complexity: O(n)
// TODO: Implement O(n) Time and  O(1) space solution
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        vector<int> contents;
        while(head != NULL) {
            int val = head->val;
            contents.push_back(val);
            head = head->next;
        }
        int low = 0, high = contents.size() - 1;
        while(low <= high) {
            if(contents[low] == contents[high]){
                low++;
                high--;
            }
            else {
                return false;
            }
        }
        return true;
    }
};