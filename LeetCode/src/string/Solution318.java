package string;

// 318. Maximum Product of Word Lengths
public class Solution318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[][] memo = new int[n][];
        for(int i = 0; i < n; i++){
            String word = words[i];
            int bitsMark = 0;
            for(int j = 0; j < word.length(); j++){
                bitsMark |= 1 << (word.charAt(j) - 'a');
            }
            memo[i] = new int[] {bitsMark, word.length()};
        }

        int maxProd = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int[] memoI = memo[i];
                int[] memoJ = memo[j];
                if((memoI[0] & memoJ[0]) == 0){
                    maxProd = Math.max(maxProd, memoI[1] * memoJ[1]);
                }
            }
        }

        return maxProd;
    }
}
