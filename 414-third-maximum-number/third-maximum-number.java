class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int item : set){
            pq.add(item);
            if(pq.size() > 3){
                pq.poll();
            }
        }
        if(pq.size() >= 3 || pq.size() == 1){
            return pq.peek();
        }
        pq.poll();
        return pq.peek();
    }
}