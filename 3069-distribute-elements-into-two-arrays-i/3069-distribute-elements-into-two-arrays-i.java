class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int i = 2;
        while(i < n){
            if(arr1.get(arr1.size()-1) >= arr2.get(arr2.size()-1)) arr1.add(nums[i]);
            else arr2.add(nums[i]);
            i++;
        }

        i = 0;
        for(int num : arr1) nums[i++] = num;
        for(int num : arr2) nums[i++] = num;

        return nums;
    }
}