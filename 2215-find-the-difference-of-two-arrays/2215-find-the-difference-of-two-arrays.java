class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        HashSet<Integer> set= new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums1) set.add(num);
        for(int num : nums2) set2.add(num);

        List<Integer> temp = new ArrayList<>();
        for(int num : set){
            if(!set2.contains(num)) temp.add(num);
        }
        ans.add(temp);

        temp = new ArrayList<>();
        for(int num : set2){
            if(!set.contains(num)) temp.add(num);
        }
        ans.add(temp);
        return ans;
    }
}