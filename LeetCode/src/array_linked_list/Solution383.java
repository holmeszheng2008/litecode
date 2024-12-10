package array_linked_list;

import java.util.HashMap;
import java.util.Map;

// 383. Ransom Note
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ransomNoteArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        for(int i = 0; i < magazineArray.length; i++){
            char c = magazineArray[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < ransomNoteArray.length; i++){
            char c = ransomNoteArray[i];
            if(!map.containsKey(c)){
                return false;
            }

            int count = map.get(c);
            count--;
            if(count == 0){
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }

        return true;
    }
}
