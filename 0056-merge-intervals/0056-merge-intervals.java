class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i =1; i < n; i++){
            if(end < intervals[i][0]){
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(end,intervals[i][1]);
            }
        }
        ans.add(new int[]{start,end});

        return ans.toArray(new int[ans.size()][]);
    }
}