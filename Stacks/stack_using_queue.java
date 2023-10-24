// stack using queues
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> primaryQueue;
    private Queue<Integer> tempQueue;

    public StackUsingQueues() {
        primaryQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int value) {
        // Add the element to the primary queue
        primaryQueue.offer(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        // Move elements from the primary queue to the temporary queue except the last one
        while (primaryQueue.size() > 1) {
            tempQueue.offer(primaryQueue.poll());
        }

        // Get the last element from the primary queue (top of the stack)
        int topElement = primaryQueue.poll();

        // Swap the primary and temporary queues
        Queue<Integer> swap = primaryQueue;
        primaryQueue = tempQueue;
        tempQueue = swap;

        return topElement;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        int topElement = pop();

        // Add the top element back to the stack
        push(topElement);

        return topElement;
    }

    public boolean isEmpty() {
        return primaryQueue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop elements from the stack
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2

        // Push more elements
        stack.push(4);
        stack.push(5);

        // Peek at the top element
        System.out.println(stack.top()); // Output: 5

        // Check if the stack is empty
        System.out.println(stack.isEmpty()); // Output: false
    }
}
