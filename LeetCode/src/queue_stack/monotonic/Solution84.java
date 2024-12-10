package queue_stack.monotonic;

import java.util.Stack;

// 84. Largest Rectangle in Histogram
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        // 0 is index, 1 is value
        Stack<int[]> stack = new Stack<>();
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        int maxSize = 0;

        for(int i = 0; i < heights.length; i++){
            int value = heights[i];
            while(!stack.isEmpty()) {
                int[] topPair = stack.peek();
                if(value < topPair[1]){
                    stack.pop();
                    rightSmaller[topPair[0]] = i;
                } else {
                    break;
                }
            }

            stack.push(new int[]{i, value});
        }

        while(!stack.isEmpty()) {
            int[] topPair = stack.pop();
            rightSmaller[topPair[0]] = heights.length;
        }

        for(int i = heights.length - 1; i >= 0; i--){
            int value = heights[i];
            while(!stack.isEmpty()){
                int[] topPair = stack.peek();
                if(value < topPair[1]){
                    stack.pop();
                    leftSmaller[topPair[0]] = i;
                } else {
                    break;
                }
            }
            stack.push(new int[]{i, value});
        }

        while(!stack.isEmpty()){
            int[] topPair = stack.pop();
            leftSmaller[topPair[0]] = -1;
        }

        for(int i = 0; i < heights.length; i++){
            int length = heights[i];
            int leftBound = leftSmaller[i];
            int rightBound = rightSmaller[i];
            int width = rightBound - leftBound - 1;

            maxSize = Math.max(maxSize, length * width);
        }

        return maxSize;
    }
}

class Solution84_attempt1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 0 index, 1 value
        Stack<int[]> stack = new Stack<>();
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];

        for(int i = n-1; i >=0; i--){
            int height = heights[i];
            while(!stack.isEmpty()) {
                int[] top = stack.peek();
                if(height < top[1]){
                    previousSmaller[top[0]] = i;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[]{i, height});
        }
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            previousSmaller[top[0]] = -1;
        }

        for(int i = 0; i < n; i++){
            int height = heights[i];
            while(!stack.isEmpty()){
                int[] top = stack.peek();
                if(height < top[1]){
                    nextSmaller[top[0]] = i;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[]{i, height});
        }
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            nextSmaller[top[0]] = n;
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int left = previousSmaller[i];
            int right = nextSmaller[i];

            res = Math.max(res, (right - left - 1) * height);
        }

        return res;
    }
}