class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> item : map.entrySet()){
            int num = item.getKey();
            int freq = item.getValue();
            pq.add(new Pair(num,freq));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] result = new int[k];
        int i = 0;
        for(Pair p : pq){
            result[i] = p.num;
            i++;
        }
        return result;
    }
}
class Pair implements Comparable<Pair>
{
    int num;
    int freq;
    public Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
    public int compareTo(Pair other){
        return this.freq - other.freq;
    }
}