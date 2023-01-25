
//! 07/02/2022
class Stack {
    constructor() {
        this.top = -1;
        this.data = [];
    }

    push(element) {
        this.top = this.top + 1; 
        this.data[this.top] = element;
    }
    isEmpty() {
        return this.top == 0;
    }

    removeConsecutiveDuplicates(arr) {

    for (let i = 0; i < arr.length; i++) {
        if (this.data[this.top] !== arr[i]) 
        st.push(arr[i]); 
    }

}

}
let arr = [1, 2, 1, 1, 3, 3, 3, 3, 2, 1, 1];

const st = new Stack();

st.removeConsecutiveDuplicates(arr);

function removeDuplicates(arr) {

    let prev = arr[0];
    let result = [];
    result.push(prev);

    for (let i = 1; i < arr.length; i++) {
            if (arr[i] !== prev) {
                prev = arr[i];
                result.push(prev);               
            }
    }
    console.log(result);
}

removeDuplicates(arr);

