function mergeSort(head) {
if(head == null || head.next == null) return head;

    const mid = findMid(head);
    let left = head;
    let right = mid.next;
    mid.next = null;

    left = mergeSort(left);
    right = mergeSort(right);

    return mergeTwoLists(left, right);
}

function findMid(head) {
    let slow = head;
    let fast = head.next;

    while(fast != null && fast.next == null) {
        slow = slow.next;
        fast = fast.next.next;
    }
}

function mergeTwoLists(left, right) {
    
    if(left == null) return right;
    if(right == null) return left;

    let dummy = new Node(-1);

    let currentNode = dummy;

    while(left != null && right != null) {
        if(left.value < right.value) {
            currentNode.next = left;
            currentNode = currentNode.next;
            left = left.next;
        } else {
            currentNode.next = right;
            currentNode = currentNode.next;
            right = right.next;
        }
     }

     while(left != null) {
        currentNode.next = left;
        currentNode = currentNode.next;
        left = left.next;
     }

     while(right != null) {
        currentNode.next = right;
        currentNode = currentNode.next;
        right = right.next;
     }

     return dummy.next;
}