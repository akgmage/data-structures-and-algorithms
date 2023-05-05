//Problem statement-Given the head of a singly linked list, reverse the list, and return the reversed list.

// Iteratively 
* @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  // Handling the edge cases if head node is null or when single node is there 
        if (head === null || head.next === null) {
            return head;
        }
  // Using three pointer approach 
        let prev = null;
        let curr = head;
        let fwd = null;
        while (curr !== null) {
          // Updatng the value of each of the pointers 
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
  // Returning the head of the reversed linked list 
        return prev;    
};
// Time complexity - O(N)
// Space complexity - O(1)

// Recursively 
var reverseList = function(head) {
  // Base case- If the head is null or single node is there
  if (head === null || head.next === null) {
    return head;
  }

  // Recursively reverse the remaining list starting from the next node 
  const reversedList = reverseList(head.next);

  // Reversing the links between the current and next node 
  head.next.next = head;
  head.next = null;

  // Returning the head of the reversed linked list 
  return reversedList; 
};
// Time complexity - O(N)
// Space complexity - O(N)
