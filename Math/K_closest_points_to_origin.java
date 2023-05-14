/**
   Time Complexity: O(nlog(n)), Space Complexity: O(n)

   Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
   The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
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

**/


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        

	  /**
            The solution is very simple, for each point(x, y) we calculate the euclidean distance between 
            (x, y) and the origin point (0, 0), then add all the distances in Priority Queue (Minimum Heap).
            The priority queue will sort them in increasing order. 


            NOTE that we need to return the points not the distances, that's why we make Priority Queue of Pair<Double, Pair<Integer, Integer>>. 
        **/

        PriorityQueue<Pair<Double, Pair<Integer, Integer>>> pq =
            new PriorityQueue<>(new SortBySmallerDistanceComparator());
        
        for (int i = 0; i < points.length; ++i)
        {
            int x = points[i][0], y = points[i][1];
            double distance = Math.sqrt(x * x + y * y);
            pq.add(new Pair(distance, new Pair(x, y)));
        }
        
        int [][]closestK = new int[k][2];
        
        for(int i = 0; i < k; ++i)
        {
            closestK[i][0] = pq.peek().getValue().getKey();
            closestK[i][1] = pq.peek().getValue().getValue();
            pq.poll();

        }
        
        return closestK;
    
    }


    /*
      Compartor to sort the points based on the distance (smaller).
    */
    
    class SortBySmallerDistanceComparator implements Comparator<Pair<Double, Pair<Integer, Integer>>>
    {
        @Override
        public int compare(Pair<Double, Pair<Integer, Integer>> a, 
                           Pair<Double, Pair<Integer, Integer>> b) {
                   return (a.getKey() - b.getKey()) <= 0 ? -1 : 1;
       }
    }
    
}
