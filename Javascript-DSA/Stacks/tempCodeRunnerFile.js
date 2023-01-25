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
            // console.log("stack is underflow");
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

// function nextGreater(arr){
//     const st = new Stack();
//     st.push(0);
//     let output = new Array(arr.length);
//     for(let i = 1; i < arr.length; i++) {
//        while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
//            output[st.peek()] = arr[i];
//            st.pop();
//        }
//        st.push(i);
//     }
//     while(!st.isEmpty()) {
//         output[st.peek()] = -1;
//         st.pop();
//     }
//     return output;
// }

const st = new Stack();

// st.push(100);
// st.push(200);
// st.push(300);
// st.push(400); 
// st.push(500);
// st.push(600);



// console.log(nextGreater(arr));

function nextGreater(arr) {
    const result = new Array(arr.length).fill(-1);
    
    for(let i = 0; i < arr.length; i++) {
        
        const stack = new Stack();
        console.log(stack.length);

        while(stack.length > 0) {
        if(stack[stack.length - 1] <= arr[i]) {
            stack.pop();
        } else {
            result[i] = stack[stack.length - 1];
            console.log(result[i]);