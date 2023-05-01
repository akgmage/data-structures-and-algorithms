/*

	Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.


	Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
	Output: Intersected at '8'
	
	Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	Output: Intersected at '2'

	Constraints:

	> The number of nodes of listA is in the m.
	> The number of nodes of listB is in the n.
	> 1 <= m, n <= 3 * 104
	> 1 <= Node.val <= 105
	> 0 <= skipA < m
	> 0 <= skipB < n
	> intersectVal is 0 if listA and listB do not intersect.
	> intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

*/

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
        // Define basic variables needed
      int len1=0;
      int len2=0;
      ListNode* tempA=headA;
      ListNode* tempB=headB;

      // Calculate the length of both Linked Lists and store in len1 and len2
      while(tempA!=NULL)
      {
          len1++;
          tempA=tempA->next;
      } 
      while(tempB!=NULL)
      {
          len2++;
          tempB=tempB->next;
      } 

      // Here, we assume that length of Linked-List A is less than or equal
        // to that of Linked List B
      if(len1>len2){
          swap(headA,headB);
      }

      // Re-initialize variables
      tempA=headA;
      tempB=headB;
      int n=abs(len2-len1);
      while(n--)
      {
          tempB=tempB->next;
      }

      // Finally, Find the Intersection Node
      while(tempA!=tempB)
      {
          tempA=tempA->next;
          tempB=tempB->next;
      } 

      // Return the final answer
      return tempA;
    }
};