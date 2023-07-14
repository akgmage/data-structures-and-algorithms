type MyQueue struct {
    stack1 []int
    stack2 []int
}

/** Initialize your data structure here. */
func Constructor() MyQueue {
    return MyQueue{}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
    this.stack1 = append(this.stack1, x)
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
    if len(this.stack2) == 0 {
        this.moveElements()
    }
    element := this.stack2[len(this.stack2)-1]
    this.stack2 = this.stack2[:len(this.stack2)-1]
    return element
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
    if len(this.stack2) == 0 {
        this.moveElements()
    }
    return this.stack2[len(this.stack2)-1]
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
    return len(this.stack1) == 0 && len(this.stack2) == 0
}

/** Move elements from stack1 to stack2. */
func (this *MyQueue) moveElements() {
    for len(this.stack1) > 0 {
        element := this.stack1[len(this.stack1)-1]
        this.stack1 = this.stack1[:len(this.stack1)-1]
        this.stack2 = append(this.stack2, element)
    }
}

/*

The MyQueue struct is defined with two slices: stack1 and stack2. stack1 represents the main stack where elements are pushed initially, and stack2 is used to reverse the order of elements for queue operations.

The Constructor function is a constructor for the MyQueue struct. It initializes an empty MyQueue instance and returns it.

The Push method takes an integer x and appends it to the stack1 slice, which represents the back of the queue.

The Pop method removes and returns the element from the front of the queue. It checks if stack2 is empty, and if so, it calls the moveElements method to transfer elements from stack1 to stack2. This ensures that the elements in stack2 are in the correct order for queue operations. The last element of stack2 is then removed and returned as the result.

The Peek method returns the element at the front of the queue without removing it. It performs the same check as the Pop method to ensure that the elements in stack2 are up to date, and then returns the last element in stack2.

The Empty method checks if both stack1 and stack2 are empty, indicating whether the queue is empty or not.

The moveElements method is used to transfer elements from stack1 to stack2 in the correct order. It pops elements from stack1 and appends them to stack2 until stack1 is empty. This ensures that the elements in stack2 are in the reversed order, mimicking the behavior of a queue.
Time Complexity:

The Push operation has a time complexity of O(1) because it simply appends an element to the stack1 slice.
The Pop operation has an amortized time complexity of O(1). When stack2 is not empty, popping an element is a constant-time operation. If stack2 is empty, the moveElements method is called, which transfers all elements from stack1 to stack2. This transfer operation takes O(n) time, where n is the number of elements in stack1. However, each element is transferred at most twice in total (once from stack1 to stack2 and once from stack2 back to stack1 in future push operations). Therefore, the average time complexity per pop operation is O(1).
The Peek operation has the same amortized time complexity as Pop, which is O(1).
The Empty operation has a time complexity of O(1) because it checks the lengths of both stack1 and stack2 to determine if the queue is empty.
Space Complexity:

The space complexity of the MyQueue struct is O(n), where n is the number of elements stored in the queue. This includes the space required for the stack1 and stack2 slices.
In the worst case, when all elements are stored in stack1, the space complexity is O(n). However, when elements are transferred from stack1 to stack2, the space complexity remains O(n) because each element is moved and stored only once

*/
