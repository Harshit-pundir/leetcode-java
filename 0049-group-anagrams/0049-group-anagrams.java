class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String> > map = new HashMap<>();

        for(String word : strs){
            char[] arr =  word.toCharArray();
            Arrays.sort(arr);
            String newWord = new String(arr);

            if(map.containsKey(newWord)){
                map.get(newWord).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(newWord , list);
            }
        }

        for(List<String> words : map.values()) ans.add(words);
        return ans;
    }
}