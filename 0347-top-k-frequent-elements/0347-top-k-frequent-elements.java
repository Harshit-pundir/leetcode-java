class Solution {
    class Pair{
        int num;
        int freq ;

        Pair(int num , int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums) map.put(num,map.getOrDefault(num,0)+1);

        for(int num : map.keySet()){
            int freq = map.get(num);

            pq.offer(new Pair(num,freq));
        }

        int[] ans = new int[k];
        int i =0;

        while(!pq.isEmpty() && k-- > 0){
            Pair curr = pq.poll();
            ans[i++] = curr.num;
        } 

        return ans;
    }
}