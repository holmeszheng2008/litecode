package trie;

// 421. Maximum XOR of Two Numbers in an Array
public class Solution421 {
    private static class TrieNode {
        public TrieNode[] children = new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int mask = (1 << i);
                int bit = (num & mask) >>> i;
                if(node.children[bit] == null){
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int res = Integer.MIN_VALUE;

        for(int num : nums){
            int xorSum = 0;
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int mask = (1 << i);
                int bit = (num & mask) >>> i;
                int oppBit = bit ^ 1;
                if(node.children[oppBit] != null){
                    node = node.children[oppBit];
                    xorSum += mask;
                } else {
                    node = node.children[bit];
                }
            }

            res = Math.max(res, xorSum);
        }

        return res;
    }
}

class Solution421_attempt1 {
    private static class TrieNode {
        public TrieNode[] children = new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int mask = (1 << i);
                int bit = (num & mask) >>> i;
                if(node.children[bit] == null){
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int res = Integer.MIN_VALUE;

        for(int num : nums){
            int oppSum = 0;
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int mask = (1 << i);
                int bit = (num & mask) >>> i;
                int oppBit = bit ^ 1;
                if(node.children[oppBit] != null){
                    node = node.children[oppBit];
                    if(oppBit == 1){
                        oppSum += mask;
                    }
                } else {
                    node = node.children[bit];
                    if(bit == 1){
                        oppSum += mask;
                    }
                }
            }

            res = Math.max(res, num ^ oppSum);
        }

        return res;
    }
}


class Solution421_attempt2 {
    private static class TrieNode {
        public Object value;
        public TrieNode[] children = new TrieNode[2];
    }
    private TrieNode root;
    private int path = 0;

    private TrieNode addNum(TrieNode node, int num, int index){
        if(node == null){
            node = new TrieNode();
        }

        if(index == -1){
            node.value = new Object();
            return node;
        }

        int mask = 1 << index;
        int bit = (mask & num) >>> index;

        node.children[bit] = addNum(node.children[bit], num, index-1);
        return node;
    }

    private void searchOpp(TrieNode node, int num, int index){
        if(node.value != null){
            return;
        }
        int mask = 1 << index;
        int bit = (mask & num) >>> index;
        int oppBit = bit ^ 1;
        if(node.children[oppBit] != null){
            if(oppBit == 1){
                path += mask;
            }
            searchOpp(node.children[oppBit], num, index-1);
        } else {
            if(bit == 1){
                path += mask;
            }
            searchOpp(node.children[bit], num, index - 1);
        }
    }

    public int findMaximumXOR(int[] nums) {
        for(int num : nums){
            root = addNum(root, num, 31);
        }

        int res = Integer.MIN_VALUE;

        for(int num : nums){
            path = 0;
            searchOpp(root, num, 31);

            res = Math.max(res, num ^ path);
        }

        return res;
    }

}