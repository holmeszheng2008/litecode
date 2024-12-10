package array_linked_list.two_pointers.binary_search;

// 852. Peak Index in a Mountain Array
public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(arr[middle] > arr[middle+1]){
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
