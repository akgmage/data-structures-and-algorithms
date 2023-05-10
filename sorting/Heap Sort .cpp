/*
Heap sort is a sorting technique based on comparison based on binary heap data.
Similar to sorting, it finds the largest number first and then puts the largest number last.


This sorting algorithm uses a tree structure called the stack, where the stack is a kind of binary tree. 
A binary decision tree in which the value of the root of a tree is less than or equal to the value of one of its roots is called a min-heap. 
A decision binary tree is called maximum heap when the value of the root of a tree is greater than or equal to the value of one of its trees. 
In this post, we'll learn more about C++ Stack Sorting.

Working of heap sort in C++
To sort any list into a logical order following steps are followed:-

Convert the list into a heap.
Now convert this heap into a max heap.
As the heap is converted to max heap largest element in the list is stored in the root of the heap, replace it with the last item of the heap.
Now delete this node and reduce the size of the heap by 1.
Follow these steps until the list is sorted.  
*/

#include<iostream>
using namespace std;
void heapify(int arr[], int n, int i){
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;
 
    //If left child is larger than root
    if (l < n && arr[l] > arr[largest])
        largest = l;
    //If right child largest 
    if (r < n && arr[r] > arr[largest])
        largest = r;
  //If root is nor largest
    if (largest != i){
        swap(arr[i], arr[largest]);
      //Recursively heapifying the sub-tree
        heapify(arr, n, largest);
    }
}

void heapSort(int arr[], int n){
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
  //One by one extract an element from heap
    for (int i=n-1; i>=0; i--){
        //Moving current root to end
        swap(arr[0], arr[i]);
      //Calling max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}
 //Function to print array
void display(int arr[], int n){
    for (int i = 0; i < n; i++){
        cout << arr[i] << "\t";
    }
    cout << "\n";
}
int main(){
    int arr[] = {1, 14, 3, 7, 0};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "Unsorted array  \n";
    display(arr, n);
    heapSort(arr, n);
 cout << "Sorted array  \n";
    display(arr, n);
}

/*Time Complexcity
Best
O(nlog n)

Average
O(nlog n)

Worst
O(nlog n)
*/
