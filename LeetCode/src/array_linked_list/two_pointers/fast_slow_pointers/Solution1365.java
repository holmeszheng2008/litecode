package array_linked_list.two_pointers.fast_slow_pointers;

import java.util.*;

// 1365. How Many Numbers Are Smaller Than the Current Number
public class Solution1365 {
    private class Pair {
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int index;
        public int value;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Pair[] list = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            list[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(list, (o1, o2) -> {
            return o1.value - o2.value;
        });

        for(int low = 0, fast = 0; fast < nums.length; fast++){
            while(list[low].value != list[fast].value){
                low++;
            }
            res[list[fast].index] = low;
        }

        return res;
    }
}

class Solution1365_2 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            List<Integer> list = map.get(value);
            if (list == null){
                list = new ArrayList<>();
                map.put(value, list);
            }
            list.add(i);
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length;){
            int value = nums[i];
            List<Integer> list = map.get(value);
            for(int index : list){
                res[index] = i;
            }

            i++;
            while(i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return res;
    }
}

class Solution1365_attempt1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[][] data = new int[nums.length][];
        for(int i = 0; i < nums.length; i++){
            data[i] = new int[]{nums[i], i};
        }

        int[] res = new int[nums.length];

        Arrays.sort(data, (o2, o1) -> o1[0] - o2[0]);
        LinkedList<Integer> indices = new LinkedList<>();
        int preValue = data[0][0];
        indices.add(data[0][1]);
        for(int i = 1; i < data.length; i++){
            int value = data[i][0];
            int curIndex = data[i][1];
            if(value != preValue){
                while(!indices.isEmpty()) {
                    int index = indices.removeLast();
                    res[index] = nums.length - i;
                }
                preValue = value;
            }
            indices.add(curIndex);
        }
        while(!indices.isEmpty()) {
            int index = indices.removeLast();
            res[index] = 0;
        }

        return res;
    }
}

class Solution1365_attempt2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();

        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }

        return copy;
    }
}