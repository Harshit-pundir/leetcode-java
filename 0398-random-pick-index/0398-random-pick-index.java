class Solution {
    int[] arr;
    HashMap<Integer,ArrayList<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        arr = nums.clone();
        map = new HashMap<>();
        random = new Random();
        makeFreq();
    }

    public void makeFreq(){
        int i = 0;
        for(int num : arr){
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
            }
            map.get(num).add(i);
            i++;
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> temp = map.get(target);
        if(temp.size() == 1) return temp.get(0);
        int randomIdx = random.nextInt(temp.size());
        return temp.get(randomIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */