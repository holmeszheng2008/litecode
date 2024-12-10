package misc.math;

// 223. Rectangle Area
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aeraA = (ax2 - ax1) * (ay2 - ay1);
        int aeraB = (bx2 - bx1) * (by2 - by1);

        int overlapX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapY = Math.min(ay2, by2) - Math.max(ay1, by1);

        int areaOfOverlap = 0;
        if (overlapX > 0 && overlapY > 0) {
            areaOfOverlap = overlapX * overlapY;
        }

        return aeraA + aeraB - areaOfOverlap;
    }
}
