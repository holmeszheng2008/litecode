package misc.math;

// 65. Valid Number
public class Solution65 {
    public boolean isNumber(String s) {
        int leIndex = s.indexOf('e');
        int ceIndex = s.indexOf('E');
        if(leIndex == -1 && ceIndex == -1){
            return isValidDecimal(s) || isValidInteger(s);
        } else if(leIndex == -1) {
            String first = s.substring(0, ceIndex);
            String second = s.substring(ceIndex + 1);

            return (isValidInteger(first) || isValidDecimal(first)) && isValidInteger(second);
        } else {
            String first = s.substring(0, leIndex);
            String second = s.substring(leIndex + 1);
            return (isValidInteger(first) || isValidDecimal(first)) && isValidInteger(second);
        }
    }

    private boolean isValidDecimal(String s){
        if(s.isEmpty()){
            return false;
        }

        int dotIndex = s.indexOf('.');
        if(dotIndex == -1){
            return false;
        }
        String first = s.substring(0, dotIndex);
        if(!first.isEmpty()) {
            if(first.charAt(0) == '+' || first.charAt(0) == '-') {
                first = first.substring(1);
            }
        }
        String second = s.substring(dotIndex + 1);

        if(first.isEmpty() && second.isEmpty()){
            return false;
        } else if (first.isEmpty()){
            if(second.charAt(0) == '+' || second.charAt(0) == '-'){
                return false;
            }
            return isValidInteger(second);
        } else if (second.isEmpty()){
            if(first.charAt(0) == '+' || first.charAt(0) == '-'){
                return false;
            }
            return isValidInteger(first);
        } else {
            if(first.charAt(0) == '+' || first.charAt(0) == '-'){
                return false;
            }
            if(second.charAt(0) == '+' || second.charAt(0) == '-'){
                return false;
            }

            return isValidInteger(first) && isValidInteger(second);
        }

    }

    private boolean isValidInteger(String s){
        if(s.isEmpty()){
            return false;
        }

        int start = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            start = 1;
        }
        if(s.length() - start == 0) {
            return false;
        }

        for(int i = start; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
