/**
 * Created by rotoosoft-d04 on 2016/11/11.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}

//我们来看看2的次方数的规律：
//
//
//        1 => 1
//        10 => 2
//        100 => 4
//        1000 => 8
//        10000 => 16
//        100000 => 32
//        1000000 => 64
//        10000000 => 128
//        100000000 => 256
//        1000000000 => 512
//        10000000000 => 1024
//        100000000000 => 2048
//        1000000000000 => 4096
//        10000000000000 => 8192
//        100000000000000 => 16384

//        我们发现，每次不过是将1向左移动一个位置，然后低位补0（这不是废话么= =|||）
//
//        那么4的次方数就是将1向左移动两个位置喽 （还是废话（╯－＿－）╯╧╧）
//
//        观察一下位置，4的次方中的1只出现在奇数的位置上！就是说，上面的二进制从右往左，第1，3，5，……位置上。
//
//        So，如果我们与上一个可以在奇数上面选择位置的数，也就是 0101 0101 ……那么就把不是4次方的排除掉啦
//
//        0101 0101 …… 十六进制表示为： 0x55555555
