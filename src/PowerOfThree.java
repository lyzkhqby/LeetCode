/**
 * Created by rotoosoft-d04 on 2016/9/28.
 */
public class PowerOfThree {
    public class Solution {
        public boolean isPowerOfThree(int n) {
            return (n > 0 && 1162261467 % n == 0);
        }
    }
}
