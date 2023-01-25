//! 08/02/2022
//! prevGreater is opposite of next smaller, just reverse given array and result array
function prevGreater(array) {
    array.reverse();
    let result = new Array(array.length).fill(-1);
    // const stack = new Stack();
    const stack = [];
    
    for(let i = 0; i < array.length; i++) {

        while(stack.length > 0 && array[stack[stack.length - 1]] < array[i]) {
            const top = stack.pop();
            result[top] = array[i];
        }
        stack.push(i);
    }
    return result.reverse();
}

let array = [2, 7, 3, 5, 4, 6, 1];


console.log(prevGreater(array));