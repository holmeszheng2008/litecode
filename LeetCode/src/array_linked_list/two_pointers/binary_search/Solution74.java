package array_linked_list.two_pointers.binary_search;

// 74. Search a 2D Matrix
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;

        int left = 0, right = size - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int[] position = convert(middle, n);
            int value = matrix[position[0]][position[1]];
            if(value == target){
                return true;
            } else if (value < target){
                left = middle + 1;
            } else if (value > target){
                right = middle - 1;
            }
        }

        return false;
    }

    private int[] convert(int index, int n){
        int x = index / n;
        int y = index % n;

        return new int[]{x, y};
    }
}
