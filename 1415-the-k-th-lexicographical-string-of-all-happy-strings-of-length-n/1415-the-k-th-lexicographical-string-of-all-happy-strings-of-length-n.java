class Solution {

    int count = 0;
    String answer = "";

    public String getHappyString(int n, int k) {

        solve(n, k, "");

        return answer;
    }

    void solve(int n, int k, String str) {

        if (str.length() == n) {

            count++;

            if (count == k) {
                answer = str;
            }

            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {

            // Same character continuously nahi aa sakta
            if (str.length() > 0 && str.charAt(str.length() - 1) == ch)
                continue;

            solve(n, k, str + ch);

            // k-th mil gaya
            if (!answer.equals(""))
                return;
        }
    }
}