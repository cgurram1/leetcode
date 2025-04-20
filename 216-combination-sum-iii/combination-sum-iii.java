class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        fun(1,new ArrayList<>(), 0,n,result,k);
        return result;
    }
    public void fun(int index, List<Integer> path, int sum,int n, List<List<Integer>> result, int k){
        if(sum == n && path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        if(index > 9){
            return;
        }
        path.add(index);
        fun(index+1, path, sum + index, n,result,k);
        path.remove(path.size()-1);
        fun(index + 1, path, sum,n,result,k);
    }
}