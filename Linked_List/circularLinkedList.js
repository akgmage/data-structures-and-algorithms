class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    constructor() {
        this.tail = null;
        this.length = 0;
    }

    insertToEmpty(tail, data) {
        if(this.tail != null) {
            return this.tail;
        }
        let newNode = new Node(data);
        this.tail = newNode;
        this.tail.next = newNode;
        this.length++;

        return this.tail;
    }
    printCircularLinkedList(tail) {
        let current;

        if(tail == null) {
            console.log("List is empty");
            return;
        }

        current = this.tail.next;
        do {
            console.log(current.data);
            current = current.next;
        } while(current != this.tail.next);
    }

    size() {
        console.log(this.length);
    }

    insertAtStart(data) {
        if(this.tail == null) {
            return this.insertToEmpty(this.tail, data);
        }
        let newNode = new Node(data);

        newNode.next = this.tail.next; //! set next node of new node to current head.
        this.tail.next = newNode;
        this.length++;
        return this.tail;
    }

    insertAtEnd(data) {
        if (this.tail == null) {
            return this.insertToEmpty(this.tail, data);
        }
        let newNode = new Node(data);
        newNode.next = this.tail.next;
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
        return this.tail;
    }
    insertAtIndex(data, index) {
        if(index == 0) {
            this.insertAtStart(data);
        } else if (index < 0 || index >= this.length) {
            console.log("Array index out of bounds");
        } else {
            let newNode = new Node(data);
            let current, previous;
            current = this.tail.next;
            let count = 0;
            while (count < index) {
               previous = current;
               current = current.next;
               count++;
            }
            newNode.next = current;
            previous.next = newNode;

            this.length++;
            return this.tail;
        }
    }
    getElement() {
        if (index < 0 || index >= this.length) {
            console.log('Array index out of bounds');
        } else {
            let current = this.tail.next;
            let count = 0;
            do {
                if (count == index && current != null) {
                    console.log(current.data);
                }
                count++;
                current = current.next;
            } while (current != this.tail.next);
        } 
    }
    removeAt(index) {
        if (index == 0) {
            if(this.tail.next != null) {
                return false;
            }
        let current = this.tail.next;
        this.tail.next = current.next;
        current = null;

        this.length--;
    } else if (index < 0 || index >= this.length) {
        console.log("Array index out of bounds");
    } else {
        let current, previous;
        current = this.tail.next;
        let count = 0;
        while (count < index) {
            count++;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        current = null;
        this.length--;

    }
  }  
}
 
const cll = new CircularLinkedList();
// cll.insertAtStart(500);
// cll.insertAtStart(1000);
// cll.insertAtEnd(800);
// cll.insertAtEnd(600);
// cll.insertAtIndex(50, 1);
// cll.insertAtIndex(250, 3);
// cll.printCircularLinkedList();

tail = cll.insertAtStart(500);
tail = cll.insertAtStart(1000);
tail = cll.insertAtEnd(800);
tail = cll.insertAtEnd(600);
tail = cll.insertAtIndex(50, 1);
tail = cll.insertAtIndex(250, 3);

console.log(tail);

cll.removeAt(0);
cll.removeAt(2);

cll.printCircularLinkedList(tail);
cll.size();