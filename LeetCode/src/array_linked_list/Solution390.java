package array_linked_list;

// 390. Elimination Game
public class Solution390 {
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private int leftToRight(int n){
        if(n == 1){
            return 1;
        }

        return 2 * rightToLeft(n / 2);
    }

    private int rightToLeft(int n){
        if(n == 1){
            return 1;
        }

        if(n % 2 == 0){
            return 2 * leftToRight(n / 2) - 1;
        }

        return 2 * leftToRight(n / 2);
    }
}
