class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a' + 1;
            int reverse = 27 - pos;

            sum += reverse * (i + 1);
        }

        return sum;
    }
}