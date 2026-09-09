class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];

        for(int i =0; i < n; i++){
            arr[i][0] = nums2[i];
            arr[i][1] = nums1[i];
        }

        Arrays.sort(arr , (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum =0;
        long ans =0;

        for(int i = 0; i < n; i++){
            int num2 = arr[i][0];
            int num1 = arr[i][1];

            pq.offer(num1);
            sum += num1;

            if(pq.size() > k){
                sum -= pq.poll();
            }

            if(pq.size() == k){
                ans = Math.max(ans,sum * num2);
            }

        }

        return ans;
    }
}