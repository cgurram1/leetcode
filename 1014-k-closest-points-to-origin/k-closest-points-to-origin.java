class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int [] point : points){
            pq.add(new Pair(point));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll().coordinate;
            i++;
        }
        return res;
    }
}
class Pair implements Comparable<Pair>{
    int [] coordinate;
    double dist;
    public Pair(int [] point){
        coordinate = point;
        dist = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
    }

    public int compareTo(Pair other){
        return this.dist - other.dist > 0 ? 1:-1;
    }

}