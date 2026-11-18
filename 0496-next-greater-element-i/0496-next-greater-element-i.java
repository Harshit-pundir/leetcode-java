class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            map.put(nums2[i] , st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        n = nums1.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}