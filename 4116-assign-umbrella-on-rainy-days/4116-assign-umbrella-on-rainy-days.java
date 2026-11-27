class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] ans = new String[n];

        int aliceUmb = 0;
        int bobUmb = 0;
        for(int i = 0; i < n; i++){
            boolean isAlice = false;
            boolean isBob = false;
            if(i < n-1){
                if(rain[i] == 1 && rain[i+1] == 1){
                    isAlice = true;
                }
            }
            if(rain[i] == 1) isBob = true;
            if(isAlice && isBob){
                if(aliceUmb <=  bobUmb){
                    aliceUmb++;
                    ans[i] = "Alice";
                } 
                else{
                    bobUmb++;
                    ans[i] = "Bob";
                } 
            }else if(isAlice) {
                aliceUmb++;
                ans[i] = "Alice";
            }

            else if (isBob){
                bobUmb++;
                ans[i] = "Bob";
            }else{
                ans[i] = "None";
            }    
        }
        return ans;
    }
}