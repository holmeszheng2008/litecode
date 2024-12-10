package array_linked_list.two_pointers.binary_search;

import java.util.Arrays;

// 4. Median of Two Sorted Arrays
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeft = (m+n-1) / 2;
        int aLeft = 0, aRight = nums1.length;
        int aMid, bMid;
        while(aLeft <= aRight){
            aMid = aLeft + (aRight - aLeft) / 2;
            int l1 = (aMid == 0) ? Integer.MIN_VALUE : nums1[aMid-1];
            int r1 = (aMid == m) ? Integer.MAX_VALUE : nums1[aMid];
            bMid = totalLeft - aMid;
            int l2 = (bMid == 0)? Integer.MIN_VALUE : nums2[bMid - 1];
            int r2 = (bMid == n) ? Integer.MAX_VALUE : nums2[bMid];

            if(l1 > r2) {
                aRight = aMid -1;
            } else if (l2 > r1){
                aLeft = aMid + 1;
            } else {
                if((m+n) % 2 == 1){
                    return Math.min(r1, r2);
                } else {
                    int tempR11 = (aMid >= m) ? Integer.MAX_VALUE : nums1[aMid];
                    int tempR12 = (aMid + 1 >= m)? Integer.MAX_VALUE : nums1[aMid + 1];
                    int tempR21 = (bMid >= n)? Integer.MAX_VALUE : nums2[bMid];
                    int tempR22 = (bMid + 1 >= n)? Integer.MAX_VALUE : nums2[bMid + 1];
                    int[] list = new int[]{tempR11, tempR12, tempR21, tempR22};
                    Arrays.sort(list);

                    return (1.0 * list[0] + list[1]) / 2;
                }
            }
        }

        return -1;
    }
}

class Solution4_attempt1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeft = (m+n-1) / 2;

        int left = 0, right = nums1.length;
        while(left <= right){
            int middle1 = left + (right - left) / 2;
            int l1 = (middle1 == 0) ? Integer.MIN_VALUE : nums1[middle1-1];
            int r1 = (middle1 == m) ? Integer.MAX_VALUE : nums1[middle1];

            int middle2 = totalLeft - middle1;
            int l2 = (middle2 == 0) ? Integer.MIN_VALUE : nums2[middle2 - 1];
            int r2 = (middle2 == n) ? Integer.MAX_VALUE : nums2[middle2];

            if(l1 <= r2 && l2 <= r1) {
                if((m + n) % 2 == 1){
                    return Math.min(r1, r2);
                } else {
                    int r12 = (middle1 + 1 >= m) ? Integer.MAX_VALUE : nums1[middle1+1];
                    int r22 = (middle2 + 1 >= n) ? Integer.MAX_VALUE : nums2[middle2+1];
                    int[] first4 = new int[]{r1, r12, r2, r22};
                    Arrays.sort(first4);

                    return (1.0 * first4[0] + first4[1]) / 2;
                }
            } else if (l1 > r2) {
                right = middle1 - 1;
            } else if (l2 > r1) {
                left = middle1 + 1;
            }
        }

        return -1;
    }
}
