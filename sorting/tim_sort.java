//Implementation of Tim Sort
//Tim Sort makes use of insertionSort and Merge function of MergeSort
//The basic idea is to divide the input array into blocks called as runs
//The size of runs varies from 32 to 64, and perform insertion sort on the runs
//Then, The runs(blocks) are merged to form the final sorted array
//
//Time Complexity of this algorithm in Best case is O(n),Average case is O(n*log(n))
//Time Complexity in Worst case is O(n*log(n)).
//This is a stable sorting algorithm
//This algorithm uses Space of O(n)
//This algorithm is used in languages like Java and Python for sorting.

import java.util.Arrays;
class tim_sort
{
   static int run=32;  // you can take any value between 32 to 64, it actually is some empirical result from insertion sort
    public static void main(String[] args)
    {
        int[] arr={43,56,2,99,1,64,23,78,34,11,90,45,32,67,88,12,9,10,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println("Before Sorting: "+Arrays.toString(arr));
        timSort(arr,arr.length);
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }
    public static void timSort(int[] arr,int n)
    {
        for(int i=0;i<n;i+=run)
        {   
            insertionSort(arr,i,Math.min((i+31),(n-1)));
        }
        
        for(int size=run;size<n;size=2*size)
        {
            for(int left=0;left<n;left+=2*size)
            {
                int mid=left+size-1;
                int right=Math.min((left+2*size-1),(n-1));
                merge(arr,left,mid,right);
            }
        }
    }
    public static void insertionSort(int[] arr,int left,int right)
    {// simple insertion sort on array from left to right
        for(int i=left+1;i<=right;i++)
        {
            int temp=arr[i];
            int j=i-1;
            while(j>=left && arr[j]>temp)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    public static void merge(int[] arr,int left,int mid,int right)
    {
        int len1=mid-left+1;
        int len2=right-mid;
        int[] leftArr=new int[len1];
        int[] rightArr=new int[len2];
        for(int i=0;i<len1;i++)
        {
            leftArr[i]=arr[left+i];
        }
        for(int i=0;i<len2;i++)
        {
            rightArr[i]=arr[mid+1+i];
        }
        int i=0,j=0,k=left;
        while(i<len1 && j<len2)
        {
            if(leftArr[i]<=rightArr[j])
            {
                arr[k]=leftArr[i];
                i++;
            }
            else
            {
                arr[k]=rightArr[j];
                j++;
            }
            k++;
        }
        while(i<len1)
        {
            arr[k]=leftArr[i];
            i++;
            k++;
        }
        while(j<len2)
        {
            arr[k]=rightArr[j];
            j++;
            k++;
        }
    }
}

//to run this code in terminal
// javac tim_sort.java
// java tim_sort

//Output:
// Before Sorting: [43, 56, 2, 99, 1, 64, 23, 78, 34, 11, 90, 45, 32, 67, 88, 12, 9, 10, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
// 14, 15]
// After Sorting: [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 14, 15, 23, 32, 34, 43, 45, 56, 64, 67, 78, 88, 90, 99]