/**
 * Created by zk on 2016/10/1.
 */
public class IntegerReplacement {
    public static int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else {
                if ((n + 1) % 4 == 0 && n != 3) n += 1; //可以一下连除两次2
                else n -= 1;
            }
            count++;
            System.out.print(n + ", ");
        }
        return count;

    }

    public static int integerReplacement1(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else n -= 1;
            count++;
            System.out.print(n + ", ");
        }
        return count;

    }

    public static void main(String[] args) {
        int num = 103;
        integerReplacement(num);
        System.out.print("\n");
        integerReplacement1(num);
//        System.out.println(integerReplacement(num));
//        System.out.println(integerReplacement1(num));
    }
}
