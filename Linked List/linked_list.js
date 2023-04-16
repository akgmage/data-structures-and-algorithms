/* 
    insertAtTail (val)
    insertAtHead (val)
    deleteAtTail ()
    deleteAtHead ()
    getLength ()
    print ()
    getAtIdx (idx)
    putAtIdx (val, idx)
    deleteAtIdx (idx)
    search (val)
    toArray ()
    reverse ()
*/

class Node {
    constructor(val) {
        this.val = val
        this.next = null
    }
}

class LinkedList {
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
            this.head = node
            this.length++
        }
    }

    print() {
        if (this.length === 0) console.log ("Empty Linked List!")
        else {
            let curr = this.head
            let str = ''

            while (curr) {
                str += curr.val + ' -> '
                curr = curr.next
            }

            console.log(str + 'null')
        }
    }

    deleteAtTail() {
        if (!this.head) console.log("Empty Linked List!")

        else {
            let curr = this.head
            let prev = this.head

            while (curr.next) {
                prev = curr
                curr = curr.next
            }

            prev.next = null
            this.tail = prev
            this.length--
        }
    }

    deleteAtHead() {
        if (!this.head) console.log("Empty Linked List!")

        else {
            let curr = this.head
            this.head = curr.next
            this.length--
        }
    }


    getLength() {
        return this.length
    }

    getAtIdx (idx) {
        if (idx >= this.length || idx < 0) throw new Error ("Index out of bounds")

        else {
            let currIdx = 0
            let curr = this.head

            while (currIdx < idx) {
                currIdx++
                curr = curr.next
            }

            return curr.val
        } 
    }

    putAtIdx (val, idx) {
        if (idx > this.length || idx < 0) throw new Error ("Index out of bounds")

        const node = new Node (val)

        if (!this.head) {
            this.head = node
            this.length++
            return
        }

        let currIdx = 0
        let curr = this.head
        let prev = this.head

        while (currIdx < idx) {
            currIdx++
            prev = curr
            curr = curr.next
        }

        prev.next = node
        node.next = curr
        this.length++
    }

    deleteAtIdx (idx) {
        if (idx >= this.length || idx < 0) throw new Error ("Index out of bounds")

        else {
            let currIdx = 0
            let curr = this.head
            let prev = this.head

            while (currIdx < idx) {
                currIdx++
                prev = curr
                curr = curr.next
            }

            prev.next = curr.next
            this.length--
        }
    }

    search (val) {
        if (!this.head) return "Empty Linked List!"
        if (!this.head.next && this.head.val !== val) return null
        if (!this.head.next && this.head.val === val) return 0
        
        let currIdx = 0
        let curr = this.head

        while (curr) {
            if (curr.val === val) return currIdx
            currIdx++
            curr = curr.next
        }

        return null
    }

    toArray () {
        const arr = []
        if (!this.head) return null

        let curr = this.head

        while (curr) {
            arr.push (curr.val)
            curr = curr.next
        }

        return arr
    }

    reverse () {
        if (!this.head) throw new Error ("Empty Linked List")
        if (!this.head.next) return

        let prev = null
        let curr = this.head
        let next = curr.next

        while (curr) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        this.head = prev
    }
}

// SAMPLE USECASE

const list = new LinkedList()
list.insertAtTail (10)
list.insertAtTail (20)
list.insertAtTail (30)
list.insertAtTail (40)
list.insertAtTail (50)
list.reverse ()
list.print ()