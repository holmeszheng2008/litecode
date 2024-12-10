package misc.math;

// 1523. Count Odd Numbers in an Interval Range
public class Solution1523 {
    public int countOdds(int low, int high) {
        int diff = high - low;
        int newLow = 0;
        if(diff % 2 == 1){
            newLow = low;
            if(newLow <= high){
                return (high - newLow + 1) / 2;
            } else {
                return 0;
            }
        } else {
            newLow = low + 1;
            int part1 = 0;
            if(newLow <= high){
                part1 = (high - newLow + 1) / 2;
            } else {
                part1 = 0;
            }
            if(low % 2 == 1){
                return part1 + 1;
            } else {
                return part1;
            }
        }
    }
}
