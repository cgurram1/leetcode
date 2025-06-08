class Solution {
    public List<Integer> result = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1;i<=9;i++){
            fun(i,n);
        }
        return this.result;
    }
    public void fun(int curr,int n){
        if(curr > n){
            return;
        }
        this.result.add(curr);
        for(int i = 0;i<10;i++){
            fun(curr * 10 + i,n);
        }
    }
}