/*
Implementation of insertion sort in C++.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
*/

#include<bits/stdc++.h>
using namespace std;


int main(){
	int temp = 0;
	int array[] = {5,9,77,1,2,3};
	for (int i = 1; i < 6; i++) {
        int j = i;
        while (j > 0 && array[j] < array[j - 1]) {
           temp = array[j];
		   array[j] = array[j - 1];
		   array[j - 1] = temp;
            j -= 1;
        }
    }
	for(int i = 0; i < 6; i++){
		cout << array[i] << " ";
	}
	
return 0;
}
