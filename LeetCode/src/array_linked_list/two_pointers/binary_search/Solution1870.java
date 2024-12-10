package array_linked_list.two_pointers.binary_search;

// 1870. Minimum Speed to Arrive on Time
public class Solution1870 {
    private double getHours(int[] dists, int speed){
        double res = 0;
        for(int i = 0; i < dists.length; i++){
            int dist = dists[i];
            double spend;
            if(i != dists.length - 1) {
                spend = (dist + speed - 1) / speed;
            } else {
                spend = (1.0 * dist) / speed;
            }
            res += spend;
        }

        return res;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10_000_000;
        while(low <= high){
            int middle = low + (high - low) / 2;
            double spend = getHours(dist, middle);
            if(spend < hour){
                high = middle - 1;
            } else if (spend > hour) {
                low = middle + 1;
            } else if (spend == hour) {
                high = middle - 1;
            }
        }

        if(low > 10_000_000){
            return -1;
        }

        return low;
    }
}
