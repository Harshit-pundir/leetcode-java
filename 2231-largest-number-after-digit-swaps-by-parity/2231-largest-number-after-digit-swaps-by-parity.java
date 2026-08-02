class Solution {
    public int largestInteger(int num) {

        String s = String.valueOf(num);

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        // Store even and odd digits separately
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            if (digit % 2 == 0)
                even.add(digit);
            else
                odd.add(digit);
        }

        // Sort in descending order
        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());

        int e = 0, o = 0;
        StringBuilder ans = new StringBuilder();

        // Build the answer
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            if (digit % 2 == 0)
                ans.append(even.get(e++));
            else
                ans.append(odd.get(o++));
        }

        return Integer.parseInt(ans.toString());
    }
}