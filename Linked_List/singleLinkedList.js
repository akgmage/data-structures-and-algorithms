class Node { //! Node class
    constructor(data) {
        this.data = data;
        this.next = null;
    } 
}

class SingleLinkedList { //! linkedlist class
    constructor() {
        this.head = null;
        this.length = 0;
    }

    //! insert at start
    insertElementAtStart(data) {
        let newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    //! insert at end
    insertElementAtEnd(data) {
        let newNode = new Node(data); //! create a new node
        let s = null; //! to keep track of current head
        if(this.head == null) {
            this.head = newNode;
        }
        else {
            s = this.head;
            while(s.next != null) {
                s = s.next;
            }
            s.next = newNode;
        }
        this.length++;

    }
    //! insert at index
    insertElementAtIndex(data, index) {
        //! 
        if(index == 0) {
            this.insertAtStart(data);
        }
        else if(index < 0 || index >= this.length) 
        console.log("Array index out of bounds");
     else {
        let newNode = new Node(data);
        let current, previous;
        current = this.head;
        let count = 0;
        //! traverse till index-1 as linked list has 0 based indexing
        while(count < index) {
            previous = current;
            current = current.next;
            count++;
        }
        newNode.next = current; //! set next of new node to current node.
        previous.next = newNode; //! set next of previous node to new node.
        current = null;
        
    }
}
getElement(index) {
        if(index < 0 || index>= this.length) {
            console.log('Array index out of bounds');
        } else {
            let current = this.head;
            let count = 0;
            while(count != index) {
                count++;
                current = current.next;
            }
            console.log(current.data);
        }

    }
    printSingleLinkedList() {
        let current = this.head;
            while(current) {
            console.log(current);
            current = current.next;
            }
    }
    size() {
        console.log(this.length);
    }

    getLinkedListSize() {
        let count = 0;
        let s = this.head;
        let p = null;

        while(s.next != null) {
            p = s;
            s = s.next;
            count++;
        }
        console.log(count);

    }
}

let singleLinkedList = new SingleLinkedList();

singleLinkedList.insertElementAtStart(10);
singleLinkedList.insertElementAtEnd(20);
singleLinkedList.insertElementAtEnd(30); 
singleLinkedList.insertElementAtEnd(40);
singleLinkedList.insertElementAtIndex(50, 3);
singleLinkedList.getElement(3);
singleLinkedList.size();
singleLinkedList.getLinkedListSize();

singleLinkedList.printSingleLinkedList();

