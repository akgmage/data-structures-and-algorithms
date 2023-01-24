class Queue {
    constructor() {
        this.data = [];
        this.rear = 0;
        this.front = 0;
    }
   
    length() {
        return this.rear - this.front;
    }

    isEmpty() {
        return this.length() == 0;
    }

    enqueue(element) {
        this.data[this.rear++] = element;
    }

    dequeue() {
        if(!this.isEmpty()) {
            let temp = this.data[this.front++];
            return temp;
        }
    }

    getFront() {
        if(!this.isEmpty()) {
            return this.data[this.front];
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

queue.dequeue();
queue.dequeue();

console.log(queue.isEmpty());