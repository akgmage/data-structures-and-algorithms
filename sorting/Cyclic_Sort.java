/* 
What is Cyclic Sort?
The basic idea behind cycle sort is to divide the input array into cycles, where each cycle consists of elements that belong to the same position in the sorted output array. The algorithm then performs a series of swaps to place each element in its correct position within its cycle, until all cycles are complete and the array is sorted.
It is usually used where elements are in the range of (1,n)

Note : This Algorithm solution is for elements from 1-N , where N is the number of elements in the array.
Time Complexity Analysis: 
    Worst Case: O(n) 
    Average Case: O(n)
    Best Case: O(n)
Auxiliary Space: O(1)
*/

import java.util.Arrays;

public class Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr={3, 5, 2, 1, 4};    //Sample Input
        sort(arr);
        System.out.println(Arrays.toString(arr));   //Printing the original array
    }
    
  //Cyclic Sort Program
    static void sort(int[] arr){
        int i=0;    //Variable to iterate over each element of array
        while(i<arr.length){
            int correct=arr[i]-1;   //checking the correct position of the element 
            if(arr[i]!= arr[correct]){
                swap(arr,i,correct);    //swaping the element with its correct position
            }
            else{      /* if element is already at correct position, incrementing the value of i by 1. 
                      To further the check the value of next element */
                i++;    
            }
        }
    }

    static void swap(int[] arr,int one,int two){
        int temp=arr[two];
        arr[two]=arr[one];
        arr[one]=temp;
    }
}
