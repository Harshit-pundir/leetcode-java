class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int count =0;

        for(int i =0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for(ArrayList<Integer> list : map.values()){
            if(list.size() == 1) count++;
            else {
                boolean isValid = true;
                for(int i =0; i < list.size()-1; i++){
                    if((list.get(i)+1) != list.get(i+1)){
                        isValid = false;
                        break;
                    }
                    
                } 
                if(isValid) count++;
            }
            
        }
        return count;
    }
}