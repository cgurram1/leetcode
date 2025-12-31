/**

start = "_L__R__R_", target = "L______RR"

[(L,1)(R,4)(R,7)]
[(L,0)(R,6)(R,7)]

 */
class Pair{
    char c;
    int index;
    public Pair(char c, int index){
        this.c = c;
        this.index = index;
    }
} 
class Solution {
    public boolean canChange(String start, String target) {
        if(start.length() != target.length()){
            return false;
        }
        Queue<Pair> startQueue = new LinkedList<>();
        Queue<Pair> targetQueue = new LinkedList<>();
        for(int i = 0;i<start.length();i++){
            if(start.charAt(i) != '_'){
                startQueue.add(new Pair(start.charAt(i),i));
            }
        }
        for(int i = 0;i<target.length();i++){
            if(target.charAt(i) != '_'){
                targetQueue.add(new Pair(target.charAt(i),i));
            }
        }
        if(targetQueue.size() != startQueue.size()){
            return false;
        }

        while(startQueue.isEmpty() == false){
            Pair startP = startQueue.poll();
            Pair targetP = targetQueue.poll();
            if(startP.c != targetP.c){
                return false;
            }
            else{
                if(startP.c == 'L'){
                    if(startP.index < targetP.index){
                        return false;
                    }
                }
                else{
                    if(startP.index > targetP.index){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}