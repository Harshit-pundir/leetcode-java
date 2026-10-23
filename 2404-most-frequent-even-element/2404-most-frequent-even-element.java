class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(num % 2 == 0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        int maxFreq = 0;
        int maxNum = Integer.MAX_VALUE;

        for(int num : map.keySet()){
            int fq = map.get(num);
            if(fq == maxFreq) maxNum = Math.min(num,maxNum);
            else if(fq > maxFreq){
                maxFreq = fq;
                maxNum = num;
            }
        }

        return map.isEmpty() ? -1 : maxNum;
    }
}