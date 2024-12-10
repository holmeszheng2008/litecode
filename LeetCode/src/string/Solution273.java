package string;

import java.util.HashMap;
import java.util.Map;

// 273. Integer to English Words
public class Solution273 {
    private Map<Integer, String> map = new HashMap<>();
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");

        int billionNum = 0, millionNum = 0, thousandNum = 0, hundredNum = 0;
        int sectionNum = 1_000;
        hundredNum = num % sectionNum;
        num /= sectionNum;
        thousandNum = num % sectionNum;
        num /= sectionNum;
        millionNum = num % sectionNum;
        num /= sectionNum;
        billionNum = num % sectionNum;

        String res = "";
        boolean firstSectionSaid = false;

        if(billionNum != 0){
            res = speak3Digits(billionNum) + " " + "Billion";
            firstSectionSaid = true;
        }
        if(millionNum != 0){
            if(firstSectionSaid){
                res = res + " ";
            }
            res = res + speak3Digits(millionNum) + " " + "Million";
            firstSectionSaid = true;
        }
        if(thousandNum != 0){
            if(firstSectionSaid){
                res = res + " ";
            }
            res = res + speak3Digits(thousandNum) + " " + "Thousand";
            firstSectionSaid = true;
        }
        if(hundredNum != 0){
            if(firstSectionSaid){
                res = res + " ";
            }
            res = res + speak3Digits(hundredNum);
        }

        return res;
    }

    private String speak2Digits(int num){
        switch(num){
            case 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90 ->  {
                return map.get(num);
            }
        }
        int second = num % 10;
        int first = num / 10;

        return speak2Digits(first*10) + " " + speak2Digits(second);
    }

    private String speak3Digits(int num){
        int lastTwoDigit = num % 100;
        int first = num / 100;

        String speakFirst = speak2Digits(first);
        String speakLast2 = speak2Digits(lastTwoDigit);
        if(first == 0){
            return speakLast2;
        }
        String res = speakFirst + " " + "Hundred";
        if(lastTwoDigit == 0){
            return res;
        }

        return res + " " + speakLast2;
    }
}