package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 752. Open the Lock
public class Solution752 {
    private Set<String> deadendSet = new HashSet<>();
    private Set<String> visited = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        for (String deadend : deadends) {
            if (deadend.equals("0000")) {
                return -1;
            }
            deadendSet.add(deadend);
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();

        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String display = queue.poll();
                if (display.equals(target)) {
                    return step;
                }

                List<String> nextMoves = oneMove(display);
                for (String nextDisplay : nextMoves) {
                    if (!deadendSet.contains(nextDisplay) && !visited.contains(nextDisplay)) {
                        queue.add(nextDisplay);
                        visited.add(nextDisplay);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private List<String> oneMove(String current) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            res.add(moveUp(current, i));
            res.add(moveDown(current, i));
        }

        return res;
    }

    private String moveUp(String current, int i) {
        char[] charArray = current.toCharArray();
        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i]++;
        }

        return new String(charArray);
    }

    private String moveDown(String current, int i) {
        char[] charArray = current.toCharArray();
        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i]--;
        }

        return new String(charArray);
    }
}
