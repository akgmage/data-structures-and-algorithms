/*
    Given the head of a linked list, return the list after sorting it in ascending order.
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
class Solution {
public:
    ListNode* compute_midpoint(ListNode* head){
        if(head == NULL || head->next == NULL){
            return head;
        }
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast != NULL && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    ListNode* merge_two_lists(ListNode* A, ListNode* B){
        if(A == NULL)
            return B;
        else if(B == NULL)
            return A;
        ListNode* C = NULL;
        if(A->val < B->val){
            C = A;
            C->next = merge_two_lists(A->next, B);
        }
        else{
            C = B;
            C->next = merge_two_lists(A, B->next);
        }
        return C;
    }
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL)
            return head;
        ListNode* mid = compute_midpoint(head);
        ListNode* A = head; 
        ListNode* B = mid->next;
        mid->next = NULL;
        A = sortList(A);
        B = sortList(B);
        
        ListNode* C = merge_two_lists(A, B);
        return C;
    }
};