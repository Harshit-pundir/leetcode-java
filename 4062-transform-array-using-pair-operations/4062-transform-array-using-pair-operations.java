class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sum1 = 0;
        long sum2 = 0;

        for(int num : source) sum1 += num;
        for(int num : target) sum2 += num;

        return sum1 == sum2;
    }
}