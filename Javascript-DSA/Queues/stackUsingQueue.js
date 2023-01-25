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

class StackUsingQueue {
    constructor() {
        this.primary = new Queue();
        this.secondary = new Queue();

    }
    
    push(key) {
        this.primary.enqueue(key);
    }

    pop() {
        while(this.primary.length() > 1) {
            this.secondary.enqueue(this.primary.dequeue());
        }

        let temp = this.primary.dequeue();

        while(this.secondary.length() > 0) {
            this.primary.enqueue(this.secondary.dequeue());
        }
        return temp;
    }

}


const st = new StackUsingQueue();

st.push(10);
st.push(20);
st.push(30);
st.push(40);
st.push(50);

console.log(st.pop());