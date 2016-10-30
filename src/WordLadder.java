/**
 * Created by rotoosoft-d04 on 2016/10/30.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null) return 0;
        if (beginWord.equals(endWord)) return 1;


        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        hash.add(beginWord);
        queue.offer(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i =0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, wordList)) {
                    if (hash.contains(nextWord)) continue;
                    if (nextWord.equals(endWord)) return length;
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }



    private ArrayList<String> getNextWords(String word, Set<String> wordList) {
        ArrayList<String> nextWords = new ArrayList<>();
        int len = word.length();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < len; i++) {
                if (c == word.charAt(i)) continue;
                String nextWord = replace(word, i, c);
                if (wordList.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
