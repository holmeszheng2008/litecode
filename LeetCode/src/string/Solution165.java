package string;

// 165. Compare Version Numbers
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        int m = revisions1.length;
        int n = revisions2.length;

        if(m >= n){
            return compare(revisions1, revisions2);
        } else {
            return -compare(revisions2, revisions1);
        }
    }

    private int compare(String[] revisions1, String[] revisions2){
        int m = revisions1.length;
        int n = revisions2.length;

        for(int i = 0; i < n; i++){
            int revisionRes = convertRevisionToInt(revisions1[i]) - convertRevisionToInt(revisions2[i]);
            if(revisionRes != 0){
                return (revisionRes > 0) ? 1 : -1;
            }
        }

        for(int i = n; i < m; i++){
            int revision = convertRevisionToInt(revisions1[i]);
            if(revision != 0){
                return 1;
            }
        }

        return 0;
    }

    private int convertRevisionToInt(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = res * 10 + s.charAt(i) - '0';
        }

        return res;
    }
}
