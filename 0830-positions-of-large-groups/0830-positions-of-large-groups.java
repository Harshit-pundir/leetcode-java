class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        if(s.length() <= 2) return ans;
        int i = 1;
        int n = s.length();
        int start = 0;
        int end = 0;
        while(i < n){
            if(s.charAt(i-1) == s.charAt(i)){
                end = i;
            }else{
                if(((end - start) +1) >= 3){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    ans.add(list);
                }
                start = i;
                end = i;
            }
            i++;
        }
        if((end - start )+ 1 >= 3){
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            ans.add(list);
        }

        return ans;
    }
}