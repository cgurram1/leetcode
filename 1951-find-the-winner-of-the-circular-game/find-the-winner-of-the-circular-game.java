class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<n+1;i++){
            q.add(i);
        }
        int toRemove = k % n;
        while(q.size() != 1){
            for(int i = 0;i<k-1;i++){
                q.add(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}