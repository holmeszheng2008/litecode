package array_linked_list;

import java.util.LinkedList;

// 402. Remove K Digits
public class Solution402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = num.length();
        int i = 0;
        label:for(; i < n; i++){
            int curNum = num.charAt(i) - '0';
            while(!queue.isEmpty()){
                int last = queue.peekLast();
                if(last <= curNum){
                    break;
                } else {
                    queue.removeLast();
                    if(queue.size() + n - i == n - k){
                        break label;
                    }
                }
            }

            queue.addLast(curNum);
        }

        StringBuilder sb = new StringBuilder();
        for(; i < n; i++){
            int curNum = num.charAt(i) - '0';
            queue.addLast(curNum);
        }

        boolean firstNot0Set = false;
        for(int j = 0; j < n-k; j++){
            int curNum = queue.removeFirst();
            if(curNum == 0){
                if(firstNot0Set){
                    sb.append(curNum);
                }
            } else {
                firstNot0Set = true;
                sb.append(curNum);
            }
        }

        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
