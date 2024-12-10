package array_linked_list.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 315. Count of Smaller Numbers After Self
public class Solution315 {
    private Pair[] temp;
    private int[] count;

    private class Pair {
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        int val;
        int index;
    }
    public List<Integer> countSmaller(int[] nums) {
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] numsPair = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsPair[i] = new Pair(nums[i], i);
        }
        mergeSort(numsPair, 0, nums.length - 1);

        return IntStream.of(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(Pair[] numsPair, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(numsPair, low, mid);
        mergeSort(numsPair, mid + 1, high);

        merge(numsPair, low, mid, high);
    }

    private void merge(Pair[] numsPair, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = numsPair[i];
        }
        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high) {
                if (temp[end].val >= temp[i].val) {
                    break;
                }
                end++;
            }
            count[temp[i].index] += end - mid - 1;
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                numsPair[k] = temp[j++];
            } else if (j == high + 1) {
                numsPair[k] = temp[i++];
            } else if (temp[i].val <= temp[j].val) {
                numsPair[k] = temp[i++];
            } else {
                numsPair[k] = temp[j++];
            }
        }
    }
}

class Solution315_attempt1 {
    private class Pair {
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
            this.count = 0;
        }
        public int index;
        public int value;
        public int count;
    }

    private Pair[] temp;
    private Pair[] list;

    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];

        temp = new Pair[nums.length];
        list = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            Pair pair = new Pair(i, nums[i]);
            list[i] = pair;
        }

        mergeSort(0, nums.length - 1);

        for(Pair pair : list){
            res[pair.index] = pair.count;
        }

        return Arrays.stream(res).boxed().toList();
    }

    private void mergeSort(int low, int high){
        if (low == high){
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(low, mid);
        mergeSort(mid+1, high);

        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high){
        int checkP = mid+1;
        for(int i = low; i <= mid; i++){
            for(; checkP <= high; checkP++){
                if(list[i].value <= list[checkP].value){
                    break;
                }
            }
            list[i].count += (checkP - mid - 1);
        }
        for(int i = low; i <= high; i++){
            temp[i] = list[i];
        }
        for(int i = low, j = low, k = mid+1; i<= high; i++){
            if (j == mid + 1){
                list[i] = temp[k++];
            } else if ( k == high + 1) {
                list[i] = temp[j++];
            } else {
                if (temp[j].value <= temp[k].value){
                    list[i] = temp[j++];
                } else {
                    list[i] = temp[k++];
                }
            }
        }
    }
}
