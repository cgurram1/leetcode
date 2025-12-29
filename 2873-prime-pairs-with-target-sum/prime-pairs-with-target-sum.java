/**

[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
[0,1,2,,4,,6,,8,9,10,,12,,14,15,16,,18,19]

 */
class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        int [] primes = new int[n+1];
        Arrays.fill(primes,-1);
        for(int i = 2;i<=n;i++){
            if(primes[i] == -1){
                int mul = 2;
                while(i * mul <= n){
                    primes[i*mul] = i*mul;
                    mul+=1;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 2;i<=n/2;i++){
            if(primes[i] == -1 && primes[n-i] == -1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                result.add(temp);
            }
        }
        return result;
    }
}