package data_structure_design_to_satisfy;

import java.util.ArrayList;
import java.util.List;

// 388. Longest Absolute File Path
public class Solution388 {
    private static class TreeNode {
        public int length;
        public boolean isFile;
        public TreeNode parent;
        public List<TreeNode> children = new ArrayList<>();

        public TreeNode(int length) {
            this.length = length;
        }
    }

    private int res;
    private int pathLength;

    public int lengthLongestPath(String input) {
        char[] inputArray = input.toCharArray();

        TreeNode root = new TreeNode(0);

        constructTree(inputArray, 0, root, -1);
        backtracking(root);

        return res;
    }

    private void constructTree(char[] inputArray, int index, TreeNode node, int preTabs){
        if(index >= inputArray.length){
            return;
        }

        int curTabs = 0;
        boolean isFile = false;
        int curLength = 0;
        char c = 0;
        while((c = inputArray[index]) == '\t'){
            curTabs++;
            index++;
        }
        while(index != inputArray.length && (c = inputArray[index]) != '\n'){
            if(c == '.'){
                isFile = true;
            }
            curLength++;
            index++;
        }

        TreeNode nextNode = null;
        nextNode = new TreeNode(curLength);
        nextNode.isFile = isFile;
        if(curTabs > preTabs) {
            node.children.add(nextNode);
            nextNode.parent = node;
        } else {
            int diff = preTabs + 1 - curTabs;
            TreeNode preNode = node;
            for(int i = 0; i < diff; i++){
                preNode = preNode.parent;
            }
            preNode.children.add(nextNode);
            nextNode.parent = preNode;
        }

        constructTree(inputArray, index+1, nextNode, curTabs);
    }

    private void backtracking(TreeNode node) {
        for(TreeNode nextNode : node.children){
            if(nextNode.isFile){
                pathLength += nextNode.length;
            } else {
                pathLength = pathLength + nextNode.length + 1;
            }

            if(nextNode.isFile) {
                res = Math.max(res, pathLength);
            } else {
                backtracking(nextNode);
            }

            if(nextNode.isFile){
                pathLength -= nextNode.length;
            } else {
                pathLength = pathLength - nextNode.length - 1;
            }
        }
    }
}

class Solution388_attempt1 {
    public int lengthLongestPath(String input) {
        int res = 0;
        String[] segments = input.split("\n");
        int[] array = new int[segments.length];
        for(String segment : segments){
            int numOfTabs = segment.lastIndexOf('\t') + 1;
            int length = segment.length() - numOfTabs + 1;
            if(numOfTabs == 0){
                array[0] = length;
            } else {
                array[numOfTabs] = length + array[numOfTabs - 1];
            }

            if(segment.contains(".")){
                res = Math.max(res, array[numOfTabs] - 1);
            }
        }

        return res;
    }
}
