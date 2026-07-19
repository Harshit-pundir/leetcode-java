class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for(int i =0; i < s.length(); i++){
            last[s.charAt(i)-'a'] = i;
        }

        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(int i =0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(vis[curr-'a']) continue;

            while(!st.isEmpty() && curr < st.peek() && last[st.peek()-'a'] > i){
                vis[st.pop()-'a'] = false;
            }

            st.push(curr);
            vis[curr-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);;
        }

        return sb.toString();
    }
}