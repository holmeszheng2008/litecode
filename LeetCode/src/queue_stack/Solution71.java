package queue_stack;

import java.util.Deque;
import java.util.LinkedList;

// 71. Simplify Path
public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList<>();
        for(int i = 0; i < path.length(); ){
            if(path.charAt(i) == '/'){
                if(dq.isEmpty() || !dq.peekLast().equals("/")) {
                    dq.offerLast("/");
                }
                i++;
                while(i < path.length() && path.charAt(i) == '/'){
                    i++;
                }
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(i < path.length() && path.charAt(i) != '/'){
                sb.append(path.charAt(i));
                i++;
            }

            String str = sb.toString();
            if(str.equals("..")) {
                for(int j = 0; j < 3 && dq.size() != 1; j++){
                    dq.pollLast();
                }
            } else if (str.equals(".")) {
                if(dq.size() != 1){
                    dq.pollLast();
                }
            } else {
                dq.offerLast(str);
            }

        }

        while(dq.size() > 1 && dq.peekLast().equals("/")){
            dq.pollLast();
        }

        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()) {
            res.append(dq.pollFirst());
        }

        return res.toString();
    }
}
