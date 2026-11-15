class WordDictionary {
    class Node {
        Node[] children;
        boolean flag;

        Node() {
            children = new Node[26]; 
            flag = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(node.children[idx] == null) {
                node.children[idx] = new Node();
            }

            node = node.children[idx];
        }

        node.flag = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    public boolean dfs(int idx, String word, Node node) {

        if(idx == word.length()) {
            return node.flag;
        }

        char ch = word.charAt(idx);

        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if(dfs(idx + 1, word, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }

        int pos = ch - 'a';

        if(node.children[pos] == null) {
            return false;
        }

        return dfs(idx + 1, word, node.children[pos]);
    }
}