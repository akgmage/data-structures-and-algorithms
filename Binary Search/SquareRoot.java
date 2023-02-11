/* Square root of a number
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
The returned integer should be non-negative as well.

Examples:
    Input: x = 36
    Output: 6
    Explanation: The square root of 36 is 6, so we return 6.

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 
                 2 is returned.
 

HOW TO SOLVE:
    This is similar to finding perfect square of number but to return the square root.
    We use Binary Search for this problem.
*/

public class SquareRoot{
    public static int sqrt(int x){
        int start = 1, end=x;
        while(start<=end){
            int mid = (start+end)/2;
            if(x/mid==mid){
                return mid;
            }
            else if(mid< x/mid){
                start = mid+1;
            }
            else if(mid > x/mid){
                end = mid-1;
            }
            
        }
        return end;
    }
     public static void main(String[] args){
        // you can also get input dynamically using Scanner class
        int number = 36;
        System.out.print(sqrt(number));
    }
    }