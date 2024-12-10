package string;

// // 394. Decode String
public class Solution394 {
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        return (String)(decode(sArray, 0)[0]);
    }

    // 0 -> string
    // 1 -> endIndex + 1
    private Object[] decode(char[] sArray, int index){
        StringBuilder sb = new StringBuilder();

        char c = 0;
        while(index < sArray.length && (c = sArray[index]) != ']') {
            int repeatNum = 0;
            while(index < sArray.length && (c = sArray[index]) != '['){
                if(Character.isDigit(c)) {
                    repeatNum = repeatNum * 10 + (c - '0');
                } else {
                    if(c == ']'){
                        break;
                    }
                    sb.append(c);
                }

                index++;
            }

            if(index == sArray.length){
                break;
            }

            if(c == '[') {
                Object[] nextRes = decode(sArray, index + 1);
                String str = (String)nextRes[0];
                index = (Integer)nextRes[1];

                for(int i = 0; i < repeatNum; i++){
                    sb.append(str);
                }
            }
        }
        if(index == sArray.length){
            return new Object[]{sb.toString(), index};
        }

        return new Object[]{sb.toString(), index + 1};
    }
}
