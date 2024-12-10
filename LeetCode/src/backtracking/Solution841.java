package backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 841. Keys and Rooms
// decision is which room you go to, state is the room you are in.
public class Solution841 {
    private Set<Integer> memo = new HashSet<>();
    private List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;

        memo.add(0);
        backtrack(0);

        return memo.size() == rooms.size();
    }

    private void backtrack(int i){
        if(memo.size() == rooms.size()){
            return;
        }

        for(int room : rooms.get(i)){
            if(memo.contains(room)){
                continue;
            }
            memo.add(room);

            if(memo.size() == rooms.size()){
                return;
            } else {
                backtrack(room);
            }
        }
    }
}
