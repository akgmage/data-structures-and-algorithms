// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

// Time Complexity worst-case and average complexity O(n^{2})
// Bubble sort is O(n) on a list that is already sorted i.e. Best case

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]



package sorting;

public class Bubblesort {
    void bubblesort(int[] array) {
       int size = array.length;
       int temp = 0;
       boolean flag = false;

        for(int i = 0; i < size; i++) {
            for(int j = 1; j < (size - i); j++) {
                if(array[j - 1] > array[j]) {
                    //swap elements
                    temp = array[j-1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }

            }
            if(!flag) {
                System.out.println("Already sorted so no further redundant passes best case 0(n)");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 3, 4, 5};

        System.out.println("Array Before Bubble Sort");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        Bubblesort is = new Bubblesort();
        is.bubblesort(array);//sorting array elements using bubble sort

        System.out.println("Array After Bubble Sort");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

}
