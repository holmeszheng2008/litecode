package misc.math;

// 13. Roman to Integer
public class Solution13 {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            switch(c){
                case 'I' -> {
                    if(i != s.length() - 1){
                        char nextC = s.charAt(i+1);
                        if(nextC == 'V'){
                            res += 4;
                            i+=2;
                        } else if(nextC == 'X'){
                            res += 9;
                            i+=2;
                        } else {
                            res += 1;
                            i++;
                        }
                    } else {
                        res += 1;
                        i++;
                    }
                }
                case 'V' -> {
                    res += 5;
                    i++;
                }
                case 'X' -> {
                    if(i != s.length() - 1){
                        char nextC = s.charAt(i+1);
                        if(nextC == 'L'){
                            res += 40;
                            i+=2;
                        } else if(nextC == 'C'){
                            res += 90;
                            i+=2;
                        } else {
                            res += 10;
                            i++;
                        }
                    } else {
                        res += 10;
                        i++;
                    }
                }
                case 'L' -> {
                    res += 50;
                    i++;
                }
                case 'C' -> {
                    if(i != s.length() - 1){
                        char nextC = s.charAt(i+1);
                        if(nextC == 'D'){
                            res += 400;
                            i+=2;
                        } else if(nextC == 'M'){
                            res += 900;
                            i+=2;
                        } else {
                            res += 100;
                            i++;
                        }
                    } else {
                        res += 100;
                        i++;
                    }
                }
                case 'D' -> {
                    res += 500;
                    i++;
                }
                case 'M' -> {
                    res += 1000;
                    i++;
                }
                default -> {}
            }
        }

        return res;
    }
}
