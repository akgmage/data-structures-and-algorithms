//! 07/02/2022
class Stack {
    constructor() {
        this.top = 0;
        this.data = [];
    }

    push(element) {
        this.data[this.top] = element;
        this.top = this.top + 1;
    }

    isEmpty() {
        return this.top == 0;
    }

    pop() {
        if(this.isEmpty()) {
            console.log("stack is underflow");
            return undefined;
        }
         this.top = this.top - 1;
         return this.data.pop();
    }
    //! top value
    peek() {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.data[this.top - 1];
    }
}

const st = new Stack();
st.push(100);
st.push(200);
st.push(300);
st.push(400); 
st.push(500);
st.push(600);

console.log(st.peek());
st.pop();

console.log(st.peek());