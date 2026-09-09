class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()) ans.add(0);
            else ans.add(Math.abs(i-st.peek()));

            st.push(i);
        }

        int[] res = new int[n];
        Collections.reverse(ans);
        for(int i =0; i<n; i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}