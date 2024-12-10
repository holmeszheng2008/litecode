package string;

// 395. Longest Substring with At Least K Repeating Characters
public class Solution395 {
    public int longestSubstring(String s, int k) {
        if(s.length() < k){
            return 0;
        }

        int res = Integer.MIN_VALUE;
        char[] sArray = s.toCharArray();
        for(int i = 0; i < 26; i++){
            res = Math.max(res, slidePerUniqueTarget(sArray, k, i));
        }

        return res;
    }

    private int slidePerUniqueTarget(char[] sArray, int k, int uniqueTarget){
        int res = Integer.MIN_VALUE;
        int[] letterCount = new int[26];
        int uniqueCount = 0;
        int countOfUniqueNoLessThanK = 0;
        int left = 0, right = 0;
        while(right < sArray.length){
            char in = sArray[right++];
            letterCount[in - 'a']++;
            if(letterCount[in - 'a'] == 1){
                uniqueCount++;
            }
            if(letterCount[in - 'a'] == k){
                countOfUniqueNoLessThanK++;
            }

            while(uniqueCount > uniqueTarget){
                char out = sArray[left++];
                letterCount[out - 'a']--;
                if(letterCount[out - 'a'] == 0){
                    uniqueCount--;
                }
                if(letterCount[out - 'a'] == k - 1){
                    countOfUniqueNoLessThanK--;
                }
            }

            if(uniqueCount == uniqueTarget && uniqueCount == countOfUniqueNoLessThanK){
                res = Math.max(res, right - left);
            }
        }

        return res;
    }
}


class Solution395_copy {
    public int longestSubstring(String s, int k) {
        int res = 0;
        // 试探input字符串中是否能找到一个最长的字符串，存在有numUniqueTarget个不同字符
        // 我们这里是从1 - 26一个个去试探
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }

    // sliding window模板
    private int helper(String s, int k, int i) {
        int[] map = new int[256];
        int start = 0;
        int end = 0;
        int res = Integer.MIN_VALUE;
        // 子串内unique的字母个数
        int counter = 0;
        // 出现次数不少于K的字母个数
        int numNoLessThanK = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1]++ == 0) {
                counter++;
            }
            if (map[c1] == k) {
                numNoLessThanK++;
            }
            end++;

            while (counter > i) {
                char c2 = s.charAt(start);
                if (map[c2]-- == k) {
                    numNoLessThanK--;
                }
                if (map[c2] == 0) {
                    counter--;
                }
                start++;
            }

            if (counter == numNoLessThanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}