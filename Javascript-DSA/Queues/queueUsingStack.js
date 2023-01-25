class Queue {
    constructor() {
        this.stack1 = [];
        this.stack2 = [];
        this.rear1 = 0;
        this.front1 = 0;
        this.rear2 = 0;
        this.front2 = 0;
    }
    length() {
        return this.rear - this.front;
    }

    isEmpty() {
        return this.length == 0;
    }

    enqueue(element) {
        this.stack1[this.rear++] = element;
    }

    dequeue() {
        while(this.front1 < this.rear1) {
            this.stack2[this.rear2++] = this.stack1[this.front1++];
        }
        let temp = this.stack1[this.front1++];
        return temp;
    }

    getFront() {
        if(!this.isEmpty()) {
            return this.stack1[this.front];
        }
        return undefined;
    }
}

const queue = new Queue();

queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);
queue.enqueue(40);
queue.enqueue(50);
console.log(queue.dequeue());


// console.log(queue.getFront());