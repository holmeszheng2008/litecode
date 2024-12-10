package misc;

// 38. Count and Say
public class Solution38 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int size = 0;
        char lastC = '*';
        for(char c : str.toCharArray()){
            if(c == lastC){
                size++;
            } else {
                 if(lastC != '*'){
                    sb.append(size).append(lastC);
                 }
                size = 1;
                lastC = c;
            }
        }


        sb.append(size).append(lastC);
        return sb.toString();
    }
}

class Solution38_attempt1 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        String str = countAndSay(n-1);

        StringBuilder sb = new StringBuilder();
        char preC = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            char newC = str.charAt(i);
            if(preC == newC) {
                count++;
            } else {
                sb.append(count);
                sb.append(preC);

                count = 1;
                preC = newC;
            }
        }

        sb.append(count);
        sb.append(preC);

        return sb.toString();
    }
}