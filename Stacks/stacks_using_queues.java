/* Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Implement Stack using Queues in Java
Issue Number : #259
Problem statement :

Explanation of the below Java code :

In the above code, the main method demonstrates the usage of the stack by providing the user with a menu to select the operation they want to perform - push, pop, or quit. The user can input the value to push, and the program prints the pushed or popped value accordingly.

The program uses the Scanner class to take user input from the console. The push method adds the element to the first queue (q1) and updates the top variable. The pop method transfers all elements except the last one from q1 to q2, removes the last element from q1 and swaps the two queues. The peek method returns the top variable, and the isEmpty method checks if q1 is empty.

When the user selects the push operation, the program prompts the user to enter the value to push, and it calls the push method to push the value onto the stack. When the user selects the pop operation, the program checks if the stack is empty and prints an error message if it is. Otherwise, it calls the pop method to pop the value from the stack and prints it.

The program continues to prompt the user for input until the user selects the quit operation


*/
-------------------------------------------------------------------------------------------------------//Java code begins here--------------------------------------------------------------------------------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push(int x) {
        q1.add(x);
        top = x;
    }

    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int popValue = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return popValue;
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation -\n"
                    + "1. Push\n"
                    + "2. Pop\n"
                    + "3. Quit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter value to push: ");
                int val = scanner.nextInt();
                stack.push(val);
                System.out.println("Pushed value: " + val);
            } else if (choice == 2) {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty.");
                } else {
                    int val = stack.pop();
                    System.out.println("Popped value: " + val);
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
