/**
 * Created by zk on 2016/11/13.
 */
public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < len; i++) {
            two |= (one & nums[i]);
            one ^= nums[i];
            three = one & two;
            two -= three;
            one -=three;
        }
        return one;
    }

    public void main(String[] args) {

    }
}

//    假设当前已经统计了A[]中的一些数，one、two都有相应值。
//
//        对于下一个要统计的数A[i]，若one中第k位为1，A[i]的第k位也为1，说明出现到两次要向two进位，此时two的第k位需要由0(当one的第k位为1时，two的第k位只能是0)变为1，其他情况下two的第k位保持原值。所以用one&A[i]取出one和A[i]中同为1的位，再与two进行或运算，得到更新后的two。
//
//        two |= (one & A[i]);
//        对于one的各个位的更新，遵循：
//
//
//        遵循异或的运算规则，可以直接用异或位运算。
//
//        one ^= A[i];
//        更新完one和two之后，会有one和two的第k位同时为1的情况（即对应位出现3次），此时需要将同为1的对应位都清为0.
//
//        three = one & two; //取出同为1的位
//        one -= three; //one中对应位清0
//        two -= three; //two中对用位清0
//http://blog.csdn.net/jocyln9026/article/details/19397477
