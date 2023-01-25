//! O(n) time | O(n) space
function nextGreaterElement(array) {
    const result = new Array(array.length).fill(-1);
    const stack = [];

    for(let idx = 2 * array.length - 1; idx > -1; idx--) {
        
        const circularIdx = idx % array.length;
        while(stack.length > 0) {
            if(stack[stack.length - 1] <= array[circularIdx]) {
                stack.pop();
            } else {
                result[circularIdx] = stack[stack.length - 1];
                break;
            }
         }
         stack.push(array[circularIdx]);
    }
    return result;
}

// function nextGreaterElement(arr) {
//   let n = arr.length;
// 	let array = Array(2 * n);
// 	let result = [];
// 	for(let i = 0; i < arr.length; i++) {
// 		result[i] = -1;
// 	}
// 	for(let i = 0; i < arr.length; i++) {
// 		array[i] = array[n + i] = arr[i];
// 	}
// 	for(let i = 0; i < arr.length; i++) {
// 		let j = i + 1;
// 		while(j < arr.length + i + 1) {
// 			if(array[j] > array[i]) {
// 				result[i] = array[j];
// 				break;
// 			}
// 			j++;
// 		}
// }
// 	return result;
// }


const array = [2, 5, -3, -4, 6, 7, 2];

console.log(nextGreaterElement(array))