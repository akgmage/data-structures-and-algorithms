class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int j = 0; j < queries.length; j++) {
            int centerX = queries[j][0];
            int centerY = queries[j][1];
            int radius = queries[j][2];
            
            for (int i = 0; i < points.length; i++) {
                int pointX = points[i][0];
                int pointY = points[i][1];
                
                // Check if the point (pointX, pointY) is inside the circle.
                if (isInsideCircle(pointX, pointY, centerX, centerY, radius)) {
                    answer[j]++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean isInsideCircle(int x, int y, int centerX, int centerY, int radius) {
        int distanceSquared = (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY);
        return distanceSquared <= radius * radius;
    }
}
