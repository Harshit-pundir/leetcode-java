class Solution {

    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String temp = s + "#" + rev;

        int[] lps = new int[temp.length()];

        int i = 1;
        int len = 0;

        while (i < temp.length()) {

            if (temp.charAt(i) == temp.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestPrefix = lps[temp.length() - 1];

        String remain = s.substring(longestPrefix);

        return new StringBuilder(remain).reverse().toString() + s;
    }
}