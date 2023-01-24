//! 10/02/2022

function prevGreater(array) {
    let result = new Array(array.length).fill(-1);
    const stack = [];
    
    for(let i = array.length - 1; i >= 0; i--) {
        while(stack.length > 0 && array[stack[stack.length - 1]] < array[i]) {
            const top = stack.pop();
            result[top] = i;
        }
        stack.push(i);
    }
    return result;
}

function stockSpan(array) {
    let result = [];
    const prev = prevGreater(array);
    for(let i = 0; i < array.length; i++) {
        result[i] = i - prev[i];
    }
    return result;
}

let array = [31, 27, 14, 21, 30, 22];

console.log(stockSpan(array));

