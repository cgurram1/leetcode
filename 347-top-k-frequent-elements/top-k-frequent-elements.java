class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> {return b.getValue() - a.getValue();});
        for(Map.Entry<Integer,Integer> item : freq.entrySet()){
            pq.add(item);
        }
        int [] res = new int[k];
        int i = 0;
        while(i < k){
            res[i] = pq.poll().getKey();
            i++;
        }
        return res;
    }
}