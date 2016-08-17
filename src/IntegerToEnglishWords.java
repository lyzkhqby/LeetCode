/**
 * Created by zk on 2016/7/26.
 */
public class IntegerToEnglishWords {
    private final static String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final static String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public static String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }

    private static String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + belowTen[num % 10];
        else if (num < 1000) result = belowTen[num / 100] + " Hundred " + helper(num % 100);
        else if (num < 1000000) result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.print(numberToWords(239542326));
    }
}
