class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int ans =  0;
        int trueCount = 0;
        int falseCount = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            char ch = answerKey.charAt(right);
            if(ch == 'T') trueCount++;
            else falseCount++;

            while(trueCount > k && falseCount > k){
                char ch1 = answerKey.charAt(left);
                left++;
                if(ch1 == 'T') trueCount--;
                else falseCount--;
            }

            ans = Math.max(ans,right - left+1);
        }

        return ans;
    }
}