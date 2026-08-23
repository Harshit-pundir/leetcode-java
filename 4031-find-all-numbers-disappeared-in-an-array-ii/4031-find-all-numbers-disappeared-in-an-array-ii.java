class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> missing = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        for(int i = lower; i <= upper;i++){
            if(!set.contains(i)) missing.add(i);
        }
        int first = 0;
        if(missing.size() != 0)
        first = missing.get(0);
        int last = 0;

        for(int i =0; i<missing.size()-1; i++){
            if((missing.get(i) + 1) != missing.get(i+1)){
                last = missing.get(i);
                ans.add(Arrays.asList(first,last));
                first = missing.get(i+1);
            }
            
        }
        if(missing.size() != 0){
            if(missing.size() >= 2){
                    if((missing.get(missing.size()-2)+1) == missing.get(missing.size()-1)) {
                    last = missing.get(missing.size()-1);
                    ans.add(Arrays.asList(first,last));
                }else{
                        ans.add(Arrays.asList(missing.get(missing.size()-1) , missing.get(missing.size()-1)));
                }
            
            }else{
                ans.add(Arrays.asList(missing.get(missing.size()-1) , missing.get(missing.size()-1)));
            }
        }
        

        return ans;
    }
}