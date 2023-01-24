//! O(n^2) time | O(n) space

function sortStack(stack) {
    if(stack.length == 0) return stack;

    const top = stack.pop();

    sortStack(stack);

    insertInSortedOrder(stack, top);
    return stack;
}

function insertInSortedOrder(stack, top) {

    if(stack.length == 0 || stack[stack.length - 1] <= top) {
        stack.push(top);
        return;
    }

    const top = stack.pop();

    insertInSortedOrder(stack, top)

    stack.push(top);
}