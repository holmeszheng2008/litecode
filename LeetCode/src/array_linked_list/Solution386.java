package array_linked_list;

import java.util.ArrayList;
import java.util.List;

// 386. Lexicographical Numbers
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                curr /= 10;
                while (curr % 10 == 9) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return list;
    }
}


class Solution386_attempt1 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for(int i = 0; i < n; i++){
            res.add(curr);
            if(curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                curr /= 10;
                while(curr % 10 == 9){
                    curr /= 10;
                }
                curr++;
            }
        }

        return res;
    }
}