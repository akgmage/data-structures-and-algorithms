// In computer science, merge sort (also commonly spelled as mergesort) is an efficient, general-purpose,
// and comparison-based sorting algorithm. Most implementations produce a stable sort,
// which means that the order of equal elements is the same in the input and output.
// Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945.
// A detailed description and analysis of bottom-up merge sort appeared in a report by Goldstine and von Neumann as early as 1948.
// Conceptually, a merge sort works as follows:

// Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
// Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list
// Source(https://en.wikipedia.org/wiki/Merge_sort)

// Approach: Divide by finding the number mid of the position midway between left and right. Do this step the same
// way we found the midpoint in binary search
// Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step.
// That is, recursively sort the subarray Arr[left. . mid] and recursively sort the subarray Arr[mid + 1. . right].
// Combine by merging the two sorted subarrays back into the single sorted subarray Arr[left. . right].

class MergeSort {

     void mergeSort(int ar[], int p,int r){
        if(p<r){
            int mid = (p+(r-1))/2;
            mergeSort(ar,p,mid);
            mergeSort(ar,mid+1,r);
            merge(ar,p,mid,r);
        }
    }

    void merge(int ar[],int p,int mid,int r){

        int n1 = mid-p+1;
        int n2 = r - mid;
        int l1[] = new int[n1];
        int l2[] = new int[n2];
        for(int i=0;i<n1;i++){
            l1[i] = ar[i + p];
        }
        for(int j=0;j<n2;j++){
            l2[j] = ar[mid + 1 + j];
        }
        int i=0, j=0;
        int k=p;
        while(i<n1 && j < n2){
            if(l1[i] <= l2[j]){
                ar[k] = l1[i];
                i++; k++;
            } else {
                ar[k] = l2[j];
                j++; k++;
            }
        }
        while(i<n1){
            ar[k] = l1[i];
            i++; k++;
        }
        while(j < n2){
            ar[k] = l2[j];
            j++; k++;
        }
    }
    public static void main(String args[]) {
        int ar[] = {4, 6, 2, 1, 3, 5};
        MergeSort ms = new MergeSort();
        ms.mergeSort(ar,0,ar.length-1);
        for(int x : ar){
            System.out.print(x + " ");
        }
    }
}
