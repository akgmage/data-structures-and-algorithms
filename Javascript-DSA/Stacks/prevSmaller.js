//! 08/02/2022
function prevSmaller(array) {
    let result = new Array(array.length).fill(-1);
    const stack = [];
    
    for(let i = array.length - 1; i >= 0; i--) {
        while(stack.length > 0 && array[stack[stack.length - 1]] > array[i]) {
            const top = stack.pop();
            result[top] = array[i];
        }
        stack.push(i);
    }
    return result;
}

let array = [2, 7, 3, 5, 4, 6, 1];

console.log(prevSmaller(array));