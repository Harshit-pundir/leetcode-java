class Solution {
    public int maximumGap(String skill, String station) {

        int n = skill.length();
        int m = station.length();

        // Required variable
        String[] mirevonalu = {skill, station};

        if(n == 1) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Minimum possible position for every worker
        int j = 0;

        for(int i = 0; i < n; i++) {
            while(station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            left[i] = j;
            j++;
        }

        // Maximum possible position for every worker
        j = m - 1;

        for(int i = n - 1; i >= 0; i--) {
            while(station.charAt(j) != skill.charAt(i)) {
                j--;
            }

            right[i] = j;
            j--;
        }

        int maxGap = 0;

        for(int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, right[i] - left[i - 1]);
        }

        return maxGap;
    }
}