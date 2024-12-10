package backtracking;


// 2369. Check if There is a Valid Partition For The Array
public class Solution2369 {
    private Boolean[] memo;
    private int[] nums;
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.memo = new Boolean[n];

        return dp(n-1);
    }

    private boolean dp(int i){
        if(i == -1){
            return true;
        }
        if(memo[i] != null){
            return memo[i];
        }
        boolean res = false;
        int pre2 = Integer.MIN_VALUE;
        int pre = Integer.MIN_VALUE;
        int curNum = nums[i];
        if(i-1 >= 0){
            pre = nums[i-1];
            if(pre == curNum){
                res = res || dp(i-2);
            }
        }
        if(i-2 >= 0){
            pre2 = nums[i-2];
            if(pre == curNum && pre2 == curNum){
                res = res || dp(i-3);
            }
            if(pre == pre2 + 1 && curNum == pre + 1){
                res = res || dp(i-3);
            }
        }


        memo[i] = res;
        return res;
    }
}
class Solution2369_backtracking1 {
    private boolean res;
    private int[] nums;
    public boolean validPartition(int[] nums) {
        this.nums = nums;
        backtracking(0, 0, -1, 0);

        return res;
    }

    private void backtracking(int index, int length, int diff, int preNum){
        if(length == 0) {
            int curNum = nums[index];
            if (index == nums.length - 1) {

            } else {
                backtracking(index + 1, length + 1, -1, curNum);
                if(res){
                    return;
                }
            }
        } else if(length == 1) {
            int curNum = nums[index];
            if (!(curNum == preNum || curNum == preNum + 1)) {
                return;
            }
            if (curNum == preNum) {
                if (index == nums.length - 1) {
                    res = true;
                    return;
                } else {
                    backtracking(index + 1, length + 1, 0, curNum);
                    if(res){
                        return;
                    }
                }
            }
            if (curNum == preNum + 1) {
                if (index == nums.length - 1) {
                    return;
                } else {
                    backtracking(index + 1, length + 1, 1, curNum);
                    if(res){
                        return;
                    }
                }
            }
        } else if (length == 2){
            int curNum = nums[index];
            if(diff == 0) {
                // as new
                if(index == nums.length - 1){

                } else {
                    backtracking(index+1, 1, -1, curNum);
                    if(res){
                        return;
                    }
                }

                // as third equal num
                if (curNum == preNum) {
                    if (index == nums.length - 1) {
                        res = true;
                        return;
                    } else {
                        backtracking(index + 1, length + 1, 0, curNum);
                        if (res) {
                            return;
                        }
                    }
                }

            } else if (diff == 1) {
                if(curNum - preNum != diff){
                    return;
                }
                if(index == nums.length - 1){
                    res = true;
                    return;
                } else {
                    backtracking(index+1, length +1, 1, curNum);
                    if(res){
                        return;
                    }
                }
            }
        } else if (length == 3){
            int curNum = nums[index];
            if(index == nums.length - 1){

            } else {
                backtracking(index+1, 1, -1, curNum);
                if(res){
                    return;
                }
            }
        }
    }
}

class Solution_backtracking2 {
    private boolean res;
    private int[] nums;
    public boolean validPartition(int[] nums) {
        this.nums = nums;

        backtracking(0);
        return res;
    }


    private void backtracking(int index){
        int curNum = nums[index];
        int next = Integer.MIN_VALUE;
        int next2 = Integer.MIN_VALUE;
        if(index + 1 < nums.length){
            next = nums[index+1];
            if(curNum == next){
                if(index + 1 == nums.length - 1) {
                    res = true;
                    return;
                } else {
                    backtracking(index + 2);
                    if(res){
                        return;
                    }
                }
            }
        }
        if(index + 2 < nums.length){
            next2 = nums[index+2];
            if((curNum == next && curNum == next2) || (curNum + 1 == next && next + 1 == next2)){
                if(index + 2 == nums.length - 1) {
                    res = true;
                    return;
                } else {
                    backtracking(index + 3);
                    if(res){
                        return;
                    }
                }
            }
        }
    }
}