//! 10/02/2022

function nextSmaller(array) {

    let result = new Array(array.length).fill(-1);
    const stack = [];
    
    for(let i = 0; i < array.length; i++) {

        while(stack.length > 0 && array[stack[stack.length - 1]] > array[i]) {
            const top = stack.pop();
            result[top] = i;
           
        }
        stack.push(i);
    }
     for(let i = 0; i < result.length; i++) {
            if(result[i] == - 1) {
                result[i] = result.length;
            }
    }
    return result;
}

function prevSmaller(array) {
    let result = new Array(array.length).fill(-1);
    const stack = [];
    
    for(let i = array.length - 1; i >= 0; i--) {
        while(stack.length > 0 && array[stack[stack.length - 1]] > array[i]) {
            const top = stack.pop();
            result[top] = i;
        }
        stack.push(i);
    }

   
    return result;
}

function findArea(length, breadth) {
    return length * breadth;
}
function maxArea(array) {

    let prev = prevSmaller(array);
    // console.log(prev);
    let next = nextSmaller(array);
    // console.log(next);
    let max = 0;

    for(let i = 0; i < array.length; i++) {

        let prevSmallIndex = prev[i];
        let nextSmallIndex = next[i];
        let width = nextSmallIndex - prevSmallIndex - 1;
        let area = findArea(array[i], width);
        max = Math.max(max, area);
        
    } 
    return max; 
    
}

let array = [2, 1, 5, 6, 2, 3];
console.log(maxArea(array));

