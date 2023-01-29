/* finding the perfect square
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. 
In other words, it is the product of some integer with itself.

Examples:
Input: num = 25
Output: true
Explanation: We return true because 5 * 5 = 25 and 5 is an integer.

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

APPROACH:
    As we know square of a squareroot of a number is that number itself. for example if the number is 36 
    and the square root of 36 is 6 , we can say that 6*6 =36 (our number).
    We use this logic with binary search algorithm

*/

class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
            // Binary Search
            long start =1,end=num;
            while(start<=end){
                long mid = start + (end-start)/2;
                if(mid*mid == num){
                    return true;
                }
                else if(mid*mid > num){
                    end = mid-1;
                }
                else if(mid*mid < num){
                    start = mid+1;
                }
            }
            return false;
    }
    public static void main(String[] args){
        // you can also get input dynamically using Scanner class
        int number = 100;
        System.out.print(isPerfectSquare(number));
    
    }}