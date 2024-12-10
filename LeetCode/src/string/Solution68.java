package string;

import java.util.ArrayList;
import java.util.List;

// 68. Text Justification
public class Solution68 {
    private String[] words;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        int currentWidth = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            currentWidth += word.length();

            if(i == words.length - 1){
                end = i;
                res.add(justifyLastLine(start, end, maxWidth, currentWidth));
                continue;
            }

            String nextWord = words[i+1];
            if(currentWidth + 1 + nextWord.length() > maxWidth){
                end = i;
                res.add(justifyNormalLine(start, end, maxWidth, currentWidth));

                currentWidth = 0;
                start = i+1;
                continue;
            }

            currentWidth++;
        }

        return res;
    }

    private String justifyLastLine(int start, int end, int maxWidth, int currentWidth){
        StringBuilder sb = new StringBuilder();
        int leftSpaces = maxWidth - currentWidth;
        for(int i = start; i < end; i++){
            sb.append(words[i]).append(' ');
        }
        sb.append(words[end]);
        for(int i = 0; i < leftSpaces; i++){
            sb.append(' ');
        }

        return sb.toString();
    }

    private String justifyNormalLine(int start, int end, int maxWidth, int currentWidth){
        StringBuilder sb = new StringBuilder();
        int leftSpaces = maxWidth - currentWidth;
        int holes = end - start;
        if(holes == 0){
            sb.append(words[start]);
            for(int i = 0; i < leftSpaces; i++){
                sb.append(' ');
            }
        } else {
            for(int i = start; i < end; i++){
                sb.append(words[i]);
                int numOfSpaces = (leftSpaces + holes - 1) / holes;
                holes--;
                leftSpaces -= numOfSpaces;

                for(int j = 0; j < numOfSpaces + 1; j++){
                    sb.append(' ');
                }
            }

            sb.append(words[end]);
        }

        return sb.toString();
    }
}
