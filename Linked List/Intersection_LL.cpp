/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *pA = headA;
        ListNode *pB = headB;

        // Traverse both linked lists until they meet or reach the end (NULL)
        while (pA != pB) {
            // Move pointers to the next node
            pA = (pA != nullptr) ? pA->next : headB;
            pB = (pB != nullptr) ? pB->next : headA;
        }

        // Return the intersection node (or NULL if no intersection)
        return pA;
    }
};

/*
Explanation:
The provided code implements the solution to find the intersection point of two singly-linked lists headA and headB. The getIntersectionNode function takes two ListNode pointers as parameters and returns the intersection node if one exists, or NULL if there is no intersection.

The approach used here is based on the concept of "runner pointers." The pointers pA and pB start from the heads of the two linked lists and traverse through the lists. When a pointer reaches the end of its list, it is redirected to the head of the other list. This ensures that the pointers will meet at the intersection point if it exists, or they will both reach the end of the lists (NULL) simultaneously if there is no intersection.
  */
