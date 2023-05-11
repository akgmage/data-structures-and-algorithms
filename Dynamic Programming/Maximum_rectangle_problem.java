import java.util.Stack;

public class Maximum_rectangle_problem {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                m[i][j] = i > 0 ? m[i - 1][j] + 1 : 1;
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < m.length; i++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j <= m[0].length; j++) {
                int h = j == m[0].length ? 0 : m[i][j];
                if (s.isEmpty() || h >= m[i][s.peek()]) {
                    s.push(j);
                } else {
                    int tp = s.pop();
                    maxArea = Math.max(maxArea, m[i][tp] * (s.isEmpty() ? j : j - 1 - s.peek()));
                    j--;
                }
            }
        }
        return maxArea;
    }
    
}
