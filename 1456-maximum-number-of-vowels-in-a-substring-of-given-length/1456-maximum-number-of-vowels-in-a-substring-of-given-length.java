class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        char[] word = {'a','e','i','o','u'};
        HashSet<Character> vowels = new HashSet<>();
        for(char ch : word) vowels.add(ch);
        
        for(int i =0; i <k; i++){
            if(vowels.contains(s.charAt(i))) count++;
        }

        int ans =count;
        for(int i = k; i <n; i++){
            char ch = s.charAt(i-k);
            if(vowels.contains(ch)) count--;
            if(vowels.contains(s.charAt(i))) count++;

            ans = Math.max(ans,count);
        }

        return ans;
    }
}