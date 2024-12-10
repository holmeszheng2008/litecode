package data_structure_design_to_satisfy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// 146. LRU Cache
public class Solution146 {
    static class LRUCache {
        private static class ListNode {
            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public ListNode() {
                this.key = 0;
                this.value = 0;
            }

            public ListNode pre;
            public ListNode next;
            public int key;
            public int value;
        }

        private int capacity = 0;
        Map<Integer, ListNode> cache = new HashMap<>();
        private ListNode head = new ListNode();
        private ListNode tail = new ListNode();


        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                makeRecent(key, cache.get(key).value);
                return cache.get(key).value;
            }
            return -1;
        }

        private void makeRecent(int key, int value) {
            ListNode node = cache.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                makeRecent(key, value);
                return;
            }
            if (cache.size() == capacity) {
                ListNode oldNode = tail.pre;
                oldNode.pre.next = tail;
                tail.pre = oldNode.pre;
                cache.remove(oldNode.key);

                ListNode node = new ListNode(key, value);
                cache.put(key, node);
                head.next.pre = node;
                node.next = head.next;
                node.pre = head;
                head.next = node;
            } else {
                ListNode node = new ListNode(key, value);
                cache.put(key, node);
                head.next.pre = node;
                node.next = head.next;
                node.pre = head;
                head.next = node;
            }
        }
    }
}


class Solution146_attempt1 {
    class LRUCache {
        private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        private int capacity;
        private int currentCapacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                put(key, value);

                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key, value);
            } else {
                if (currentCapacity < capacity) {
                    currentCapacity++;
                    cache.put(key, value);
                } else {
                    Iterator<Integer> iterator = cache.keySet().iterator();
                    cache.remove(iterator.next());
                    cache.put(key, value);
                }
            }
        }
    }
}

class Solution146_attempt2 {
    class LRUCache {
        private int capacity;
        private int currentCapacity = 0;

        private LinkedHashMap<Integer, Integer> data = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(data.containsKey(key)){
                int value = data.get(key);
                data.remove(key);
                data.put(key, value);

                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(data.containsKey(key)) {
                data.remove(key);
                data.put(key, value);
            } else {
                if(currentCapacity == capacity){
                    Iterator<Integer> iterator = data.keySet().iterator();
                    int oldestKey = iterator.next();
                    data.remove(oldestKey);

                    currentCapacity--;
                }

                currentCapacity++;
                data.put(key, value);
            }
        }
    }
}