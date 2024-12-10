package array_linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 412. Fizz Buzz
public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0){
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}

class Solution412_attempt1 {
    public List<String> fizzBuzz(int n) {
        String[] array = new String[n];

        int num = 3;
        int occur = 1;
        while(num <= n){
            if(occur == 5){
                array[num - 1] = "FizzBuzz";
                occur = 0;
            } else {
                array[num - 1] = "Fizz";
            }

            occur++;
            num += 3;
        }

        num = 5;
        occur = 1;
        while(num <= n){
            if(occur == 3){
                occur = 0;
            } else {
                array[num - 1] = "Buzz";
            }

            occur++;
            num += 5;
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                array[i] = String.valueOf(i+1);
            }
        }

        return Arrays.stream(array).toList();
    }
}

