package array_linked_list;

import java.util.List;

// 385. Mini Parser
public class Solution385 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){

        }
        // Constructor initializes a single integer.
        public NestedInteger(int value){

        }
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return true;
        }
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return 1;
        }
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){

        }
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){

        }
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return null;
        }
    }

    class Solution {
        public NestedInteger deserialize(String s) {
            char[] sArray = s.toCharArray();

            Object[] res = deserialize(sArray, 0);
            return (NestedInteger) res[0];
        }


        // 0 -> NestedInteger
        // 1 -> endIndex + 1
        private Object[] deserialize(char[] sArray, int start){
            NestedInteger nestedInteger = null;
            while(start < sArray.length && sArray[start] == ','){
                start++;
            }
            if(start == sArray.length){
                return new Object[]{nestedInteger, start};
            }
            char c = sArray[start];
            if(c == '['){
                return getListNestedInteger(sArray, start);
            } else {
                return getInteger(sArray, start);
            }
        }

        // 0 -> nestedInteger of list type
        // 1 -> endIndex + 1
        private Object[] getListNestedInteger(char[] sArray, int start){
            NestedInteger nestedInteger = new NestedInteger();
            start++;
            while(sArray[start] != ']'){
                Object[] nextRes = deserialize(sArray, start);
                nestedInteger.add((NestedInteger) nextRes[0]);
                start = (Integer)nextRes[1];
            }

            return new Object[]{nestedInteger, start+1};
        }

        // 0 -> int value nestedInteger
        // 1 -> endIndex + 1
        private Object[] getInteger(char[] sArray, int start){
            int sign = 1;
            if(sArray[start] == '-'){
                sign = -1;
                start++;
            }

            int value = 0;
            char c = ' ';
            while(start < sArray.length && Character.isDigit(c = sArray[start])){
                value = value * 10 + (c - '0');
                start++;
            }

            return new Object[]{new NestedInteger(sign * value), start};
        }
    }
}
