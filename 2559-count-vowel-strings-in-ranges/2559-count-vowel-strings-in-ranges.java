class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];

        Set<Character> vowels = new HashSet<>(
            Set.of('a', 'e', 'i', 'o', 'u')
        );

        for (int i = 0; i < n; i++) {
            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            int count = (vowels.contains(first) && vowels.contains(last)) ? 1 : 0;

            prefix[i] = count;

            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = prefix[r];

            if (l > 0) {
                ans[i] -= prefix[l - 1];
            }
        }

        return ans;
    }
}