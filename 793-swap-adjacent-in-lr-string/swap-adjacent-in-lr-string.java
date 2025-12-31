/**

start = "RXXLRRX", result = "XRLXXXR"

R:0
L:3
R:4
R:6
L:8




R:1
L:2
R:5
R:6
L:7

 */

class Pair{
    char c;
    int index;
    public Pair(char c, int i){
        this.c = c;
        this.index = i;
    }
} 
class Solution {
    public boolean canTransform(String start, String result) {
        if(start.length() != result.length()){
            return false;
        }
        Queue<Pair> startQ = new LinkedList<>();
        Queue<Pair> targetQ = new LinkedList<>();
        for(int i = 0;i<start.length();i++){
            if(start.charAt(i) != 'X'){
                startQ.add(new Pair(start.charAt(i),i));
            }
        }
        for(int i = 0;i<result.length();i++){
            if(result.charAt(i) != 'X'){
                targetQ.add(new Pair(result.charAt(i),i));
            }
        }
        if(startQ.size() != targetQ.size()){
            return false;
        }
        while(startQ.size() > 0){
            Pair startPoll = startQ.poll();
            Pair targetPoll = targetQ.poll();
            if(startPoll.c != targetPoll.c){
                return false;
            }
            else{
                if(startPoll.c == 'L'){
                    if(startPoll.index < targetPoll.index){
                        return false; 
                    }
                }
                else{
                    if(startPoll.index > targetPoll.index){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}