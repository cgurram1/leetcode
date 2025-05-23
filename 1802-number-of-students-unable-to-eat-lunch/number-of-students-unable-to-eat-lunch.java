class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int onesStudent = 0;
        int zerosStudent = 0;
        int onesPizza = 0;
        int zerosPizza = 0;
        for(int i = 0;i<sandwiches.length;i++){
            if(sandwiches[i] == 1){
                onesPizza+=1;
            }
            else{
                zerosPizza+=1;
            }
        }
        for(int i = 0;i<students.length;i++){
            queue.add(students[i]);
            if(students[i] == 1){
                onesStudent+=1;
            }
            else{
                zerosStudent+=1;
            }
        }
        int pizza = 0;
        while(!queue.isEmpty()){
            System.out.println(queue);
            if(queue.peek() == sandwiches[pizza]){
                if(queue.peek() == 1){
                    onesStudent-=1;
                    onesPizza-=1;
                }
                else{
                    zerosStudent-=1;
                    zerosPizza-=1;
                }
                queue.poll();
                pizza+=1;
            }
            else{
                if(sandwiches[pizza] == 1 && onesStudent == 0 || sandwiches[pizza] == 0 && zerosStudent == 0){
                    break;
                }
                queue.add(queue.poll());
            }
        }
        return queue.size();
    }
}