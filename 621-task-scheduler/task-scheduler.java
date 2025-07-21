class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freqs = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {return b.freq - a.freq;});
        for(int i = 0;i<tasks.length;i++){
            freqs[tasks[i] - 'A']+=1;
        }
        Queue<Pair> list = new LinkedList<>();
        for(int i = 0;i<26;i++){
            if(freqs[i] > 0){
                list.add(new Pair((char)(i + 'A'),freqs[i]));
            }
        }
        int curr;
        int res = 0;
        while(list.size() > 0 || pq.size() > 0){
            curr = n;
            while(!list.isEmpty()){
                pq.add(list.poll());
            }
            while(curr >= 0){
                if(!pq.isEmpty()){
                    Pair p = pq.poll();
                    p.freq -=1;
                    if(p.freq > 0){
                        list.add(p);
                    }
                }
                if(list.size() == 0 && pq.size() == 0){
                    return res+1;
                }
                res+=1;
                curr-=1;
            }
        }
        return res;
    }
}
class Pair{
    char ch;
    int freq;
    public Pair(char c, int f){
        this.ch = c;
        this.freq = f;
    }
}