class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i =1; i<nums.length; i++){
            if(nums[i] > temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int left = 0;
                int right = temp.size()-1;

                while(left < right){
                    int mid = left + (right - left)/2;

                    if(temp.get(mid) >= nums[i]){
                        right = mid;
                    }else{
                        left = mid+1;
                    }
                }

                temp.set(left,nums[i]);
            }
        }

        return temp.size();
    }
}