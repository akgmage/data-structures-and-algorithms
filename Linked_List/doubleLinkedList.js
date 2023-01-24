class Node {
    constructor(data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

}

class DoubleLinkedList {
    constructor() {
        this.head = null;
        this.length = 0;
    }

    insertAtStart(data) {
    let newNode = new Node(data);
    newNode.next = this.head;
    newNode.previous = null;

     if(this.head != null) {
        this.head.previous = newNode;
    }
    this.head = newNode;
    this.length++;
    }
    
    insertAtEnd(data) {
        let newNode = new Node(data);

        if(this.head == null ){
            this.head = newNode;
            this.length++;
        } else {
            let current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
            this.length++;
        }
    }
    insertAtIndex(data, index) {
        if(index == 0) {
            this.insertAtStart(data);
        }
        else if(index < 0 || index >= this.length) {
            console.log('Array index out of bounds');
        } else {
            let newNode = new Node(data);
            let current = this.head;
            let count = 0;
            while (count < index) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            newNode.previous = current;
            newNode.previous.next = newNode;
            current = null;
            this.length++;
        }
    }

    
    size() {
        console.log('Length of Double Linked List is ' + this.length);
    }
    getLinkedListSize() {
        let s = this.head;
        let p = null;
        let count = 0;

        while(s != null ){
            p = s;
            s = s.next;
            count++;
        }
        console.log("count", count);
    }

    getElement(index) {
        if(index < 0 || index >= this.length) {
            console.log('Array index out of bounds');
        } else {
            let current = this.head;
            let count = 0;
            while(current != null) {
                if(count == index) {
                    console.log(current.data);
                }
                count++;
                current = current.next;
            }
        }

    }
    removeAtStart() {
        if(this.head == null) {
            return false;
        }
        let currentData = this.head.data;
        this.head = this.head.next;
        this.head.previous = null;

        this.length--;
        console.log(currentData);
    }
    removeAtEnd(index) {
        if(index == 0) {
            this.removeAtStart();
        } else if(index < 0 || index >= this.length) {
            console.log('Array index out of bounds');
        } else {
            let current = this.head;
            let count = 0;
            while(count < index) {
                count++;
                current = current.next;
            }
            if(current.previous != null) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            current = null;
            this.length--;
        }
    }


    printDoubleLinkedList() {
        let current = this.head;

        while(current != null) {
            console.log(current);
            current = current.next;
        }
    }


}

const dll = new DoubleLinkedList();
dll.insertAtStart(100);
dll.insertAtEnd(500);
dll.insertAtEnd(1000);
dll.insertAtEnd(800);
dll.insertAtEnd(600);
dll.insertAtIndex(400, 4); 
dll.printDoubleLinkedList();
dll.size();
dll.getLinkedListSize();
dll.removeAtStart();
dll.getElement(4);

