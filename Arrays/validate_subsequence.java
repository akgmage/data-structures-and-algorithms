/**
 *

 Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.

 A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array. For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4]. Note that a single number in an array and the array itself are both valid subsequences of the array.
 Sample Input

 array = [5, 1, 22, 25, 6, -1, 8, 10]
 sequence = [1, 6, -1, 10]

 Sample Output

 true


 */
public class ValidateSubsequence {
    public static void main(String[] args){
        int[] array = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {1, 6, -1, 19};

        System.out.println(solve(array, sequence));
    }
    public static boolean solve(int[] array, int[] sequence) {

        int seqIdx = 0;
        for(var num: array) {
            if(seqIdx == sequence.length) break;
            if(sequence[seqIdx] == num ) seqIdx++;
        }
        return seqIdx == sequence.length;
    }
}