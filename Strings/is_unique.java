/*
    Implement an algorithm to determine if a string has all unique characters.
    what if you cannot use additional data structures?

    Explanation:
   - The `isUniqueUsingBitVector` function takes a string `s` as input and returns a boolean value indicating whether the string has all unique characters.
   - The variable `checker` is initialized as an integer, representing the bit vector to keep track of character occurrences.
   - The function iterates over each character `c` in the string using a foreach loop.
   - For each character, the variable `val` is computed by subtracting the ASCII value of `'a'` from the ASCII value of the character. This gives the corresponding index (0-25) for lowercase alphabetic characters.
   - The program checks if the bit at position `val` in `checker` is already set. If it is, it means the character has occurred before, and the function returns `false`.
   - If the character is unique, the bit at position `val` in `checker` is set by performing a bitwise OR operation with `(1 << val)`. This marks the occurrence of the character in the bit vector.
   - After iterating through all the characters, if no duplicate characters are found, the function returns `true`.
   - In the `main` function, a few test cases are provided, and the result of calling `isUniqueUsingBitVector` with each test case is printed.
*/
public class Main {
    public static boolean isUniqueUsingBitVector(String s) {
        int checker = 0; // Bit vector to keep track of character occurrences
        for (char c : s.toCharArray()) {
            int val = c - 'a'; // Convert character to corresponding index (0-25)
            if ((checker & (1 << val)) > 0) {
                // If the bit corresponding to the character is already set, it means the character has occurred before
                return false;
            }
            checker |= (1 << val); // Set the bit corresponding to the character to mark its occurrence
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ABCDD";
        String t = "ABCD";
        String u = "AAAAAABCD";
        boolean msg = isUniqueUsingBitVector(s);
        System.out.println(msg);
        msg = isUniqueUsingBitVector(t);
        System.out.println(msg);
        msg = isUniqueUsingBitVector(u);
        System.out.println(msg);

        msg = isUniqueUsingBitVector("aa");
        System.out.println(msg);
    }
}
