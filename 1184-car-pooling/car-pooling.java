class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->{
            return a[1] - b[1];
        });
        int currentCap = capacity;
        PriorityQueue<PickUpInfo> dropOffs = new PriorityQueue<>(); 
        for(int i = 0;i<trips.length;i++){
            while(!dropOffs.isEmpty() && dropOffs.peek().dropLocation <= trips[i][1]){
                int dropCap = dropOffs.poll().people;
                currentCap += dropCap;
            }
            if(currentCap < trips[i][0]){
                return false;
            }
            else{
                currentCap -= trips[i][0];
                dropOffs.add(new PickUpInfo(trips[i][0],trips[i][2]));
            }
        }
        return true;
    }
}
class PickUpInfo implements Comparable<PickUpInfo>{
    int people;
    int dropLocation;
    public PickUpInfo(int p, int d){
        this.people = p;
        this.dropLocation = d;
    }
    public int compareTo(PickUpInfo other){
        return this.dropLocation - other.dropLocation;
    }
}