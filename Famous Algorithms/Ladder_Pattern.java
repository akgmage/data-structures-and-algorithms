/*
Problem: Given an integer N, the task is to print the ladder with N steps using ‘*’. The ladder will be with the gap of 3 spaces between two side rails.

Approach:
First, we take input from the user for the number of steps in the ladder.
We then iterate from 1 to N, where N is the number of steps, to print each step of the ladder.
Inside the loop, we call the printSideRail() function to print a side rail at the beginning of each step.
We then call the printStep(stepNumber) function to print the actual step. This function prints stepNumber asterisks with 3 spaces between each asterisk.
Finally, we again call the printSideRail() function to print a side rail at the end of each step and move to the next line to start a new step.

Note: The number of spaces between the asterisks in each step can be adjusted by modifying the value inside the 'printSideRail()' and 'printStep(stepNumber)' functions.

Time complexity: O(N) for given input N steps
Auxiliary Space:  O(1) as constant extra space is used

*/

import java.util.Scanner;

public class LadderPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of steps in the ladder: ");
        int N = sc.nextInt();
        
        // Print the ladder with N steps
        for (int i = 1; i <= N; i++) {
            printSideRail();
            printStep(i);
            printSideRail();
            System.out.println();
        }
    }
    
    // Function to print a side rail
    public static void printSideRail() {
        System.out.print("*   ");
    }
    
    // Function to print a step
    public static void printStep(int stepNumber) {
        for (int i = 1; i <= stepNumber; i++) {
            System.out.print("*   ");
        }
    }
}

/*

Enter the number of steps in the ladder: 5
*   * 
*   *   * 
*   *   *   * 
*   *   *   *   * 
*   *   *   *   *   * 

*/
