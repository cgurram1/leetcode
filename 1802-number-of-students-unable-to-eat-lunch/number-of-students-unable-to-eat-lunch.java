class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int onesStudent = 0;
        int zerosStudent = 0;
        for(int i = 0;i<students.length;i++){
            queue.add(students[i]);
            if(students[i] == 1){
                onesStudent+=1;
            }
            else{
                zerosStudent+=1;
            }
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 1) {
                if (onesStudent > 0) onesStudent--;
                else break;
            } else {
                if (zerosStudent > 0) zerosStudent--;
                else break;
            }
        }
        return onesStudent + zerosStudent;
    }
}