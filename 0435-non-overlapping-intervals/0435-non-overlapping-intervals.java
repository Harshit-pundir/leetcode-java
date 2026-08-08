class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int n = intervals.length;
        int count =0;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i =1; i < n; i++){
            if(intervals[i][0] < end){
                 count++;
                 end = Math.min(end, intervals[i][1]);
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return count;
    }
}