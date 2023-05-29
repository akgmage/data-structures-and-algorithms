/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem :  Add Reverse Words in a String in Java
Issue Number : #349
Problem statement : 

Explanation of the below Java code :

First, we import the java.util.Scanner class, which allows us to take input from the user.

We define a class called ReverseWordsInString.

Inside the main method, we create a new Scanner object named scanner to read user input.

We prompt the user to enter a string by using System.out.print("Enter a string: ") and then call scanner.nextLine() to read the user's input and store it in the input variable.

Next, we call the reverseWords method and pass the input string as an argument. The reverseWords method takes the input string, splits it into an array of words using the split("\\s+") method (which splits the string based on whitespace), and stores the words in the words array.

We create a StringBuilder named reversed to build the reversed string.

Using a loop, we iterate over the words array in reverse order (starting from the last word) and append each word, followed by a space, to the reversed string.

Finally, we return the reversed string by calling reversed.toString().trim(), which converts the StringBuilder to a String and trims any leading or trailing whitespace.

The reversed string is then printed to the console using System.out.println("Reversed String: " + reversed).

Finally, we close the Scanner object to release system resources by calling scanner.close().



*/

-------------------------------------------------------------------------//Java code begins here-------------------------------------------------------------

import java.util.Scanner;

public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String reversed = reverseWords(input);
        System.out.println("Reversed String: " + reversed);
        scanner.close();
    }

    public static String reverseWords(String input) {
        String[] words = input.split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        return reversed.toString().trim();
    }
}
