class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n == 1) return 0;
        char mn = 'z';
        char mx = 'a';

        boolean sorted = true;

        for(int i = 0; i < s.length(); i++){
            mn = (char)Math.min(s.charAt(i),mn);
            mx = (char)Math.max(s.charAt(i),mx);
            if(i > 0 && s.charAt(i) < s.charAt(i-1)){
                sorted = false;
            }
        }

        if(sorted) return 0;

        if(n == 2) return -1;

        if(mn == s.charAt(0) || mx == s.charAt(n-1)) return 1;
        
        for(int i = 1; i < s.length()-1; i++){
            if(mn == s.charAt(i) || mx == s.charAt(i)) return 2;
        }
        return 3;
    }
}