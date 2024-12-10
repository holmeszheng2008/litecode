package array_linked_list;

// 274. H-Index
public class Solution274 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int diff = citations.length - middle;
            if(citations[middle] < diff){
                left = middle + 1;
            } else if (citations[middle] > diff){
                right = middle - 1;
            } else {
                right = middle - 1;
            }
        }

        return citations.length - left;
    }
}
