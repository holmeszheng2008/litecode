package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2279. Maximum Bags With Full Capacity of Rocks
public class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> leftBags = new ArrayList<>();
        for(int i = 0; i < capacity.length; i++){
            if(capacity[i] != rocks[i]){
                leftBags.add(capacity[i] - rocks[i]);
            }
        }
        Collections.sort(leftBags);
        int fullBagNum = capacity.length - leftBags.size();
        for(int leftBag : leftBags){
            if(additionalRocks <= 0){
                break;
            }
            if(leftBag <= additionalRocks){
                additionalRocks -= leftBag;
                fullBagNum++;
            } else {
                break;
            }
        }

        return fullBagNum;
    }
}
