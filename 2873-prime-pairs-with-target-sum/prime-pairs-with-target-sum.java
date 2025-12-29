class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        // Set<Integer> primes = new HashSet<>();
        // PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->{
        //     return a.get(0) - b.get(0);
        // });
        // int flag = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 2;i<=n/2;i++){
            if(isPrime(i) && isPrime(n-i)){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                result.add(temp);
            }
        }
        // while(pq.isEmpty() == false){
        //     result.add(pq.poll());
        // }
        // if(flag == 1){
        //     List<Integer> temp = new ArrayList<>();
        //     temp.add((int)(n/2));
        //     temp.add((int)(n/2));
        //     result.add(temp);
        // }
        return result;
    }
    public boolean isPrime(int n){
        if(n == 2 || n == 3){
            return true;
        }
        for(int i = 2;i*i<=n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}