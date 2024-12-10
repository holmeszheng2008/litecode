package array_linked_list;

// 264. Ugly Number II
public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n + 1];
        int p = 1, p1 = 1, p2 = 1, p3 = 1;
        int product1 = 1, product2 = 1, product3 = 1;
        for (int i = 1; i <= n; i++) {
            int min = Math.min(product1, Math.min(product2, product3));
            res[p] = min;
            p++;
            if (min == product1) {
                product1 = 2 * res[p1];
                p1++;
            }
            if (min == product2) {
                product2 = 3 * res[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 5 * res[p3];
                p3++;
            }
        }

        return res[n];
    }
}