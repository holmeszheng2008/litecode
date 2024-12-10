package array_linked_list;

// 88. Merge Sorted Array
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(k < temp.length){
            if(i == m){
                temp[k] = nums2[j];
                j++;
            } else if(j == n){
                temp[k] = nums1[i];
                i++;
            } else {
                if(nums1[i] <= nums2[j]){
                    temp[k] = nums1[i];
                    i++;
                } else {
                    temp[k] = nums2[j];
                    j++;
                }
            }
            k++;
        }

        for(i = 0; i < m+n; i++){
            nums1[i] = temp[i];
        }
    }
}
