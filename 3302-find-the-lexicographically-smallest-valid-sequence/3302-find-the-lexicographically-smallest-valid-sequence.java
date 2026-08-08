class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suffix[i] = word2[i...] ko word1 ke kis index se
        // exactly match kar sakte hain
        int[] suffix = new int[m];

        Arrays.fill(suffix, -1);

        int i = n - 1;

        // Right se matching
        for (int j = m - 1; j >= 0; j--) {

            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0)
                break;

            suffix[j] = i;
            i--;
        }

        int[] ans = new int[m];

        int j = 0;
        int k = 0;

        // mismatch use hua ya nahi
        boolean used = false;

        for (i = 0; i < n && j < m; i++) {

            // Same character hai
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[k++] = i;
                j++;
            }

            // Different hai, ek mismatch use kar sakte hain
            else if (!used) {

                // Agar ye mismatch lete hain,
                // toh remaining characters match hone chahiye
                if (j == m - 1 || suffix[j + 1] > i) {

                    ans[k++] = i;
                    j++;
                    used = true;
                }
            }
        }

        // Pura word2 match nahi hua
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}