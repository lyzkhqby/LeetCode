import java.util.HashMap;
import java.util.Map;

/**
 * Created by zk on 2016/9/17.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        int len = words.length;
        Map map = new HashMap<>();
        for (Integer i= 0; i < len; i++) { //由于put返回的是Integer，如果用int会出现Integer地址不一样
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        String pattern = "itwasthebestoftimesitwastheworstoftimesitwastheageofwisdomitwastheageoffoolishnessitwastheepochofbeliefitwastheepochofincredulityitwastheseasonoflightitwastheseasonofdarknessitwasthespringofhopeitwasthewinterofdespair";
        String str = "i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee bbbbbbbbbbbbbbbbbb eeeeeeeeeee sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww oo rrrrrrrrrrrrrr sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff wwww i sssss ddddddddddd oo mmm i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff fffffffff oo oo llllllll i sssss hhhhhhhhhhhhhhhhhhhhhhh nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff bbbbbbbbbbbbbbbbbb eeeeeeeeeee llllllll i eeeeeeeeeee fffffffff i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff i nnnnnn cccccccccccc rrrrrrrrrrrrrr eeeeeeeeeee ddddddddddd uuuuuuuuuu llllllll i tttttttttttttttt yyyyyyyyyyy i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff llllllll i gggggggggggggg hhhhhhhhhhhhhhhhhhhhhhh tttttttttttttttt i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff ddddddddddd aa rrrrrrrrrrrrrr kkkkkkkkk nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss pppp rrrrrrrrrrrrrr i nnnnnn gggggggggggggg oo fffffffff hhhhhhhhhhhhhhhhhhhhhhh oo pppp eeeeeeeeeee i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww i nnnnnn tttttttttttttttt eeeeeeeeeee rrrrrrrrrrrrrr oo fffffffff ddddddddddd eeeeeeeeeee sssss pppp aa i rrrrrrrrrrrrrr";
        System.out.print(wordPattern(pattern, str));
    }
}
