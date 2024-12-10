package misc.math.interval;

import java.util.Arrays;

// 1024. Video Stitching
public class Solution1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            return (o2[1] - o1[1]);
        });

        int res = 0;
        int end = 0, nextEnd = 0;
        int i = 0;
        while(i < clips.length && clips[i][0] <= end){
            while(i < clips.length && clips[i][0] <= end){
                nextEnd = Math.max(clips[i][1], nextEnd);
                i++;
            }
            res++;
            end = nextEnd;
            if (end >= time){
                return res;
            }
        }

        return -1;
    }
}

class Solution1024_attempt1 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            return (o2[1] - o1[1]);
        });

        if (clips[0][0] != 0){
            return -1;
        }

        int res = 0;
        int end = 0, nextEnd = 0;
        for(int i = 0; i < clips.length;){
            if(end < clips[i][0]){
                return -1;
            }
            for(; i < clips.length; i++){
                if(clips[i][0] <= end){
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                    continue;
                }
                break;
            }

            res++;
            end = nextEnd;

            if (end >= time){
                return res;
            }
        }

        return -1;
    }
}

