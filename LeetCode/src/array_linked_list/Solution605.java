package array_linked_list;

// 605. Can Place Flowers
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int cur = 0;
        for(int i = 0; i < size;){
            if(cur == n){
                return true;
            }
            if(flowerbed[i] == 0) {
                if(i + 1 == size || flowerbed[i+1] == 0) {
                    cur++;
                    i += 2;
                } else {
                    i += 3;
                }
                continue;
            } else {
                i += 2;
            }
        }

        if(cur == n){
            return true;
        }

        return false;
    }
}
