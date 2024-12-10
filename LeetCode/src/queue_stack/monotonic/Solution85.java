package queue_stack.monotonic;

import java.util.Stack;

// 85. Maximal Rectangle
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    heights[i][j] = matrix[i][j] == '1' ? 1 + heights[i - 1][j] : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int[] previousSmaller = new int[n];
            int[] nextSmaller = new int[n];

            // 0 index, 1 value
            Stack<int[]> stack = new Stack<>();

            for (int j = 0; j < n; j++) {
                int height = heights[i][j];
                while (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    if (height < top[1]) {
                        nextSmaller[top[0]] = j;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(new int[]{j, height});
            }
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                nextSmaller[top[0]] = n;
            }

            for (int j = n - 1; j >= 0; j--) {
                int height = heights[i][j];
                while (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    if (height < top[1]) {
                        previousSmaller[top[0]] = j;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(new int[]{j, height});
            }
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                previousSmaller[top[0]] = -1;
            }


            for (int j = 0; j < n; j++) {
                int height = heights[i][j];
                int left = previousSmaller[j];
                int right = nextSmaller[j];

                res = Math.max(res, (right - left - 1) * height);
            }
        }

        return res;
    }
}
