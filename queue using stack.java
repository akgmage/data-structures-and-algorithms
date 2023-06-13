/*
Issue:#253
Author:maneesha
Date:13/06/2023
##Assignee:Mani1881
//About:

Implement Queue using Stacks in java
//Input:

>>Implement a first in first out (FIFO) queue using only two stacks.
>>The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
~void push(int x) Pushes element x to the back of the queue.
~int pop() Removes the element from the front of the queue and returns it.
~int peek() Returns the element at the front of the queue.
~boolean empty() Returns true if the queue is empty, false .
//Example:

>> Sample Input:
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
>>Sample Output:
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1](here we are not returning push element so in output we got null)
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
//Complexity:

>>Time Complexity
push:O(n)
pop:O(1)
peek:O(1)
empty:O(1)
>>Space Complexity:O(n)
//Example:

//Explanation

>>The provided code implements a queue using two stacks (`s1` and `s2`). 
>>The `push()` method transfers elements from `s1` to `s2`, adds the new element to `s1`, and then transfers elements back to `s1`.
>>The `pop()` method removes and returns the top element of `s1`. 
>>The `peek()` method returns the top element of `s1` without removing it. 
>>The `empty()` method checks if `s1` is empty.
>>This implementation maintains FIFO order.
*/
class MyQueue 
{
Stack<Integer>s1=new Stack();
Stack<Integer>s2=new Stack();
   
    public void push(int x)
    {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.empty())
        {
            s1.push(s2.pop());
        }
    }
    
    public int pop()
    {
        return s1.pop();
    }
    
    public int peek() 
    {
        return s1.peek();
    }
    
    public boolean empty() 
    {
        return s1.isEmpty();
   }
  public static void main(String[] args) 
  {
    MyQueue queue = new MyQueue();
    
    // Pushing elements into the queue
    queue.push(1);
    queue.push(2);
    queue.push(3);
    
    // Checking the front element of the queue
    System.out.println("Front element: " + queue.peek()); // Output: Front element: 1
    
    // Removing elements from the queue
    System.out.println("Removed element: " + queue.pop()); // Output: Removed element: 1
    System.out.println("Removed element: " + queue.pop()); // Output: Removed element: 2
    
    // Checking if the queue is empty
    System.out.println("Is the queue empty? " + queue.empty()); // Output: Is the queue empty? false
    
    // Pushing another element into the queue
    queue.push(4);
    
    // Removing the remaining elements from the queue
    System.out.println("Removed element: " + queue.pop()); // Output: Removed element: 3
    System.out.println("Removed element: " + queue.pop()); // Output: Removed element: 4
    
    // Checking if the queue is empty after removing all elements
    System.out.println("Is the queue empty? " + queue.empty()); // Output: Is the queue empty? true
}
} 
