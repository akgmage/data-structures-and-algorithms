package Searching;
import java.util.*;
public class PrefixBinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(4);
        A.add(6);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(20);
        B.add(4);
        B.add(10);
        B.add(2);
        System.out.println("RESULT: " + solve(A, B));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> phones = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int num = 0;
        for (int idx = 0; idx < A.size(); idx++) {
            num += A.get(idx);
            phones.add(num);
        }
        for (int idx = 0; idx < B.size(); idx++) {
            int val = B.get(idx);
            int value = search(phones, val, 0, phones.size() - 1);
            result.add(value + 1);
        }
        return result;
    }
    public static int search(ArrayList<Integer> phones, int target, int left, int right) {
        while(left <= right) {
            int midIdx = left + (right - left) / 2;
            int mid = phones.get(midIdx);
            if(mid == target) return midIdx;
            else if(mid < target) left = midIdx + 1;
            else right = midIdx - 1;
        }
        return Math.min(left, right);
    }
}















