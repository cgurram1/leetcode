import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE); // Initialize with max value
        mins[n - 1] = 0; // Last position needs 0 jumps to reach itself

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) continue; // Skip if no jump possible
            
            int minJump = Integer.MAX_VALUE;
            int maxJump = Math.min(i + nums[i], n - 1); // Avoid going out of bounds
            
            for (int j = i + 1; j <= maxJump; j++) {
                if (mins[j] != Integer.MAX_VALUE) { // Only check reachable positions
                    minJump = Math.min(minJump, mins[j]);
                }
            }

            if (minJump != Integer.MAX_VALUE) {
                mins[i] = minJump + 1;
            }
        }
        return mins[0];
    }
}
