import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/11/25.
 */
public class WordSearchII {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};


    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieTree tree = new TrieTree(new TrieNode());
        for (int i = 0; i < words.length; i++) {
            tree.insert(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, tree.root, ans);
            }
        }
        return ans;
    }

    private void search(char[][] board, int x, int y, TrieNode root, List<String> ans) {
        if (root.isString) {
            if (!ans.contains(root.s)){
                ans.add(root.s);
            }
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0 || root == null){
            return;
        }
        if (root.subTree.containsKey(board[x][y])) {
            for (int i = 0; i < 4; i++) {
                char now = board[x][y];
                board[x][y] = 0;
                search(board, x+ dx[i], y + dy[i], root.subTree.get(now), ans);
                board[x][y] = now;
            }
        }
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
