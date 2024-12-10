package array_linked_list.two_pointers.binary_search;

// 240. Search a 2D Matrix II
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int left = 0, right = n-1;
            while(left <= right){
                int middle = left + (right - left) / 2;
                int value = matrix[i][middle];
                if(value < target){
                    left = middle + 1;
                } else if (value > target){
                    right = middle - 1;
                } else if (value == target){
                    return true;
                }
            }
        }

        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){
            int value = matrix[i][j];
            if(value < target){
                i++;
            } else if (value > target){
                j--;
            } else if (value == target){
                return true;
            }
        }

        return false;
    }
}