package bit_operation;

// 201. Bitwise AND of Numbers Range
public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left){
            right = right & (right - 1);
        }

        return right;
    }
}
