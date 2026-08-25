class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int end = timeSeries[0] + duration;
        int count = duration;

        for (int i = 1; i < timeSeries.length; i++) {

            if (end >= timeSeries[i]) {
                count += timeSeries[i] + duration - end;
            } 
            else {
                count += duration;
            }

            end = timeSeries[i] + duration;
        }

        return count;
    }
}