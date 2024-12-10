package backtracking;

import java.util.LinkedList;
import java.util.List;

// 89. Gray Code
public class Solution89 {
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] memo;
    private int n;
    private int range;
    private boolean resGot;

    public List<Integer> grayCode(int n) {
        this.n = n;
        this.range = 1 << n;

        path.add(0);
        this.memo = new boolean[range];
        memo[0] = true;

        backtracking(0, 1);

        return path;
    }

    private void backtracking(int preNum, int index) {

        for(int i = 0; i < n; i++){
            int num = preNum ^ (1 << i);
            if(memo[num]){
                continue;
            }
            memo[num] = true;
            path.add(num);
            if(index == range - 1){
                if((num & (num - 1)) == 0){
                    resGot = true;
                    return;
                }
            } else {
                backtracking(num, index+1);
                if(resGot){
                    return;
                }
            }

            memo[num] = false;
            path.removeLast();
        }

    }
}
