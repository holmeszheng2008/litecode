package misc.math;

import java.util.HashSet;
import java.util.Set;

// 202. Happy Number
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int res = 0;
            while(n != 0){
                int value = n % 10;
                n = n / 10;
                res += value * value;
            }

            n = res;
            if(n == 1){
                return true;
            }
        }

        return false;
    }
}
