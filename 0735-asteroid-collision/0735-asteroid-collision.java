class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int num : asteroids) {

            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && num < 0) {

                if (st.peek() < Math.abs(num)) {
                    st.pop();
                } 
                else if (st.peek() == Math.abs(num)) {
                    st.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(num);
            }
        }

        int[] arr = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            arr[i] = st.get(i);
        }

        return arr;
    }
}