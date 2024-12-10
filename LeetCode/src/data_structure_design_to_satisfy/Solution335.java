package data_structure_design_to_satisfy;

import java.util.*;

// 355. Design Twitter
public class Solution335 {
    class Twitter {
        private int time;
        private Map<Integer, Set<Integer>> followMap = new HashMap<>();
        private Map<Integer, LinkedList<int[]>> postMap = new HashMap<>();

        private static class PQItem {
            public int[] value;
            public ListIterator<int[]> iterator;

            public PQItem(int[] value, ListIterator<int[]> iterator) {
                this.value = value;
                this.iterator = iterator;
            }
        }


        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            LinkedList<int[]> postStack = postMap.get(userId);
            if(postStack == null){
                postStack = new LinkedList<>();
                postMap.put(userId, postStack);
            }
            postStack.add(new int[]{time++, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            follow(userId, userId);
            Set<Integer> followSet = followMap.get(userId);
            PriorityQueue<PQItem> pq = new PriorityQueue<>((o2, o1) -> o1.value[0] - o2.value[0]);
            List<Integer> res = new ArrayList<>();
            int i = 0;
            for(int followeeId : followSet){
                LinkedList<int[]> list = postMap.get(followeeId);
                if(list == null){
                    continue;
                }
                ListIterator<int[]> iterator = list.listIterator(list.size());
                if(iterator.hasPrevious()){
                    pq.add(new PQItem(iterator.previous(), iterator));
                }
            }
            while(true){
                if(pq.isEmpty()){
                    return res;
                }
                PQItem item = pq.poll();
                res.add(item.value[1]);
                i++;
                if(i == 10){
                    return res;
                }

                ListIterator<int[]> iterator = item.iterator;
                if(iterator.hasPrevious()){
                    pq.add(new PQItem(iterator.previous(), iterator));
                }
            }
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followSet = followMap.get(followerId);
            if(followSet == null){
                followSet = new HashSet<>();
                followMap.put(followerId, followSet);
            }
            followSet.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followSet = followMap.get(followerId);
            if(followSet == null){
                return;
            }
            followSet.remove(followeeId);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
