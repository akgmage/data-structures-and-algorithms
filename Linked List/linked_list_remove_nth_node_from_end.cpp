/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
*/
#include<bits/stdc++.h>
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


/*
In order to solve this problem in only one pass and O(1) extra space, 
however, we would need to find a way to both reach the end of the list with one pointer 
and also reach the n'th node from the end simultaneously with a second pointer.
To do that, we can simply stagger our two pointers by n nodes by giving the first pointer 
(fast) a head start before starting the second pointer (slow). Doing this will cause 
slow to reach the n'th node from the end at the same time that fast reaches the end.
*/

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* slow = head;
        ListNode* fast = head;
        if(head == NULL || head->next == NULL)
            return NULL;
        while(n--){
            fast = fast->next;
        }
        if(fast == NULL)
            return slow->next;
        while(fast->next != NULL){
            slow = slow->next;
            fast = fast->next;
        }
        ListNode* temp = slow->next;
        slow->next = slow->next->next;
        delete temp;
        return head;
    }
};