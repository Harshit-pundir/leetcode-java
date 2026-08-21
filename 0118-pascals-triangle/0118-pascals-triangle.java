class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0; i<numRows; i++){
            int num =1;
            List<Integer> result = new ArrayList<>();
            result.add(num);
            for(int j =0; j<=i; j++){
                num = num * (i - j)/(j+1);
                if(num != 0) result.add(num);
            }

            ans.add(result);
        }
        return ans;
    }
}