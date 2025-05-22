class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int one = m - 1;
        int two = n - 1;
        int edit = m + n - 1;

        while (one >= 0 && two >= 0) {
            if (nums1[one] > nums2[two]) {
                nums1[edit--] = nums1[one--];
            } else {
                nums1[edit--] = nums2[two--];
            }
        }
        while (two >= 0) {
            nums1[edit--] = nums2[two--];
        }
    }
}
