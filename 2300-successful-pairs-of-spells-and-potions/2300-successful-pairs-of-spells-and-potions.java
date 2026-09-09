class Solution {
    public int findSuccess(int val, int[] potions, long success) {
        int low = 0;
        int high = potions.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) potions[mid] * val >= success) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return potions.length - low;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        Arrays.sort(potions);

        int[] ans = new int[n];

        int i = 0;
        while (i < n) {
            ans[i] = findSuccess(spells[i], potions, success);
            i++;
        }

        return ans;
    }
}