// Implemenmtation of  stack data structure
/*
    This implementation uses a generic type T to allow the stack to store elements of any type. 
    The stack is implemented using an array and has methods for pushing, popping, peeking, checking 
    if the stack is empty, and getting the size of the stack. The comments explain each step of the 
    implementation.
*/
public class Stack<T> {
    // array to store elements of the stack
    private T[] elements;
    // top index of the stack
    private int top;

    // constructor to initialize the stack with a given capacity
    public Stack(int capacity) {
        // create a new array of type T with the given capacity
        elements = (T[]) new Object[capacity];
        // initialize top index to -1
        top = -1;
    }

    // push an element onto the top of the stack
    public void push(T element) {
        // check if the stack is full
        if (top == elements.length - 1) {
            // if the stack is full, throw an exception
            throw new RuntimeException("Stack overflow");
        }
        // increment top index
        top++;
        // insert the element at the top index
        elements[top] = element;
    }

    // pop the top element from the stack and return it
    public T pop() {
        // check if the stack is empty
        if (top == -1) {
            // if the stack is empty, throw an exception
            throw new RuntimeException("Stack underflow");
        }
        // get the top element
        T element = elements[top];
        // decrement top index
        top--;
        // return the top element
        return element;
    }

    // return the top element of the stack without removing it
    public T peek() {
        // check if the stack is empty
        if (top == -1) {
            // if the stack is empty, throw an exception
            throw new RuntimeException("Stack underflow");
        }
        // return the top element
        return elements[top];
    }

    // return true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return top == -1;
    }

    // return the size of the stack
    public int size() {
        return top + 1;
    }
}
