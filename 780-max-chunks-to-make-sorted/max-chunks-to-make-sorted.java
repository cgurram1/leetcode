class Solution {
    public int maxChunksToSorted(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        int prev = -1;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            curr = i;
            while(curr > prev && !pq.isEmpty() && pq.peek() == curr){
                pq.poll();
                curr-=1;
            }
            if(pq.isEmpty()){
                prev = i;
                count+=1;
            }
        }
        return count;
    }
}