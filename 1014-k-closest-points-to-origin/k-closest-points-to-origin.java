public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length - 1, k);
        // Return the first k points (now the k closest are anywhere in points[0..k-1])
        return Arrays.copyOf(points, k);
    }

    private void quickselect(int[][] pts, int lo, int hi, int k) {
        if (lo >= hi) return;

        // pick pivot index as the middle via integer division
        int midIndex = (lo + hi) / 2;
        int pivotDist = distSq(pts[midIndex]);

        int i = lo, j = hi;
        while (i <= j) {
            // move i forward while pts[i] is closer than pivot
            while (distSq(pts[i]) < pivotDist) {
                i++;
            }
            // move j backward while pts[j] is farther than pivot
            while (distSq(pts[j]) > pivotDist) {
                j--;
            }
            if (i <= j) {
                swap(pts, i, j);
                i++;
                j--;
            }
        }

        // Now all points in [lo..j] have dist ≤ pivot, and [i..hi] have dist ≥ pivot
        if (k - 1 <= j) {
            quickselect(pts, lo, j, k);       // target is in the left partition
        } else if (k - 1 >= i) {
            quickselect(pts, i, hi, k);       // target is in the right partition
        }
        // otherwise, we've partitioned such that exactly k points in [lo..hi]
    }

    private int distSq(int[] p) {
        // squared Euclidean distance from origin
        return p[0]*p[0] + p[1]*p[1];
    }

    private void swap(int[][] pts, int i, int j) {
        int[] tmp = pts[i];
        pts[i] = pts[j];
        pts[j] = tmp;
    }
}
