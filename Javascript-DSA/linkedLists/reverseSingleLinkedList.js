class Node { //! Node class
    constructor(data) {
        this.data = data;
        this.next = null;
    } 
}
// 
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
       printSingleLinkedList() {
        let current = this.head;
            while(current) {
            console.log(current);
            current = current.next;
            }
    }

    // reverseLinkedList() {
    //     let prev = null;
    //     let current = this.head;
    // while (current) {
    //     let following = current.next;
    //     current.next = prev;
    //     prev = current;
    //     current = following;
    // }
    //     let s = prev;
    //         while(s) {
    //         console.log(s);
    //         s = s.next;
    //         }
    // }

    reverseLinkedList() {
        let p1 = null;
        let p2 = this.head;
        // let p3 = this.head;
        while(p2) {
            const p3 = p2.next;           
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        let s = p1;
            while(s) {
            console.log(s);
            s = s.next;
            }
    }
}
let singleLinkedList = new SingleLinkedList();
singleLinkedList.insertElementAtStart(10);
singleLinkedList.insertElementAtEnd(20);
singleLinkedList.insertElementAtEnd(30); 
singleLinkedList.insertElementAtEnd(40);
singleLinkedList.reverseLinkedList();


