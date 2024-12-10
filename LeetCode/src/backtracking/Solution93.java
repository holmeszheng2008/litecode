package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 93. Restore IP Addresses
public class Solution93 {
    private List<String> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private String s;
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12){
            return res;
        }

        this.s = s;
        backtracking(0, 0);

        return res;
    }

    private void backtracking(int dotIndex, int start){
        for(int i = start; i < start+3; i++){
            if(!isValid(start, i)){
                return;
            }
            path.add(i);

            if(dotIndex == 2) {
                if(isValid(i+1, s.length() - 1)){
                    res.add(convertToStr());
                }
            } else {
                backtracking(dotIndex + 1, i + 1);
            }

            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(int start, int end){
        if(start > end || start >= s.length() || end >= s.length()) {
            return false;
        }
        int size = end + 1 - start;
        if(size > 3 || size < 1){
            return false;
        }
        if(start == end && s.charAt(start) == '0'){
            return true;
        }

        if(s.charAt(start) == '0'){
            return false;
        }

        int sum = 0;
        for(int i = start; i <= end; i++){
            sum = sum * 10 + s.charAt(i) - '0';
        }

        if(sum > 255){
            return false;
        }

        return true;
    }

    private String convertToStr(){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, path.get(0)+1)).append('.');
        sb.append(s.substring(path.get(0)+1, path.get(1) + 1)).append('.');
        sb.append(s.substring(path.get(1) + 1, path.get(2) + 1)).append('.');
        sb.append(s.substring(path.get(2) + 1));

        return sb.toString();
    }
}


class Solution93_attempt1 {
    private List<String> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        int n = s.length();
        if (n < 4 || n > 12) {
            return res;
        }

        backtracking(0, 0);
        return res;
    }

    private void backtracking(int index, int start){
        int range = Math.min(s.length(), start + 3);

        for(int i = start; i < range; i++){
            if(!isValid(start, i)){
                continue;
            }

            path.add(start);
            if(index == 2) {
                if (isValid(i + 1, s.length() - 1)) {
                    path.add(i + 1);
                    res.add(convertToIp());
                    path.removeLast();
                }
            } else {
                backtracking(index + 1, i + 1);
            }

            path.removeLast();
        }
    }

    // [start, end]
    private boolean isValid(int start, int end){
        int length = end + 1 - start;
        if(start > end){
            return false;
        }
        if(length > 3){
            return false;
        }
        if(s.charAt(start) == '0'){
            if(length == 1){
                return true;
            }
            return false;
        }

        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum = sum * 10 + s.charAt(i) - '0';
        }

        if(sum > 255){
            return false;
        }

        return true;
    }

    private String convertToIp(){
        StringBuilder sb = new StringBuilder();

        for(int i = path.get(0); i < path.get(1); i++){
            sb.append(s.charAt(i));
        }
        sb.append('.');
        for(int i = path.get(1); i < path.get(2); i++){
            sb.append(s.charAt(i));
        }
        sb.append('.');
        for(int i = path.get(2); i < path.get(3); i++){
            sb.append(s.charAt(i));
        }
        sb.append('.');
        for(int i = path.get(3); i < s.length(); i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}