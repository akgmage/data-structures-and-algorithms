import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        ArrayList<Double>[] buckets = new ArrayList[n];

        // Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements to corresponding buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {0.8, 0.3, 0.2, 0.9, 0.1, 0.6, 0.4, 0.7, 0.5, 0.0};
        bucketSort(arr);
        System.out.println("Sorted array:");
        for (double d : arr) {
            System.out.print(d + " ");
        }
    }
}
