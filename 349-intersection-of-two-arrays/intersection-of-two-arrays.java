class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int up = 0;
        int down = 0;
        int lastAdded = -1;
        while(up < nums1.length && down < nums2.length){
            if(nums1[up] == nums2[down]){
                if(lastAdded == -1 || nums1[up] != lastAdded){
                    list.add(nums1[up]);
                    lastAdded = nums1[up];
                }
                up+=1;
                down+=1;
            }
            else{
                if(nums1[up] < nums2[down]){
                    up+=1;
                }
                else{
                    down+=1;
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}