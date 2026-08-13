class Solution {

    int[] leftLen;
    int[] rightLen;
    int[] maxLen;
    int[] len;

    char[] leftChar;
    char[] rightChar;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();

        leftLen = new int[4 * n];
        rightLen = new int[4 * n];
        maxLen = new int[4 * n];
        len = new int[4 * n];

        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            arr[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = maxLen[1];
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {

            len[node] = 1;
            leftLen[node] = 1;
            rightLen[node] = 1;
            maxLen[node] = 1;

            leftChar[node] = arr[l];
            rightChar[node] = arr[l];

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node);
    }

    void update(int node, int l, int r, int index) {

        if (l == r) {

            leftLen[node] = 1;
            rightLen[node] = 1;
            maxLen[node] = 1;

            leftChar[node] = arr[l];
            rightChar[node] = arr[l];

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        merge(node);
    }

    void merge(int node) {

        int L = node * 2;
        int R = node * 2 + 1;

        len[node] = len[L] + len[R];

        leftChar[node] = leftChar[L];
        rightChar[node] = rightChar[R];

        // Prefix
        leftLen[node] = leftLen[L];

        if (leftLen[L] == len[L] &&
            rightChar[L] == leftChar[R]) {

            leftLen[node] = len[L] + leftLen[R];
        }

        // Suffix
        rightLen[node] = rightLen[R];

        if (rightLen[R] == len[R] &&
            rightChar[L] == leftChar[R]) {

            rightLen[node] = len[R] + rightLen[L];
        }

        // Maximum
        maxLen[node] = Math.max(maxLen[L], maxLen[R]);

        // Merge boundary
        if (rightChar[L] == leftChar[R]) {

            maxLen[node] = Math.max(
                maxLen[node],
                rightLen[L] + leftLen[R]
            );
        }
    }
}