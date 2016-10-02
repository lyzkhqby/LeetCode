/**
 * Created by zk on 2016/10/2.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (D - B) * (C - A);
        int areaB = (H - F) * (G - E);
        int lowTop = Math.min(D, H);
        int upperBottom = Math.max(B, F);
        int leftRight = Math.min(C, G);
        int rightLeft = Math.max(A, E);
        int overlap = 0;
        if (lowTop > upperBottom && leftRight > rightLeft) {
            overlap = (lowTop - upperBottom) * (leftRight - rightLeft);
        }
        return areaA + areaB - overlap;
    }
}
