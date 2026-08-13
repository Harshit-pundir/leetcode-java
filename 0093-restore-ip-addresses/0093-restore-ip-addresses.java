class Solution {

    List<String> ans = new ArrayList<>();
    void solve(String s, int index, String ip, int parts) {

        // 4 parts ban gaye
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }

        // 1, 2, 3 digits
        for (int i = 1; i <= 3; i++) {

            if (index + i > s.length())
                break;

            String part = s.substring(index, index + i);

            // 01, 00 etc. invalid
            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            int num = Integer.parseInt(part);

            if (num > 255)
                continue;

            solve(s, index + i, ip + part + ".", parts + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        solve(s, 0, "", 0);
        return ans;
    }
}