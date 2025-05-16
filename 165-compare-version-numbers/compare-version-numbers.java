class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        int[] v1 = new int[v1Parts.length];
        for (int i = 0; i < v1Parts.length; i++) {
            v1[i] = Integer.parseInt(v1Parts[i]);
        }
        String[] v2Parts = version2.split("\\.");
        int[] v2 = new int[v2Parts.length];
        for (int i = 0; i < v2Parts.length; i++) {
            v2[i] = Integer.parseInt(v2Parts[i]);
        }
        int v1Len = v1Parts.length;
        int v2Len = v2Parts.length;
        int minLength = Math.min(v1Len,v2Len);
        for(int i = 0;i<minLength;i++){
            if(v1[i] > v2[i]){
                return 1;
            }
            else if(v1[i] < v2[i]){
                return -1;
            }
        }
        if(v1Len == v2Len){
            return 0;
        }
        else if(v1Len < v2Len){
            for(int i = v1Len;i<v2Len;i++){
                if(v2[i] > 0){
                    return -1;
                }
            }
        }
        else{
            for(int i = v2Len;i<v1Len;i++){
                if(v1[i] > 0){
                    return 1;
                }
            }
        }
        return 0;
    }
}