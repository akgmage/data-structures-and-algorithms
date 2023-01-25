//! Double ended queue
//! 10/02/2022
class Deque {
    constructor() {
        this.data = [];
        this.front = 0;
        this.rear = 0;

    }

    isEmpty() {
        return (this.rear - this.front == 0);
    }

    addBack(element) {
        this.data[this.rear] = element;
        this.rear++;
        
    }

    addFront(element) {
        if(this.isEmpty()) {
            this.addBack(element);
        }
        else if(this.front == 0) {
            let arr = new Array(2 * (this.rear - this.front));
            let i = arr.length - 1;
            let j = this.rear - 1;

            while(j >= this.front) {
                arr[i] = this.data[j];
                i--;
                j--;
            }
            this.front = i; 
            this.rear = arr.length;   
            this.data = arr;
            this.data[this.front] = element;
        }
        else {
            this.front--;
            this.data[this.front] = element;

        }
    }


    removeFront() {
        if(!this.isEmpty()) {
            let temp = this.data[this.front++];
            return temp;
        }
        return undefined;
    }

    removeBack() {
        if(!this.isEmpty()) {
            let temp = this.data[this.rear - 1];
            this.rear--;
            return temp;
        }
        return undefined;
    }
    
    getFront() {
        if(!this.isEmpty()) {
            return this.data[this.front];
        }
        return undefined;
    }
}
 
const dequeue = new Deque();

dequeue.addBack(10);
dequeue.addBack(20);
dequeue.addFront(30);
console.log(dequeue.getFront());
dequeue.removeBack();
dequeue.removeFront();
console.log(dequeue.getFront());
dequeue.addFront(100);
console.log(dequeue.getFront());