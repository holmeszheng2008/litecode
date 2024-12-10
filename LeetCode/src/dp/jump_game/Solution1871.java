package dp.jump_game;

// 1871. Jump Game VII
/*public class Solution1871 {
    private String s;
    private int minJump;
    private int maxJump;

    private Boolean[] memo;
    public boolean canReach(String s, int minJump, int maxJump) {
        this.s = s;
        this.minJump = minJump;
        this.maxJump = maxJump;
        this.memo = new Boolean[s.length()];

        if(s.charAt(s.length()-1) == '1') {
            return false;
        }
        return dp(0);
    }

    private boolean dp(int index){
        if(index == s.length() - 1){
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        boolean res = false;
        for(int i = minJump; i <= maxJump; i++){
            int nextIndex = index + i;
            if(nextIndex >= s.length()){
                break;
            }
            if(s.charAt(nextIndex) == '1') {
                continue;
            }
            boolean ans = dp(nextIndex);
            res = res | ans;
            if (res){
                break;
            }
        }

        memo[index] = res;
        return res;
    }
}*/

public class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int end = 0, farthest = 0;
        for(int i = 0; i < s.length() - 1;){
            for(int j = i; j <= end; j++){
                if(s.charAt(j) == '1'){
                    continue;
                }
                int tempNear = Math.max(j + minJump, farthest);
                int tempFar = Math.min(j + maxJump, s.length() -1);

                for(int k = tempFar; k >= tempNear; k--){
                    if(s.charAt(k) == '0'){
                        farthest = Math.max(farthest, k);
                        break;
                    }
                }
            }

            if(farthest <= end){
                return false;
            }

            i = Math.max(i+minJump, end + 1);
            end = farthest;
            if(end == s.length() - 1){
                return true;
            }
        }

        return false;
    }
}