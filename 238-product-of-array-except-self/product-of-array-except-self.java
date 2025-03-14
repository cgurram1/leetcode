import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute Prefix Products and Store in Result
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute Suffix Product and Multiply with Prefix in Result
        int suffix = 1; // Holds suffix product dynamically
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;  // Multiply prefix by suffix
            suffix *= nums[i];    // Update suffix product
        }
        return result;
    }
}
