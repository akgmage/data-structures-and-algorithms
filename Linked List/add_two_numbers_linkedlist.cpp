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
   
    void insertattail(ListNode* &head, ListNode* &tail, int val){
        ListNode* temp = new ListNode(val);
        if(head == NULL){
            head = temp;
            tail = temp;
            return;
        }
        else{
            tail->next = temp;
            tail = temp;
        }
    }
    ListNode* add(ListNode* l1, ListNode* l2 ){
        int carry = 0;
        ListNode* ansHead = NULL;
        ListNode* ansTail = NULL;

        while(l1 != NULL || l2 != NULL || carry != 0){
            int val1 = 0;
            if(l1 != NULL){
                val1 = l1->val;
            }
            int val2 = 0;
            if( l2 != NULL){
                val2 = l2->val;
            }

            int sum = val1 + val2 + carry;
            int digit = sum%10;
            // the extracted digit needs to be inserted at the tail 
            insertattail(ansHead, ansTail, digit);
            // update the carry 
            carry = sum/10;

            if(l1!= NULL){
                l1 = l1->next;
            }
            if(l2!= NULL){
                l2 = l2->next;
            }
            
        }
        return ansHead;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* ans = add(l1, l2);
        return ans;
    }
};

// Approach - add two numbers digit by digit and inserting at the tail of the new formed linked list to get the correct answer 
// Time complexity - O(max(N, M))
// Space complexity - O(max(N, M))
