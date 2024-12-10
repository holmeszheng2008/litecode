package bit_operation;

// 393. UTF-8 Validation
public class Solution393 {
    public boolean validUtf8(int[] data) {
        for(int index = 0; index < data.length; ){
            if((data[index] & (1 << 7)) == 0){
                index++;
                continue;
            }
            int bytesLength = 0;
            int lengthDetectorMask = 1 << 7;
            while(bytesLength <= 8){
                if((data[index] & lengthDetectorMask) > 0) {
                    bytesLength++;
                    lengthDetectorMask >>= 1;
                } else {
                    break;
                }
            }

            if(bytesLength > 4 || bytesLength == 1){
                return false;
            }

            bytesLength--;
            index++;

            while(index < data.length && bytesLength > 0){
                int mask = 1 << 1;

                if(((data[index] << 24) >>> 30) != mask) {
                    return false;
                }
                index++;
                bytesLength--;
            }

            if(bytesLength != 0){
                return false;
            }
        }

        return true;
    }
}
