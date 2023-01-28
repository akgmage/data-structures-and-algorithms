/*
Bubble sort is a sorting algorithm that compares two adjacent elements 
and swaps them until they are in the intended order.
*/


class Solution {  
    void bubbleSort(int[] arr) {  
        int n = arr.length;  

        //loop to access each array element
         for(int i=0; i < n; i++){ 

             //loop to compare array elements 
            for(int j=1; j < (n-i); j++){ 

                //compare two adjacent elements 
                if(arr[j-1] > arr[j]){

                    //swapping elements if elements are not in the intended order
                    int temp = 0;    
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                    }  
                }
            }  
    }  
}
class Main {
    public static void main(String[] args) {
       int inputArr[]={22,4,67,8,98,1};
       Solution s=new Solution();
       s.bubbleSort(inputArr);
       for(int i=0; i<inputArr.length;i++)
             System.out.println(inputArr[i]);
    }
}