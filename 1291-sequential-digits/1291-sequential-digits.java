class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        
        for(int i =1;  i<=9; i++){
            generateNum(i,low,high);
        }

        Collections.sort(ans);
        return ans;
    }

    public void generateNum(int num , int low , int high){
        if(num > high) return;
        if(num >= low) ans.add(num);

        int lastDigit = num % 10;
        if(lastDigit == 9) return;
        int newNum = num * 10 + (lastDigit +1 );
        generateNum(newNum,low,high);

    }
}