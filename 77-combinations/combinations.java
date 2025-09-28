class Solution {
    public List<List<Integer>> result;
    public int N;
    public int K;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        N = n;
        K = k;
        fun(new ArrayList<>(),1);
        return result;
    }
    public void fun(List<Integer> curr, int index){ 
        if(curr.size() == K){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index > N || curr.size() > K){
            return;
        }
        curr.add(index);
        fun(curr,index+1);
        curr.remove(curr.size()-1);
        fun(curr,index + 1);
    }
}