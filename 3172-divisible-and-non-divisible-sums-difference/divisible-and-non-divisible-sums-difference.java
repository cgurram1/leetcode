class Solution {
    public int differenceOfSums(int n, int m) {
        int num2 = 0;
        for(int i = 1;i<=n;i++){
            if(i%m == 0){
                num2+=i;
            }
            else{
                num2-=i;
            }
        }
        return -1*num2;
    }
}