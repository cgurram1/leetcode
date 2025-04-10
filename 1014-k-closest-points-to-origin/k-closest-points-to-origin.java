class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [][] result = new int[k][2];
        for(int i = 0;i<points.length;i++){
            pq.add(new Pair(points[i][0],points[i][1]));
            if(pq.size() > k){
                pq.remove();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int y;
    double distanceFromOrigin;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
        this.distanceFromOrigin = Math.sqrt(x*x + y*y);
    }
    public int compareTo(Pair other){
        return Double.compare(this.distanceFromOrigin,other.distanceFromOrigin);
    }
}