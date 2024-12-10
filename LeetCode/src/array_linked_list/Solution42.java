package array_linked_list;

import java.util.PriorityQueue;

// 42. Trapping Rain Water
public class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int tempMax = 0;
        for(int i = 0; i < height.length; i++){
            tempMax = Math.max(tempMax, height[i]);
            leftMax[i] = tempMax;
        }
        tempMax = 0;
        for(int i = height.length - 1; i >= 0; i--){
            tempMax = Math.max(tempMax, height[i]);
            rightMax[i] = tempMax;
        }

        for(int i = 0; i < height.length; i++){
            int leftMaxAtI = leftMax[i];
            int rightMaxAtI = rightMax[i];
            res += Math.min(leftMaxAtI, rightMaxAtI) - height[i];
        }

        return res;
    }
}
class Solution42_tp_op {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax){
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}

class Solution42_attempt {
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for(int i = 0; i < height.length; i++){
            leftMax[i] = Math.max(max, height[i]);
            max = leftMax[i];
        }
        max = Integer.MIN_VALUE;
        for(int i = height.length - 1; i >= 0; i--){
            rightMax[i] = Math.max(max, height[i]);
            max = rightMax[i];
        }

        int res = 0;
        for(int i = 0; i < height.length; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}

class Solution42_attempt2 {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        int res = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax){
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}

class Solution42_pq {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3){
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        boolean[] visited = new boolean[n];

        pq.add(new int[]{0, height[0]});
        visited[0] = true;

        pq.add(new int[]{n-1, height[n-1]});
        visited[n-1] = true;

        int res = 0;
        int[] directs = new int[]{-1, 1};
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int i = pair[0];
            int curHeight = height[i];
            int curBoundary = pair[1];
            if(curBoundary > curHeight){
                res += curBoundary - curHeight;
            }

            for(int direct : directs){
                int nextI = i + direct;
                if(nextI < 0 || nextI >= n || visited[nextI]){
                    continue;
                }
                visited[nextI] = true;
                int nextHeight = height[nextI];
                int nextBoundary = Math.max(nextHeight, curBoundary);
                pq.add(new int[]{nextI, nextBoundary});
            }
        }

        return res;
    }
}