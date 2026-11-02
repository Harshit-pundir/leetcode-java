class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for(int num : cardPoints){
            totalSum += num;
        }

        int window = n-k;
        int left = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            sum += cardPoints[right];

            while(right - left >= window){
                sum -= cardPoints[left];
                left++;
            }

            if(right - left + 1 == window){
                minSum = Math.min(sum,minSum);
            }
        }

        if(window == 0) return totalSum;

        return totalSum - minSum;
    }
}