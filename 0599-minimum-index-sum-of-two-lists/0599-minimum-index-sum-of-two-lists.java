class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res = new ArrayList<>();

        int n = list1.length;
        int m = list2.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(list1[i].equals(list2[j])){
                    if(i + j < min){
                        min = i+j;
                        res.clear();
                        res.add(list1[i]);
                    }else if(i + j == min){
                        res.add(list1[i]);
                    }
                }
            }
        }
        String[] ans = new String[res.size()];
        int i = 0;
        for(String word : res){
            ans[i++] = word;
        }

        return ans;
    }
}