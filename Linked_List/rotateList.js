//!62  https://leetcode.com/problems/rotate-list/ 

function rotateList(head, k) {

    if(head == null) return null;

    let tail = head;
    let len = 1;

    while(tail.next != null) {
        tail = tail.next;
        len++;
    }

    tail.next = head;

    k = k % len;

    let currentNode = head;

    let counter = 1;

    while(counter <= len - k - 1) {
        currentNode = currentNode.next;
        counter++;
    }

    const newHead = currentNode.next;
    currentNode.next = null;
    return newHead;
}