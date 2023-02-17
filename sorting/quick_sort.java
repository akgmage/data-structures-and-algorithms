/*
Quick sort:
Quicksort picks an element as pivot, and then it partitions the given array around the picked pivot element.
In quick sort, a large array is divided into two arrays in which one holds values that are smaller than the
specified value (Pivot), and another array holds the values that are greater than the pivot.

After that, left and right sub-arrays are also partitioned using the same approach.
It will continue until the single element remains in the sub-array.

For more information:
--> https://www.geeksforgeeks.org/java-program-for-quicksort/
--> https://www.javatpoint.com/quick-sort
 */

package sorting;

public class quick_sort {
    public static void main(String[] args) {
        int[] a = {15,4,3,7,13,2,6,7,3,2,1,5,6,3,2};
        int n = a.length;

        sort(a, 0, n-1);

        System.out.println("sorted array");
        for (int j : a) System.out.print(j + " ");
        System.out.println();
    }

    /**
     *
     * @param a to be sorted
     * @param start starting index
     * @param end ending index
     */
    private static void sort(int[] a, int start, int end){
        if (start < end) {
            int p = partition(a, start, end);
            sort(a, start, p-1);
            sort(a, p+1, end);
        }
    }

    /**
     * smaller elements to the left of the pivot, greater elements to the right
     * @param a to be sorted
     * @param start starting index
     * @param end ending index
     * @return index
     */
    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = (start-1); // index of smaller element
        for (int j=start; j<end; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[end];
        a[end] = temp;

        return i+1;
    }

}

