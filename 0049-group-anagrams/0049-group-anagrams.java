class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String> > map = new HashMap<>();

        for(String word : strs){
            char[] arr =  word.toCharArray();
            Arrays.sort(arr);
            String newWord = new String(arr);

            if(!map.containsKey(newWord)){
                map.put(newWord , new ArrayList<>());
            
            }
            map.get(newWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}