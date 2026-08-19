class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Build bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Ignore seats 1 and 10
            if (col >= 2 && col <= 9) {
                int bit = 1 << (col - 2);

                map.put(row, map.getOrDefault(row, 0) | bit);
            }
        }

        // Rows with no reservations in seats 2 to 9
        int ans = (n - map.size()) * 2;

        // Masks for possible family arrangements
        int left = 0b11110000;   // seats 2,3,4,5
        int middle = 0b11000011; // seats 4,5,6,7
        int right = 0b00001111;  // seats 6,7,8,9

        for (int mask : map.values()) {

            // Check left group
            if ((mask | left) == left) {
                ans++;
            }

            // Check right group
            else if ((mask | right) == right) {
                ans++;
            }

            // Check middle group
            else if ((mask | middle) == middle) {
                ans++;
            }
        }

        return ans;
    }
}