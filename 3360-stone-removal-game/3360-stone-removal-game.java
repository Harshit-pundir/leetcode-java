class Solution {
    public boolean canAliceWin(int n) {
        if(n <= 9) return false;
        boolean isAlice = true;
        int curr = 10;

        while(true){
            if(isAlice){
                if(n < curr) return false;
                isAlice = false;
                n -= curr;
                curr--;
            }else{
                if(n < curr) return true;
                isAlice = true;
                n -= curr;
                curr--;
            }
        }

    }
}