package array_linked_list;

import java.util.HashSet;
import java.util.Set;

// 36. Valid Sudoku
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if (Character.isDigit(c)){
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }
            }
            set.clear();
        }

        for(int j = 0; j < board[0].length; j++){
            for(int i = 0; i < board.length; i++){
                char c = board[i][j];
                if (Character.isDigit(c)){
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }
            }
            set.clear();
        }

        for(int w = 0; w <= 6; w+=3){
            for(int k = 0; k <= 6; k+=3){
                for(int i = w; i <w+3; i++){
                    for(int j = k; j < k+3; j++){
                        char c = board[i][j];
                        if (Character.isDigit(c)){
                            if(set.contains(c)){
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
                set.clear();
            }
        }

        return true;
    }
}

// Use String as key
class Solution36_attempt1 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char num = board[i][j];
                if(num == '.') {
                    continue;
                }
                String rowString = rowString(num, i);
                String colString = colString(num, j);
                String boxString = boxString(num, i, j);
                if(set.add(rowString) && set.add(colString) && set.add(boxString)){

                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private String rowString(char num, int row){
        return "number " + num + " row " + row;
    }
    private String colString(char num, int col){
        return "number " + num +" col " + col;
    }
    private String boxString(char num, int row, int col){
        return "number " + num + " box row " + row / 3 + " col " + col / 3;
    }
}