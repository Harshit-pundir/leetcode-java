class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i =0; i < n; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int count =0;
        for(int num : map.keySet()){
            if(map.get(num).size() >= 3){
                int diff = Math.abs(map.get(num).get(0) - map.get(num).get(1));
                boolean isGood = true;
                for(int i = 1; i <map.get(num).size()-1; i++){
                    
                    if(Math.abs(map.get(num).get(i) - map.get(num).get(i+1)) != diff){
                        isGood = false;
                        break;
                    }
                }
                if(isGood) count++;
            } 
        }

        return count;
    }
}