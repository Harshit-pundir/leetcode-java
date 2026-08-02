class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);

        int alice =0;
        int bob = 0;

        int i = piles.length-1;
        while(i >= 0){
            alice += piles[i];
            i--;
            bob += piles[i];
            i--;
        }

        return (alice > bob) ? true : false;
    }
}