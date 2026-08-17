class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i =0;
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        while(i < n){
            int first = nums[i];
            int last = nums[i];

            while(i < n-1 && last+1 == nums[i+1]){
                i++;
                last++;
            } 
            StringBuilder sb = new StringBuilder();
            sb.append(first);
            
            if(first != last){
                sb.append("->");
                sb.append(last);
            } 
            ans.add(sb.toString());
            i++;
        }
        return ans;
    }
}