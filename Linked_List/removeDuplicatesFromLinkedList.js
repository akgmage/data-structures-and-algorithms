class LinkedList {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}
//! O(n) time | O(1) space
function removeDuplicatesFromLinkedList(linkedList) {
 let currentNode = linkedList;
 while(currentNode != null) {
	let nextDistinctNode = currentNode.next;
	while(nextDistinctNode != null && currentNode.value == nextDistinctNode.value) {
		  const temp = nextDistinctNode;
		  nextDistinctNode = nextDistinct.next;
		  temp.next = null;
	}
	currentNode.next = nextDistinctNode;
	currentNode = currentNode.next;	
 }
 return linkedList;
}
