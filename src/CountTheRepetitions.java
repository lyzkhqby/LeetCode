import java.awt.*;

/**
 * Created by rotoosoft-d04 on 2016/12/10.
 */
public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        Point[][] map = new Point[len1][len2];
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        while (p1[1] < n1) {
            char c = s2.charAt(p2[0]);
            while (p1[1] < n1 && s1.charAt(p1[0]) != c) {
                inc(p1, len1);
            }
            if (map[p1[0]][p2[0]] == null) {
                map[p1[0]][p2[0]] = new Point(p1[1], p2[1]);
            }else {
                int deltaP1 = p1[1] - map[p1[0]][p2[0]].x;
                int deltaP2 = p2[1] - map[p1[0]][p2[0]].y;
                int k = (n1 - deltaP1 - 1) / deltaP1;
                p1[1] += k * deltaP1;
                p2[1] += k * deltaP2;
            }
            inc(p1, len1);
            inc(p2, len2);

        }
        return p2[1] / n2;

    }

    private void inc(int[] p, int len) {
        if (++p[0] == len) {
            p[0] = 0;
            p[1] += 1;
        }
    }
}
