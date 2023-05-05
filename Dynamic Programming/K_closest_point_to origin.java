/*
 K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 
Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
 */

 /*
  SOLUTION:

  Explanation:
      Solved this question using priority Queue.
      Created a priority queue with an Integer.comapre() function.
      The solution uses a max-heap, implemented as a PriorityQueue, to keep track of the k closest points seen so far. 
      We use the Euclidean distance formula to calculate the distance between each point and the origin, 
      which is given by the square root of the sum of the squares of the coordinates. However, to avoid the expensive square root operation, 
      we square the distance formula and compare the squared distances instead.

      The PriorityQueue is initialized with a lambda function that compares the squared distances of two points, p1 and p2, 
      using the Integer.compare() method. This lambda function sorts the points in descending order of their squared distances so that the 
      largest squared distance is at the top of the queue.

      


  */

  //code:
  class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> q = new PriorityQueue<int[]>((p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]),(p1[0] * p1[0] + p1[1] * p1[1])));  // Created a priority queue (Implementing max-heap) with a comparison function.
                                                  
        for(int i=0; i<points.length; i++){
            q.add(points[i]);                 /*We then iterate through each point in the input array points and add it to the priority queue. 
                                                 If the size of max-heap exceeds k, we remove the point with the largest squared distance from the queue 
                                                 using the poll() method. */
            if(q.size() > k){
                q.poll();
            }

        }
        int[][] arr = new int[k][2];
        while(k>0){
            arr[--k] = q.poll();        /* Creating a 2D array of size K and storing points  in non decreasing order of their distance (from  ,least-most). */
        }
        return arr;         //answer
    
    }
}