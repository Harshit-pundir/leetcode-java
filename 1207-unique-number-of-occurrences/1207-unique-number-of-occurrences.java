class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> freq = new HashSet<>();

        for(int num : arr) map.put(num,map.getOrDefault(num,0)+1);
        for(int fq : map.values()){
            if(freq.contains(fq)) return false;
            freq.add(fq);
        }

        return true;
    }
}