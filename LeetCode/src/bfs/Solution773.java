package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 773. Sliding Puzzle
public class Solution773 {
    private int[][] exchanges = new int[][] {
        new int[] {1,3},
        new int[] {0,2,4},
        new int[] {1,5},
        new int[] {0,4},
        new int[] {1,3,5},
        new int[] {2,4}
    };
    private Set<String> visited = new HashSet<>();

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        String boardStr = "";
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                boardStr += board[i][j];
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(boardStr);
        visited.add(boardStr);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentNode = queue.poll();

                if (currentNode.equals(target)) {
                    return step;
                }

                List<String> nextNodes = nextMoves(currentNode);
                for (String nextNode : nextNodes) {
                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        queue.offer(nextNode);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private List<String> nextMoves(String boardStr) {
        List<String> res = new ArrayList<>();
        
        int i = 0;
        for (; i < 6; i++) {
            if (boardStr.charAt(i) == '0') {
                break;
            }
        }

        for (int j : exchanges[i]) {
            res.add(generateNext(boardStr, i, j));
        }

        return res;
    }

    private String generateNext(String original, int i, int j) {
        char[] charArray = original.toCharArray();
        char c = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = c;

        return new String(charArray);
    }
}