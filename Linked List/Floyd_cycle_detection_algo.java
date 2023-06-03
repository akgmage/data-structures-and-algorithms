/**
 Problem :- Linked list cycle 
 https://leetcode.com/problems/linked-list-cycle/description/

 Approach:-
 1. Set two pointer on head, slow 's' and a fast 'f' pointer .
 2. The slow pointer will move one step and the fast pointer will move twice the speed of slow pointer.
 3. If the slow and fast pointer meet i.e s==f , it means there is a cycle present.
  Hence they will meet a some point(return true if(s==f)).
 4. If the fast pointer is null or its next is null means there is no cycle(return false).



 Time Complexity:- O(N) 
 Even if there is a cycle exists we traverse the given list, Hence * linear time *.

 Space Complexity:- O(1)
 No extra space is required.



 */



// Easy Solution will well documented code .

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode s = head;  // slow pointer
        ListNode f = head;  // fast pointer

        while (f != null && f.next != null) {
            s = s.next;         // move slow pointer by 1 step
            f = f.next.next;    // move fast pointer by 2 steps

            if (s == f)         // if slow and fast pointers meet, there is a cycle
                return true;
        }

        return false;          // if fast pointer reaches the end, there is no cycle
    }
}
