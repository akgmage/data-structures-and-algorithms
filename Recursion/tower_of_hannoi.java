/*
    The Tower of Hanoi problem is a classic problem in computer science and mathematics that involves moving a stack of disks from one peg to another peg. The problem consists of three pegs and a set of disks of different sizes that can slide onto any peg. The objective of the puzzle is to move the entire stack to another peg, obeying the following simple rules:

    Only one disk can be moved at a time.
    Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or an empty peg.
    No disk may be placed on top of a smaller disk.
    The Tower of Hanoi problem is often used as an example of recursive problem-solving. The solution to the problem can be divided into three parts:

    Move n-1 disks from the starting peg to the auxiliary peg.
    Move the largest disk from the starting peg to the destination peg.
    Move the n-1 disks from the auxiliary peg to the destination peg.
    This process is repeated recursively until all the disks have been moved from the starting peg to the destination peg. The number of moves required to solve the puzzle for n disks can be calculated using the formula 2^n - 1.

    Here's an implementation of the Tower of Hanoi problem in Java using recursion:

*/
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // number of disks
        char fromRod = 'A';
        char toRod = 'C';
        char auxRod = 'B';

        System.out.println("Moves to solve Tower of Hanoi problem with " + n + " disks:");
        solveHanoi(n, fromRod, toRod, auxRod);
    }

    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }
}


// -----------------------Explanation------------------------------

// In this implementation, the solveHanoi method is called recursively to move the disks from one rod to another. The method takes in four parameters:

// n: the number of disks
// fromRod: the rod from which the disks are to be moved
// toRod: the rod to which the disks are to be moved
// auxRod: the auxiliary rod which can be used to move the disks
// When the number of disks is 1, the method simply prints the move to be made. Otherwise, the method makes the following three recursive calls:

// Move n-1 disks from fromRod to auxRod using toRod as the auxiliary rod.
// Move the nth disk from fromRod to toRod.
// Move the n-1 disks from auxRod to toRod using fromRod as the auxiliary rod.
// This process is repeated recursively until all the disks have been moved from the starting rod to the destination rod.