package array_linked_list;

import java.util.Arrays;

// 363. Max Sum of Rectangle No Larger Than K
public class Solution363 {
    private int k;
    private int res = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        this.k = k;
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum2D = new int[m][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                preSum2D[i][j+1] = preSum2D[i][j] + matrix[i][j];
            }
        }

        for(int i1 = 0; i1 < m; i1++){
            int[] preSum = new int[n+1];
            for(int i2 = i1; i2 < m; i2++){
                for(int j = 1; j < n+1; j++){
                    preSum[j] += preSum2D[i2][j];
                }

                int[] curPreSum = Arrays.copyOf(preSum, preSum.length);
                oneDMaxSum(curPreSum);
            }
        }

        return res;
    }

    private void oneDMaxSum(int[] array){
        mergeSort(array, 0, array.length -1);
    }

    private void mergeSort(int[] array, int left, int right){
        if(left == right){
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);

        merge(array, left, middle, right);
    }

    private void merge(int[] array, int left, int middle, int right){
        doMagic(array, left, middle, right);

        int[] temp = new int[right + 1 - left];
        int i = left, j = middle + 1, k = 0;
        while(i <= middle || j <= right){
            if(i <= middle && j <= right){
                if(array[i] <= array[j]){
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            } else if (i <= middle){
                temp[k++] = array[i++];
            } else if (j <= right){
                temp[k++] = array[j++];
            }
        }

        for(k = 0; k < right + 1 - left; k++){
            array[k+left] = temp[k];
        }
    }

    private void doMagic(int[] array, int left, int middle, int right){
        int j = middle + 1;
        for(int i = left; i <= middle; i++){
            while(j <= right){
                if(array[j] - array[i] > k){
                    break;
                }
                j++;
            }

            if(j == middle + 1){
                continue;
            }

            res = Math.max(res, array[j-1] - array[i]);

            if(j > right){
                return;
            }
        }
    }
}
