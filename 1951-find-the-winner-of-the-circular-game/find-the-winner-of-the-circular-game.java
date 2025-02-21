class Solution {
    public int findTheWinner(int n, int k) {
        return rec(n,k) + 1;
    }
    public static int rec(int n,int k){
        if(n==1){
            return 0;
        }
        return (rec(n-1,k) + k) % n;
    }
}