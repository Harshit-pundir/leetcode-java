class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int[] freq = new int[100005];

        for(int num : nums){
            freq[num]++;
        }

        for(int num : target){
            freq[num]--;
            if(freq[num] < 0) return 0;
        }


        int len = 1;
        for(int i = n-2; i >= 0; i--){
            if(target[i] >= target[i+1]) len++;
            else break;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(n - i <= len) ans++;
            if(nums[i] != target[i]) return ans;
        }
        return ans;
    }
}