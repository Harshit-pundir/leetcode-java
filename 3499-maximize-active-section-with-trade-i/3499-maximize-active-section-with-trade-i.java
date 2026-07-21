class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int totalOnes = 0;
        int previousZeroBlock = 0;
        int currentZeroBlock = 0;
        int bestGain = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '0') {
                currentZeroBlock++;
            } else {

                totalOnes++;

                if (currentZeroBlock > 0) {
                    bestGain = Math.max(bestGain,
                                        previousZeroBlock + currentZeroBlock);

                    previousZeroBlock = currentZeroBlock;
                    currentZeroBlock = 0;
                }
            }
        }

        // Check last zero block
        bestGain = Math.max(bestGain,
                            previousZeroBlock + currentZeroBlock);

        // If one side doesn't exist, no valid trade
        if (bestGain == previousZeroBlock ||
            bestGain == currentZeroBlock) {
            return totalOnes;
        }

        return totalOnes + bestGain;
    }
}