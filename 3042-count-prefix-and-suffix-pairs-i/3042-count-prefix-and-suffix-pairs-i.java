class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        for(int i = 0; i < n; i++){
            String word = words[i];

            for(int j = i+1; j < n; j++){
                if(words[j].startsWith(word) && 
                   words[j].endsWith(word)) {
                    count++;
                }
            }
        }
        return count;
    }
}