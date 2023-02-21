
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