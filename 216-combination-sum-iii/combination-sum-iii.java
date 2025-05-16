class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        fun(0,0,new ArrayList<>(),n,k);
        return this.result;
    }
    public void fun(int index,int sum,List<Integer> curr,int n,int k){
        if(sum > n || curr.size() > k){
            return;
        }
        if(sum == n){
            if(curr.size() == k){
                this.result.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = index+1;i<=9;i++){
            curr.add(i);
            fun(i, sum + i,curr,n,k);
            curr.remove(curr.size()-1);
        }
    }
}