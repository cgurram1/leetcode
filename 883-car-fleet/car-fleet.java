class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0;i<position.length;i++){
            arr.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(arr);
        double [] times = new double[arr.size()];
        int i = 0;
        for(Pair p : arr){
            times[i] = (double)(target - p.position) / p.speed;
            // System.out.println(times[i] + " " + (target - p.position) + " " + p.speed);
            i++;
        }
        double currMax = times[times.length-1];
        int count = 1;
        for(i = times.length-1;i>=0;i--){
            if(times[i] > currMax){
                currMax = times[i];
                count+=1;
            }
        }
        return count;
    }

}
class Pair implements Comparable<Pair>{
    int position;
    int speed;
    public Pair(int p, int s){
        this.position = p;
        this.speed = s;
    }

    @Override
    public int compareTo(Pair other){
        return this.position - other.position;
    }
}