package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/29 12:34
 *
 * 208. 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class Test0208 {
    private class TrieNode { // 每个节点最多有26个不同的小写字母
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Test0208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0,len = word.length(),ch; i < len; i++) {
            ch = word.charAt(i)-'a';
            if (cur.next[ch]==null)
                cur.next[ch] = new TrieNode();
            cur = cur.next[ch];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0,len = word.length(),ch; i < len; i++) {
            ch = word.charAt(i)-'a';
            if (cur.next[ch]==null)
                return false;
            cur = cur.next[ch];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0,len = prefix.length(),ch; i < len; i++) {
            ch = prefix.charAt(i)-'a';
            if (cur.next[ch]==null)
                return false;
            cur = cur.next[ch];
        }
        return true;
    }
}
