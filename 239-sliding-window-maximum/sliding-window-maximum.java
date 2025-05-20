class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] result = new int[nums.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        int left = 0;
        int right = k-1;
        while(right < nums.length-1){
            while(!(pq.peek().index >= left && pq.peek().index <= right)){
                pq.poll();
            }
            result[left] = pq.peek().value;
            left++;
            right++;
            pq.add(new Pair(nums[right],right));
        }
        while(!(pq.peek().index >= left && pq.peek().index <= right)){
            pq.poll();
        }
        result[left] = pq.peek().value;
        return result;
    }
}
class Pair implements Comparable<Pair>{
    int value;
    int index;
    public Pair(int val, int index){
        this.value = val;
        this.index = index;
    }
    public int compareTo(Pair other){
        return other.value - this.value;
    }
}