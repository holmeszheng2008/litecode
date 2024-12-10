package misc.math;

import java.util.Arrays;

// 179. Largest Number
public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            sNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(sNums, (o2, o1) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;

            return str1.compareTo(str2);
        });

        if(sNums[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sNums.length; i++){
            sb.append(sNums[i]);
        }

        return sb.toString();
    }
}
