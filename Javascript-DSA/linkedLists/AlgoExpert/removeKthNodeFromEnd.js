class Node {
    constructor(value) {
        this.value = value;
		this.next = null;
    }
}
class LinkedList {
	constructor() {
		this.head = null;
	}
	insertElementAtStart(data) {
        let newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }
}

function removeKthNodeFromEnd(head, k) {
	let first = head;
	let second = head;
	let counter = 1;
	while(counter <= k) {
		second = second.next;
	}
	if(second == null) {
		let temp = head;
		head = head.next;
		temp.next = null;
		return;
	}
	while(second.next != null) {
		first = first.next;
		second = second.next;
	}
	first.next = first.next.next;
}

