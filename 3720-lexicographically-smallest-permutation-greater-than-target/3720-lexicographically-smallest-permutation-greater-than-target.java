class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder ans = new StringBuilder();
        boolean[] used = new boolean[chars.length];

        if (dfs(chars, target, 0, ans, used, false)) {
            return ans.toString();
        }

        return "";
    }

    private boolean dfs(char[] chars, String target, int pos,
                        StringBuilder ans, boolean[] used, boolean greater) {

        if (pos == chars.length) {
            return greater;
        }

        for (int i = 0; i < chars.length; i++) {

            if (used[i]) continue;

            // Skip duplicate characters
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            char c = chars[i];

            if (!greater) {
                if (c < target.charAt(pos)) continue;

                if (c == target.charAt(pos)) {
                    used[i] = true;
                    ans.append(c);

                    if (dfs(chars, target, pos + 1, ans, used, false))
                        return true;

                    ans.deleteCharAt(ans.length() - 1);
                    used[i] = false;
                } else {
                    // c > target[pos]
                    used[i] = true;
                    ans.append(c);

                    // Once greater, remaining chars should be smallest possible
                    for (int j = 0; j < chars.length; j++) {
                        if (!used[j]) {
                            used[j] = true;
                            ans.append(chars[j]);
                        }
                    }

                    return true;
                }
            }
        }

        return false;
    }
}