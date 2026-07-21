class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> blocks = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char ch = t.charAt(i);
            int cnt = 0;

            while (i < t.length() && t.charAt(i) == ch) {
                cnt++;
                i++;
            }

            blocks.add(ch);
            len.add(cnt);
        }

        int ans = ones;

        for (int j = 1; j < blocks.size() - 1; j++) {

            if (blocks.get(j) == '1'
                    && blocks.get(j - 1) == '0'
                    && blocks.get(j + 1) == '0') {

                ans = Math.max(ans,
                        ones + len.get(j - 1) + len.get(j + 1));
            }
        }

        return ans;
    }
}