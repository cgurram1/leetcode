/**

[1,-1,2,-2,3,-3]


 */
class Solution {
    public long maxAlternatingSum(int[] nums) {
        long totalSum = 0;
        Long [] numsI = new Long[nums.length];
        for(int i = 0;i<nums.length;i++){
            numsI[i] = (long)nums[i];
            totalSum += ((long)nums[i]*(long)nums[i]);
            // System.out.println(nums[i]);
        }
        // System.out.println(totalSum);
        Arrays.sort(numsI, (a,b)->{
            return (int)(Math.abs(a) - Math.abs(b));
        });
        for(int i = 0;i<numsI.length/2;i++){
            // System.out.print(numsI[i] + " ");
            totalSum -= 2*(numsI[i]*numsI[i]);
        }
        // for(int i = 0;i<numsI.length;i++){
        //     System.out.print(numsI[i] + " ");
        // }
        // System.out.println(totalSum);
        return totalSum;
    }
}