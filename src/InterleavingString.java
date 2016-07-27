/**
 * Created by rotoosoft-d04 on 2016/7/21.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenS1 = s1.length(), lenS2 = s2.length(), lenS3 = s3.length();
        if(lenS1 + lenS2 != lenS3) return false;

        boolean[][] interleaved = new boolean[lenS1 + 1][lenS2 + 1];
        interleaved[0][0] = true;

        for (int i = 1; i <= lenS1; i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0]) {
                interleaved[i][0] = true;
            }
        }

        for (int i = 1; i <= lenS2; i++) {
            if(s3.charAt(i - 1) == s2.charAt(i - 1) && interleaved[0][i - 1]) {
                interleaved[0][i] = true;
            }
        }

        for (int i = 1; i <= lenS1; i++) {
            for (int j = 1; j <= lenS2; j++) {
                if((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]) ||
                        (s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleaved[i][j - 1])) {
                    interleaved[i][j] = true;
                }
            }
        }
        return interleaved[lenS1][lenS2];
    }
}
