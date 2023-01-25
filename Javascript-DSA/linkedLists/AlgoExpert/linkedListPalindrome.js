class LinkedList {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

//! O(n) time | O(1) space

function linkedListPalindrome(head) {

    let fastNode = head;
    let slowNode = head;

    while(fastNode != null && fastNode.next != null) {
        slowNode = slow.next;
        fastNode = fastNode.next.next;
    }

    let reversedSecondHalfNode = reverseLinkedList(slowNode);
    let firstHalfNode = head;

    while(reversedSecondHalfNode != null) {
        if(reversedSecondHalfNode.value != firstHalfNode.value) {
            return false;
        }
        reversedSecondHalfNode = reversedSecondHalfNode.next;
        firstHalfNode = firstHalfNode.next;
    }
    return true;
}

function reverseLinkedList(head) {
    let previousNode = null;
    let currentNode = head;

    while(currentNode != null) {
        let nextNode = currentNode.next;
        currentNode.next = previousNode;
        previousNode = currentNode;
        currentNode = nextNode;
    }
    return previousNode;
}

//! O(n) time | O(n) space
function linkedListPalindrome(head) {
  let currentNode = head;
	let values = [];
	let len = 0;
	
	while(currentNode != null) {
		values[len++] = currentNode.value;
		currentNode = currentNode.next;
	}
	
	let i = 0;
	let j = values.length - 1;
	
	while( i < j) {
		if(values[i] != values[j]) {
			return false;
		}
		i++;
		j--;
	}
return true;
}