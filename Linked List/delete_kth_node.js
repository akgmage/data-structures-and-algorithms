/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Remove Kth node from end in Javascript
Issue Number : #687
Problem statement : 

Explanation of the below Javascript code :

Define a Node class to represent each node in the linked list.
Create a function called removeKthFromEnd that accepts the head of the linked list and the value of k as parameters.
Now you can create a linked list and call the removeKthFromEnd function to remove the kth node from the end.


*/

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}
function removeKthFromEnd(head, k) {
  // Step 1: Create two pointers, fast and slow, and set them both to the head of the linked list.
  let fast = head;
  let slow = head;

  // Step 2: Move the fast pointer k nodes ahead.
  for (let i = 0; i < k; i++) {
    if (fast === null) {
      // The linked list does not have k nodes.
      return head;
    }
    fast = fast.next;
  }

  // Step 3: If the fast pointer reaches the end, the kth node from the end is the head itself.
  if (fast === null) {
    head = head.next;
    return head;
  }

  // Step 4: Move the fast and slow pointers together until the fast pointer reaches the end.
  while (fast.next !== null) {
    fast = fast.next;
    slow = slow.next;
  }

  // Step 5: Remove the kth node by updating the next pointer of the previous node.
  slow.next = slow.next.next;

  // Step 6: Return the modified linked list.
  return head;
}
// Example usage:
const head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);

const k = 2;
const modifiedHead = removeKthFromEnd(head, k);

// Display the modified linked list.
let current = modifiedHead;
while (current !== null) {
  console.log(current.value);
  current = current.next;
}

/*
OUTPUT:
1
2
3
5
*/
