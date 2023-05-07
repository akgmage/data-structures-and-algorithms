class Node {
    constructor(val) {
        this.val = val
        this.prev = null
        this.next = null
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null
        this.tail = null
        this.length = 0
    }

    insertAtTail(val) {
        const node = new Node(val)

        if (!this.head) {
            this.head = node
            this.tail = node
            this.length++
        } else {
            node.prev = this.tail
            this.tail.next = node
            this.tail = node
            this.length++
        }
    }

    insertAtHead(val) {
        const node = new Node(val)

        if (!this.head) {
            this.head = node
            this.tail = node
            this.length++
        } else {
            node.next = this.head
            this.head.prev = node
            this.head = node
            this.length++
        }
    }

    deleteAtTail() {
        if (!this.head) throw new Error("Empty Linked List!")

        if (this.length === 1) {
            this.head = null
            this.tail = null
            this.length--
        } else {
            this.tail = this.tail.prev
            this.tail.next = null
            this.length--
        }
    }

    deleteAtHead() {
        if (!this.head) throw new Error("Empty Linked List!")

        if (this.length === 1) {
            this.head = null
            this.tail = null
            this.length--
        } else {
            this.head = this.head.next
            this.head.prev = null
            this.length--
        }
    }

    print() {
        if (!this.head) console.log("Empty Linked List!")

        else {
            let curr = this.head
            let str = "null <- "
            while (curr) {
                str += curr.val
                if (curr.next) {
                    str += " <-> "
                } else {
                    str += " -> null"
                }
                curr = curr.next
            }
            console.log(str)
        }
    }

    getLength() {
        return this.length
    }

    getAtIdx(idx) {
        if (idx >= this.length || idx < 0) throw new Error("Index out of bounds!")

        else {
            let currIdx = 0
            let curr = this.head

            while (currIdx < idx) {
                curr = curr.next
                currIdx++
            }

            return curr.val
        }
    }

    putAtIdx(val, idx) {
        if (idx > this.length || idx < 0) throw new Error("Index out of bounds!")

        const node = new Node(val)

        if (idx === 0) {
            this.head.prev = node
            node.next = this.head
            this.head = node
        } else {
            let currIdx = 0
            let curr = this.head

            while (currIdx < idx) {
                curr = curr.next
                currIdx++
            }

            node.next = curr
            node.prev = curr.prev
            curr.prev.next = node
        }

        this.length++
    }

    deleteAtIdx(idx) {
        if (idx >= this.length || idx < 0) throw new Error("Index out of bounds!")

        let currIdx = 0
        let curr = this.head

        while (currIdx < idx) {
            curr = curr.next
            currIdx++
        }

        curr.prev.next = curr.next
        curr.next.prev = curr.prev
        this.length--
    }

    search(val) {
        let curr = this.head
        let currIdx = 0

        while (curr) {
            if (curr.val === val) return currIdx

            curr = curr.next
            currIdx++
        }

        return "Value not found"
    }

    toArray() {
        let arr = []

        let curr = this.head

        while (curr) {
            arr.push(curr.val)
            curr = curr.next
        }

        return arr
    }
}

// SAMPLE USECASE
const list = new DoublyLinkedList ()
list.insertAtHead (10)
list.insertAtTail (20)
list.insertAtHead (30)
list.insertAtTail (40)
list.putAtIdx (100, 2)
list.print ()