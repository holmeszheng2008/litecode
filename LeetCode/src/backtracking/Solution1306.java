package backtracking;

import java.util.HashSet;
import java.util.Set;

// 1306. Jump Game III
public class Solution1306 {
    private Set<Integer> visited = new HashSet<>();

    public boolean canReach(int[] arr, int start) {
        if (visited.contains(start)) {
            return false;
        }
        if (start < 0 || start > arr.length) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        } else {
            visited.add(start);
        }

        return canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]);
    }
}
