class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> ans = new ArrayList<>();

    // Build Trie
    public void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.word = word;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node) {

        // Boundary / visited
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];

        // Character doesn't exist in Trie
        if (node.child[ch - 'a'] == null) {
            return;
        }

        TrieNode next = node.child[ch - 'a'];

        // Word found
        if (next.word != null) {
            ans.add(next.word);

            // Prevent duplicate answer
            next.word = null;
        }

        // Mark visited
        board[i][j] = '#';

        dfs(board, i + 1, j, next); // down
        dfs(board, i - 1, j, next); // up
        dfs(board, i, j + 1, next); // right
        dfs(board, i, j - 1, next); // left

        // Backtrack
        board[i][j] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }
}