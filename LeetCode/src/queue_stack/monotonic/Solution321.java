package queue_stack.monotonic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 321. Create Maximum Number
public class Solution321 {
    private int[] res;
    private int k;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        this.k = k;
        int m = nums1.length, n = nums2.length;
        for(int i = 0; i <= Math.min(m, k); i++){
            if(k - i > n){
                continue;
            }

            int[] array1 = mostCompetitive(nums1, i);
            int[] array2 = mostCompetitive(nums2, k - i);

            int[] tempRes = merge(array1, array2);

            if(res == null){
                res = tempRes;
            } else {
                if(compareWithIndex(res, 0, tempRes, 0) < 0){
                    res = tempRes;
                }
            }
        }

        return res;
    }

    private int[] merge(int[] array1, int[] array2){
        int[] res = new int[k];
        int i = 0, j = 0, w = 0;
        while(i < array1.length || j < array2.length){
            if(i < array1.length && j < array2.length){
                if(array1[i] > array2[j]) {
                    res[w++] = array1[i++];
                } else if (array1[i] < array2[j]) {
                    res[w++] = array2[j++];
                } else {
                    if(compareWithIndex(array1, i, array2, j) > 0){
                        res[w++] = array1[i++];
                    } else {
                        res[w++] = array2[j++];
                    }
                }
            } else if (i < array1.length){
                res[w++] = array1[i++];
            } else {
                res[w++] = array2[j++];
            }
        }

        return res;
    }

    private int compareWithIndex(int[] array1, int index1, int[] array2, int index2){
        int m = array1.length, n = array2.length;
        while(index1 < m && index2 < n){
            if(array1[index1] < array2[index2]){
                return -1;
            }
            if(array1[index1] > array2[index2]){
                return 1;
            }
            index1++;
            index2++;
        }
        if(index1 == array1.length){
            return -1;
        }
        return 1;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        if(k == 0){
            return new int[0];
        }
        int n = nums.length;
        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] res = null;
        for(int i = 0; i < n; i++){
            int value = nums[i];
            while(!deque.isEmpty() && deque.getLast() < value){
                if(deque.size() + n - i == k) {
                    list.addAll(deque);
                    for (; i < n; i++) {
                        list.add(nums[i]);
                    }
                    res = convert(list);
                    return res;
                } else {
                    deque.removeLast();
                }
            }
            deque.add(value);
        }

        res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = deque.removeFirst();
        }

        return res;
    }

    private int[] convert(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
