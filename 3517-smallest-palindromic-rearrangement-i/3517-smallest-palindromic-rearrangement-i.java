class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        char[] res = new char[s.length()];
        int left = 0 , right = s.length()-1;

        for(int  i = 0; i<freq.length; i++){
            char ch = (char) ('a' + i);
            while(freq[i] >= 2){
                res[left] = ch;
                left++;

                res[right] = ch;
                right--;
                freq[i] -= 2;
            }
            if(freq[i] == 1)
                res[res.length/2] = ch;
            
        }
        return new String(res);

    }
}