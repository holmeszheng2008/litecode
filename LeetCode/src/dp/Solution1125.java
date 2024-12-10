package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1125. Smallest Sufficient Team
// Standard bottom up dp
public class Solution1125 {
    private Map<String, Integer> skillToIndex = new HashMap<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        for (int i = 0; i < req_skills.length; i++) {
            skillToIndex.put(req_skills[i], i);
        }


        int m = people.size() + 1, n = 1 << req_skills.length;
        List<Integer>[][] memo = new List[m][n];
        memo[0][0] = new ArrayList<>();


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // not take
                List<Integer> ij = memo[i][j];
                List<Integer> imj = memo[i-1][j];
                if(imj != null) {
                    if (ij == null) {
                        memo[i][j] = new ArrayList<>(imj);
                    } else {
                        if (imj.size() < ij.size()) {
                            memo[i][j] = new ArrayList<>(imj);
                        }
                    }
                }

                for(int k = 0; k <= j; k++) {
                    List<Integer> lastList = memo[i - 1][k];
                    if (lastList == null) {
                        continue;
                    }

                    // take
                    int nowSkill = convertListToMask(people.get(i - 1));
                    int nowMask = nowSkill | k;
                    if(nowMask != j){
                        continue;
                    }

                    List<Integer> nowList = memo[i][j];
                    List<Integer> competeList = new ArrayList<>(lastList);
                    competeList.add(i - 1);

                    if (nowList == null) {
                        memo[i][j] = competeList;
                    } else {
                        if (competeList.size() < nowList.size()) {
                            memo[i][j] = competeList;
                        }
                    }
                }
            }
        }

        return memo[m - 1][n - 1].stream().mapToInt(t -> t).toArray();
    }

    private int convertListToMask(List<String> skills) {
        int res = 0;
        for (String skill : skills) {
            int index = skillToIndex.get(skill);
            res += 1 << index;
        }

        return res;
    }
}

// With tricks not common but extremely suitable to this problem
class Solution1125_trick {
    private Map<String, Integer> skillToIndex = new HashMap<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        for (int i = 0; i < req_skills.length; i++) {
            skillToIndex.put(req_skills[i], i);
        }


        int m = people.size() + 1, n = 1 << req_skills.length;
        List<Integer>[][] memo = new List[m][n];
        memo[0][0] = new ArrayList<>();


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> lastList = memo[i - 1][j];
                if (lastList == null) {
                    continue;
                }

                // take
                int nowSkill = convertListToMask(people.get(i - 1));
                int nowMask = nowSkill | j;

                List<Integer> nowList = memo[i][nowMask];
                List<Integer> competeList = new ArrayList<>(lastList);
                competeList.add(i - 1);

                if (nowList == null) {
                    memo[i][nowMask] = competeList;
                } else {
                    if (competeList.size() < nowList.size()) {
                        memo[i][nowMask] = competeList;
                    }
                }

                // not take
                List<Integer> ij = memo[i][j];
                if (ij == null) {
                    memo[i][j] = new ArrayList<>(lastList);
                } else {
                    if (lastList.size() < ij.size()) {
                        memo[i][j] = new ArrayList<>(lastList);
                    }
                }
            }
        }

        return memo[m - 1][n - 1].stream().mapToInt(t -> t).toArray();
    }

    private int convertListToMask(List<String> skills) {
        int res = 0;
        for (String skill : skills) {
            int index = skillToIndex.get(skill);
            res += 1 << index;
        }

        return res;
    }
}