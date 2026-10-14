class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";

        int rem = sum % 9;
        int nines = sum / 9;

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nines; i++){
            ans.append('9');
        }

        if(rem > 0){
            ans.append((char)('0'+rem));
        }
        int zeroes = num - ans.length();

        for(int i = 0; i < zeroes; i++){
            ans.append('0');
        }
        
        return ans.toString();
    }
}