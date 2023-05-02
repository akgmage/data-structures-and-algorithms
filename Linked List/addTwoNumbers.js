// Linked List: Add Two Numbers in Javascript #622

/*
  
  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

  Example 1:
	- Input: l1 = [2,4,3], l2 = [5,6,4]
	- Output: [7,0,8]
  - Explanation: 342 + 465 = 807.

  Example 2:
	- Input: l1 = [0], l2 = [0]
	- Output: [0]
  
  Example 3:
	- Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	- Output: [8,9,9,9,0,0,0,1]
  
	Constraints:
	- The number of nodes in each linked list is in the range [1, 100].
	- 0 <= Node.val <= 9
	- It is guaranteed that the list represents a number that does not have leading zeros.

*/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

var addTwoNumbers = function (l1, l2) {
  const head = new ListNode(); // creating a new LL.
  let temp = head; // assign head into temp to traverse the LL.
  let carry = 0; // to store carry that we will get during the add operation.

  while (l1 || l2) {
    // loop will get executed  until one of the LL becomes null.
    let sum = carry;

    //perform summation with both LL one by one and assign it to the sum variable.
    if (l1) {
      sum += l1.val;
      l1 = l1.next;
    }

    if (l2) {
      sum += l2.val;
      l2 = l2.next;
    }

    // to store the carry part we will do sum/10 and store it's floor value to carry variable. For Example:
    /* 
      if sum = 12
      so, sum/10 = 1.2
      and Math.floor(1.2) = 1 and we get our carry part.
      > carry = 1.
    */
    carry = Math.floor(sum / 10);
    temp.next = new ListNode(sum % 10); // at this point we are removing carry part from sum and adding remaining part into the ll.
    temp = temp.next;
  }

  if (carry > 0) {
    // after the completion of summation, if there is any cary left it will be added to list.
    temp.next = new ListNode(carry);
  }

  return head.next; // return the head of the node so ll can be traverse.
};
