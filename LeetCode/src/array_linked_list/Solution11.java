package array_linked_list;

// 11. Container With Most Water
public class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int edge = Math.min(height[left], height[right]);
            res = Math.max(res, edge * (right - left));
            if(height[left] <= height[right]){
                left++;
                while(left < right){
                    if(height[left] > edge){
                        break;
                    }
                    left++;
                }
            } else {
                right--;
                while(left < right){
                    if(height[right] > edge){
                        break;
                    }
                    right--;
                }
            }
        }

        return res;
    }
}