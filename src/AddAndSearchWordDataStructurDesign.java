/**
 * Created by rotoosoft-d04 on 2016/11/24.
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class AddAndSearchWordDataStructurDesign {
    public class WordDictionary {

        private TrieNode root;
        public WordDictionary() {
            this.root = new TrieNode();
        }
        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode now = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (now.children[pos] == null) {
                    now.children[pos] = new TrieNode();
                }
                now = now.children[pos];
            }
            now.hasWord = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return find(word, 0, root);
        }

        private boolean find(String word, int index, TrieNode now) {
            if (index == word.length()) return now.hasWord;
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (now.children[i] != null) {
                        if (find(word, index + 1, now.children[i]))
                            return true;
                    }
                }
                return false;
            }else if (now.children[c - 'a'] != null) {
                return find(word, index + 1, now.children[c - 'a']);
            }else {
                return false;
            }
        }

        class TrieNode {

            public TrieNode[] children;
            public boolean hasWord;

            public TrieNode() {
                children = new TrieNode[26];
                hasWord = false;
            }

        }
    }
}
