class Solution {
    public List<List<Integer>> result;
    public int N;
    public int K;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        N = n;
        K = k;
        fun(1,0,new ArrayList<>());
        return result;
    }
    public void fun(int index, int sum,List<Integer> curr){
        if(sum == N && curr.size() == K){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index > 9){
            return;
        }
        curr.add(index);
        fun(index + 1, sum + index,curr);
        curr.remove(curr.size()-1);
        fun(index + 1, sum, curr);
    }
}