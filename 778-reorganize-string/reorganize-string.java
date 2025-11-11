class Solution {
    public String reorganizeString(String s) {
        List<Character> resList = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue();
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0) + 1);
        }
        for(Map.Entry<Character, Integer> item : freq.entrySet()){
            pq.add(new Pair(item.getKey(), item.getValue()));
        }   
        Pair prev = pq.poll();
        resList.add(prev.c);
        prev.f-=1;
        while(pq.isEmpty() == false){
            Pair current = pq.poll();
            resList.add(current.c);
            current.f-=1;
            if(prev.f > 0){
                pq.add(prev);
            }
            prev = current;
        }
        if(resList.size() != s.length()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : resList) sb.append(ch);
        return sb.toString();
    }
}
class Pair implements Comparable<Pair>{
    public char c;
    public int f;
    public Pair(char c, int f){
        this.c = c;
        this.f = f;
    }
    public int compareTo(Pair other){
        return other.f - this.f;
    }
}