import java.util.*;
public class RecursiveSort {
        public static void main(String[] args) {
            int arr[] = {5, 4, 3, 0, -10, 1, 2, 3, -6789, 908, -98765, 10, 10, -987, 1};
            int endIdx = arr.length - 1;
            int counter = 1;
//            sort(arr, endIdx, counter);
            int a = 2;
            int b = 300;
            int m = 10;
            int sum = 1;

            for(int i = 1; i < b + 300; i++) {
                sum += (sum *a) % m;
            }
            System.out.println(sum);
        }


        public static void sort(int arr[], int endIdx, int counter) {
            if(counter == arr.length) return;
            for(int i = 0; i < endIdx; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    }
            }
            System.out.println(Arrays.toString(arr));
            sort(arr, endIdx - 1, counter + 1);
        }

        public static void swap(int i, int j, int arr[]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
