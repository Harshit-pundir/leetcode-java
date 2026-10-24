class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean first = false;
        boolean second = false;

        int firstNum = -1;
        int secondNum = -1;

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count > n / 3) {
                    if (!first) {
                        first = true;
                        firstNum = nums[i];
                    } else if (nums[i] != firstNum) {
                        second = true;
                        secondNum = nums[i];
                    }
                }
                count = 1;
            }

            if (first && second) break;
        }

        if(first && second){
            return new ArrayList<>(Arrays.asList(firstNum,secondNum));
        }else if(first && !second){
            return new ArrayList<>(Arrays.asList(firstNum));
        }else if(!first && second){
            return new ArrayList<>(Arrays.asList(secondNum));
        }

        return new ArrayList<>();

        
    }
}