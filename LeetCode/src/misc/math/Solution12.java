package misc.math;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// 12. Integer to Roman
public class Solution12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");



        StringBuilder sb = new StringBuilder();
        Set<Integer> numSet = map.keySet();

        for(int operand : numSet){
            if(num == 0){
                break;
            }
            int n = num / operand;
            num = num - n * operand;
            String token = map.get(operand);
            for(int i = 0; i < n; i++){
                sb.append(token);
            }
        }

        return sb.toString();
    }
}
