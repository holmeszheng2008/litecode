package array_linked_list.two_pointers.left_right_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 345. Reverse Vowels of a String
public class Solution345 {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] sArray = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !vowelSet.contains(sArray[i])){
                i++;
            }
            while(i < j && !vowelSet.contains(sArray[j])){
                j--;
            }
            if(i < j){
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;

                i++;
                j--;
            }
        }

        return String.valueOf(sArray);
    }
}

