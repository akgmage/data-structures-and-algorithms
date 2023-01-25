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
st.push(700);
st.push(800);

/** 
 * ! 1. create an array and pop every element from stack and push into stack.
 * 
 * ! 2. use bottom up approach.
 */

function insertAtBottomIterative(stack, element) {
        const secondary = new Stack();

        while (!st.isEmpty()) {
            secondary.push(st.pop());
        }
        st.push(element);

        while (!secondary.isEmpty()) {
            st.push(secondary.pop());
        } 

}

function insertAtBottomRecursively(stack, element) {
    if (st.isEmpty()) {
        st.push(element);
        return;
    }
    const topElement = stack.pop();
    insertAtBottomRecursively(st, element);
    st.push(topElement);
}
// insertAtBottomIterative(st, 10);
insertAtBottomRecursively(st, 10);

console.log(st.peek());

console.log(st);

