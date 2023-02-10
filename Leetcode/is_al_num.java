/**
 * You are given a function isalpha() consisting of a character array A.
 *
 * Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * Only argument is a character array A.
 *
 *
 *
 * Output Format
 * Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
 * Input 2:
 *
 *  A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All the characters are alphanumeric.
 * Explanation 2:
 *
 *  All the characters are NOT alphabets i.e ('#').
 */
package Strings;

public class IsAlNum {
    public static void main(String[] args) {
        char[] chars = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0', '$'};

        boolean res = solve(chars);
        System.out.println(res);
    }
    public static boolean solve(char[] A) {

        // O(N) time | O(N) space
         String string = new String(A);

         return string.matches("[a-zA-Z0-9]*");

        // O(N) time | O(1) space
//        for(Character x: A){
//            if(!Character.isLetterOrDigit(x)){
//                return true;
//            }
//        }
//        return false;


    }
}

