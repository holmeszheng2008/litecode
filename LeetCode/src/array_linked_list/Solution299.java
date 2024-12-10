package array_linked_list;

// 299. Bulls and Cows
public class Solution299 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] sNoMatch = new int[10];
        int[] gNoMatch = new int[10];
        int match = 0;
        for(int i = 0; i < n; i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b) {
                match++;
            } else {
                sNoMatch[a-'0']++;
                gNoMatch[b-'0']++;
            }
        }
        int noMatch = 0;
        for(int i = 0; i < 10; i++){
            noMatch += Math.min(sNoMatch[i], gNoMatch[i]);
        }

        return match+"A"+noMatch+"B";
    }
}
