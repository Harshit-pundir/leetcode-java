class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int n = s.length();
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            while(map.containsKey(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxLen = Math.max(maxLen , right - left+1);
        }

        return maxLen;
    }
}