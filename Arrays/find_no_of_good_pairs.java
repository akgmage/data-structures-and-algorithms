import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100 

*/
public class FindNoOfGoodPairs{

    /*
     Brute Force solution:
    time complexity  : O(n^2)
    space complexity : O(1)
    */
    public static int countNoOfGoodPairsBF(List<Integer> array){
        int len = array.size();
        int goodPairs=0;

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                if(array.get(i) == array.get(j)){
                    goodPairs++;
                }
            }
        }

        return goodPairs;
    }

    /*
     Time Optimized solution:
        time complexity  : O(n)  [ O(n+n) ~= O(n)]
        space complexity : O(n)
     */   
    /*
        Approach:
            Scan the array once and have the count of occurence of each number in a map.
            Then iterate the map and find the no of possible good pairs using the occurence value.
            By observation we can find the correlation b/w  freq and no of pairs as below: 
            
            example:
            
            i/p
            o/p

            1
            0

            1 1
            1
            
            1 1 1
            2

            1 1 1 1 (4)
            6     (3*4/2)

            1 1 1 1 1 (5)
            10    (4*5/2)

            hence,
            1 1 1 1 1 (n)
            (n-1)*n /2

    */
    public static int countNoOfGoodPairsTimeOptimized(List<Integer> array){
        int len = array.size();
        int goodPairs = 0;

        HashMap<Integer, Integer> occurence = new HashMap<>();

        // construct the occurence map
        for(int i=0; i<len; i++){
            int num = array.get(i);
            occurence.put(num, occurence.getOrDefault(num, 0) + 1);
        }

        // Now calculate the no of good pairs

        for(int number: occurence.keySet()){

            int freq = occurence.get(number);

            if(freq > 1){
                goodPairs += ( (freq-1)*(freq) / 2 );
            }
        }

        return goodPairs;
    }
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();

        List<Integer> array = new ArrayList<>();

        for(int i=0; i<arrLen; i++){
            int num = sc.nextInt();
            array.add(num);
        }

        // System.out.println(countNoOfGoodPairsBF(array));
        System.out.println(countNoOfGoodPairsTimeOptimized(array));

    }   
}