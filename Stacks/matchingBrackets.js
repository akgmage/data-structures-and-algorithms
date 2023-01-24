//! 07/02/2022
function matchingBrackets(string) {
    const openingBrackets = '({[';
    const closingBrackets = ')}]';
    const matchingBrackets = { ')': '(', '}': '{', ']': '[' };

    let stack = []; 

    for(char of string) {
        if(openingBrackets.includes(char)) {
            stack.push(char);
         } else if(closingBrackets.includes(char)) {
                if(stack.length === 0) return false;
                else if(stack[stack.length - 1] === matchingBrackets[char])
                stack.pop();
            }
        }
        return stack.length === 0;
    }

    let string = '(({}}[]()))';


    console.log(matchingBrackets(string));