package backtracking;

import java.util.ArrayList;

public class Solution60 {
    private boolean[] used;
    private ArrayList<Character> path = new ArrayList<>();
    private int k;
    private int count = 0;
    private int n;
    public String getPermutation(int n, int k) {
        this.used = new boolean[n+1];
        this.k = k;
        this. n = n;

        backtracking();

        StringBuilder sb = new StringBuilder();
        for(char c : path){
            sb.append(c);
        }

        return sb.toString();
    }

    private void backtracking(){
        for(int i = 1; i <= n; i++){
            if(used[i]){
                continue;
            }

            used[i] = true;
            path.add((char)(i+'0'));

            if(path.size() == n){
                count++;
                if(count == k){
                    return;
                }
            } else {
                backtracking();
                if(count == k){
                    return;
                }
            }

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}


class Solution60_attempt1 {
    private StringBuilder path = new StringBuilder();
    private boolean[] used;
    private int n;
    private int k;
    private int currentK;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        this.used = new boolean[n+1];

        backtracking();
        return path.toString();
    }

    private void backtracking(){
        for(int i = 1; i <= n; i++){
            if(used[i]){
                continue;
            }
            path.append(i);
            used[i] = true;

            if(path.length() == n){
                currentK++;
                if(currentK == k){
                    return;
                }
            } else {
                backtracking();
                if(currentK == k){
                    return;
                }
            }

            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}