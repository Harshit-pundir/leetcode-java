class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res = new ArrayList<>();

        int n = list1.length;
        int m = list2.length;
        int min = Integer.MAX_VALUE;
        HashMap<String,Integer> map = new HashMap<>();
        int i = 0;
        for(String word : list1){
            map.put(word,i);
            i++;
        }
        int j = 0;
        for(String word : list2){
            if(map.containsKey(word)){
                int val = map.get(word);
                if(val + j < min){
                    min = val + j;
                    res.clear();
                    res.add(word);
                }else if(val + j == min){
                    res.add(word);
                }
            }
            j++;
        }
        String[] ans = new String[res.size()];
        i = 0;
        for(String word : res){
            ans[i++] = word;
        }

        return ans;
    }
}