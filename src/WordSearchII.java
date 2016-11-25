import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/11/25.
 */
public class WordSearchII {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {1, 0, -1, 0};


    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieTree tree = new TrieTree(new TrieNode());
        for (int i = 0; i < words.length; i++) {
            tree.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search();
            }
        }
        return ans;
    }

    private void search() {

    }

    class TrieNode {
        String s;
        boolean isString;
        HashMap<Character, TrieNode> subTree;

        public TrieNode() {
            isString = false;
            subTree = new HashMap<>();
            s = "";
        }
    }

    class TrieTree {
        TrieNode root;
        public TrieTree(TrieNode trieNode) {
            root = trieNode;
        }

        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!now.subTree.containsKey(c)) {
                    now.subTree.put(c, new TrieNode());
                }
                now = now.subTree.get(c);
            }
            now.s = s;
            now.isString = true;
        }

        public boolean find(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!now.subTree.containsKey(c)) {
                    return false;
                }
                now = now.subTree.get(c);
            }
            return now.isString;
        }
    }
}
