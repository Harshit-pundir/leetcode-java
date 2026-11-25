class Solution {
    public int[] findPSE(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] findPGE(int[] nums) {
        int n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pge;
    }

    public int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] pse = findPSE(nums);
        int[] nse = findNSE(nums);
        int[] pge = findPGE(nums);
        int[] nge = findNGE(nums);

        long minSum = 0;
        long maxSum = 0;

        for(int i = 0; i < n; i++) {

            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;

            minSum += leftMin * rightMin * nums[i];

            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;

            maxSum += leftMax * rightMax * nums[i];
        }

        return maxSum - minSum;
    }
}