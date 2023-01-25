
// https://leetcode.com/problems/simplify-path/
var simplifyPath = function(path) {
    
    let startingWithSlash = path[0] === '/';
    let tokens = path.split('/').filter(isImportantToken);
    let stack = [];
    
    if(startingWithSlash) stack.push('');
    
    for(const token of tokens) {
        if(token === '..') {
            if(stack.length == 0 || stack[stack.length - 1] === '..')
                stack.push(token);
            else if(stack[stack.length - 1] !== '')
                stack.pop();
        } else {
            stack.push(token);
        }
    }
    if(stack.length === 1 && stack[stack.length - 1] === '') return '/';
    return stack.join('/');
};

function isImportantToken(token) {
    return token.length > 0 && token !== '.';
}