package binary_tree.divide_and_conquer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// 331. Verify Preorder Serialization of a Binary Tree
public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        String[] sArray = preorder.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : sArray) {
            list.add(s);
        }
        
        return check(list) && list.isEmpty();
    }

    public boolean check(LinkedList<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        String s = list.removeFirst();
        if (s.equals("#")) {
            return true;
        }

        return check(list) && check(list);
    }

}


// I like this one better
class Solution331_attempt1 {
    LinkedList<String> preorderList;
    private boolean isValid = true;
    public boolean isValidSerialization(String preorder) {
        String[] preorderArray = preorder.split(",");
        preorderList = Arrays.stream(preorderArray).collect(Collectors.toCollection(LinkedList::new));

        dp();
        if (!preorderList.isEmpty()) {
            isValid = false;
        }

        return isValid;
    }

    private void dp() {
        if (!isValid){
            return;
        }
        if (preorderList.isEmpty()){
            isValid = false;
            return;
        }
        String value = preorderList.removeFirst();
        if (value.equals("#")){
            return;
        } else {
            dp();
            dp();
        }

    }
}